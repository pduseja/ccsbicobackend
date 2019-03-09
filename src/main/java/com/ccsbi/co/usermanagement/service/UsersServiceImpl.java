package com.ccsbi.co.usermanagement.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.config.Appconfig;
import com.ccsbi.co.usermanagement.email.IEmailService;
import com.ccsbi.co.usermanagement.repository.UsersDetailsRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.AddressDetails;
import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersDetails;
import com.ccsbi.co.usermanagement.util.ReallyStrongSecuredPassword;

@Transactional
@Service
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	AddressDetailsServiceImpl addressDetailsService;

	@Autowired
	UsersDetailsServiceImpl usersDetailsServiceImpl;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	UsersDetailsRepo usersDetailsRepo;

	@Autowired
	UserNameGeneratorService userNameGeneratorService;

	@Autowired
	ReallyStrongSecuredPassword reallyStrongSecuredPassword;

	@Autowired
	IEmailService iEmailService;

	@Autowired
	IAddressDetailsService addressDetailsServiceImpl;

	@Autowired
	Appconfig appConfig;

	@Override
	@Transactional
	public Users save(Users users) throws Exception {

		List<AddressDetails> addressDetailsList = users.getAddressDetailsList();
		Iterator<AddressDetails> itr = addressDetailsList.iterator();

		UsersDetails userDetails = users.getUsersDetails();

		if (users != null) {

			String userName = userNameGeneratorService.userNameGen(users.getFirstName(), users.getLastName());
			users.setUserName(userName);
			users.setProfileId(1);
			users.setActive("N");

			users = convertUsers(usersRepo.save(convertU(users)));

			while (itr.hasNext()) {
				AddressDetails addressDetails1 = (AddressDetails) itr.next();
				AddressDetails addressDetails = new AddressDetails();
				addressDetails = populateAddressDetails(addressDetails, addressDetails1);
				addressDetails.setUsers(users);
				addressDetailsService.save(addressDetails);
			}

			if (!StringUtils.isEmpty(userDetails.getMemorableWord())) {
				userDetails.setUserId(users.getUserId());
				String encryptPassword = reallyStrongSecuredPassword.encrypt(userDetails.getPassword());
				String encryptMemorableWord = reallyStrongSecuredPassword.encrypt(userDetails.getMemorableWord());
				String encryptSecurityAnswer1 = reallyStrongSecuredPassword.encrypt(userDetails.getSecurityAnswer1());
				String encryptSecurityAnswer2 = reallyStrongSecuredPassword.encrypt(userDetails.getSecurityAnswer2());
				userDetails.setPassword(encryptPassword);
				userDetails.setMemorableWord(encryptMemorableWord);
				userDetails.setSecurityAnswer1(encryptSecurityAnswer1);
				userDetails.setSecurityAnswer2(encryptSecurityAnswer2);
				userDetails.setIsTempPassword('N');
				userDetails.setAccountLocked("N");
				userDetails = usersDetailsServiceImpl.save(userDetails);
			}
			// Registration Email
			AddressDetails addressDetails = addressDetailsServiceImpl.getAddressDetails(users.getUserId());

			String to = addressDetails.getEmail()!= null ?addressDetails.getEmail() : "";
			String subject = "Registration confirmation with CCSBI";
			String text = "Your are now registered with our site!\n" + "Your username is '" + users.getUserName()
					+ "' We will inform you once your account is verified and activated!!";
			if (!StringUtils.isEmpty(to)) {
				if (appConfig.getEmail().equalsIgnoreCase("YES")) {
					iEmailService.sendRegistrationMail(to, subject, text);
				}
			} else {
				String mobile = addressDetails.getMobile();
				if (appConfig.getSms().equalsIgnoreCase("YES")) {
					
					// Add logic to send SMS
				}
			}
		

	}

	return users;

	}

	@Override
	public Users update(Users user) {
		int update = 0;
		String userName = user.getUserName();
		int userid = usersRepo.getUserId(userName);
		int numberOfAddress = addressDetailsService.sizeOfAddressList(userid);

		List<AddressDetails> addressDetailsList = user.getAddressDetailsList();
		Iterator<AddressDetails> itr = addressDetailsList.iterator();
		int updateAddress = 0;
		if (numberOfAddress == addressDetailsList.size()) {
			while (itr.hasNext()) {
				AddressDetails addressDetails1 = (AddressDetails) itr.next();
				AddressDetails addressDetails = new AddressDetails();
				addressDetails = populateAddressDetails(addressDetails, addressDetails1);
				addressDetails.setId(addressDetails1.getId());
				updateAddress = addressDetailsService.update(addressDetails, userid);
				System.out.println("Updated: " + updateAddress + " id= " + addressDetails.getId());
			}
		} else {
			while (itr.hasNext()) {
				AddressDetails addressDetails1 = (AddressDetails) itr.next();
				AddressDetails addressDetails = new AddressDetails();
				if (addressDetails1.getId() > 0) {
					addressDetails = populateAddressDetails(addressDetails, addressDetails1);
					addressDetails.setId(addressDetails1.getId());
					updateAddress = addressDetailsService.update(addressDetails, userid);
					System.out.println("Updated: " + updateAddress + " id= " + addressDetails.getId());
				} else {
					addressDetails = populateAddressDetails(addressDetails, addressDetails1);
					addressDetails.setId(addressDetails1.getId());
					user.setUserId(userid);
					addressDetails.setUsers(user);
					addressDetailsService.save(addressDetails);
					System.out.println("Updated: " + updateAddress + " id= " + addressDetails.getId());

				}
			}

		}

		if (updateAddress > 0) {
			addressDetailsList = addressDetailsService.getAddressList(userid);
			user.setAddressDetailsList(addressDetailsList);
			user.setUserId(userid);
			return user;
		} else {
			return new Users();
		}

	}

	@Override
	public Users updateSecurityDetails(Users user) {
		int update = 0;
		UsersDetails userDetails = user.getUsersDetails();
		String userName = user.getUserName();
		int userid = usersRepo.getUserId(userName);

		if (!StringUtils.isEmpty(userDetails.getMemorableWord())) {

			String encryptMemorableWord = reallyStrongSecuredPassword.encrypt(userDetails.getMemorableWord());
			String encryptSecurityAnswer1 = reallyStrongSecuredPassword.encrypt(userDetails.getSecurityAnswer1());
			String encryptSecurityAnswer2 = reallyStrongSecuredPassword.encrypt(userDetails.getSecurityAnswer2());

			userDetails.setMemorableWord(encryptMemorableWord);
			userDetails.setSecurityAnswer1(encryptSecurityAnswer1);
			userDetails.setSecurityAnswer2(encryptSecurityAnswer2);
			update = usersDetailsServiceImpl.updateUsersDetails(userDetails, userid);
			UsersDetails usersD = new UsersDetails();
		}
		if (update > 0) {
			userDetails = usersDetailsServiceImpl.getUsersDetails(userName);
			user.setUserId(userid);
			user.setUsersDetails(userDetails);
			return user;
		} else {
			return new Users();
		}
	}

	@Override
	public int changePassword(String userName, String password) {
		Users users = new Users();
		int update = 0;

		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
			users = convertUsers(usersRepo.loginUser(userName));

			com.ccsbi.co.usermanagement.repository.entity.UsersDetails usersDetails = usersDetailsRepo
					.getUsersDetails(users.getUserId());
			System.out.println("Hello");
			if (usersDetails != null) {
				String encryptPassword = reallyStrongSecuredPassword.encrypt(password);
				update = usersDetailsRepo.updateusersDetails(users.getUserId(), encryptPassword);
				if (update == 0) {
					return 0;
				} else {
					return update;
				}
			} else {
				return 0;
			}
		}
		return update;
	}

	@Override
	public int updatePhoto(Users user) {
		int update = 0;
		String userName = user.getUserName();
		int userid = usersRepo.getUserId(userName);

		update = usersRepo.updatePhoto(userid, user.getPhotoId());

		return update;
	}

	@Override
	public Users loadUserByUsername(String username) throws Exception {
		Users user = convertUsers(usersRepo.findByUsername(username));
        if (user == null) {
            throw new Exception(String.format("User %s does not exist!", username));
        }
        return new Users();
	}
	
	private AddressDetails populateAddressDetails(AddressDetails addressDetails, AddressDetails addressDetails1) {

		addressDetails.setActive(addressDetails1.getActive());
		addressDetails.setAddressLine1(addressDetails1.getAddressLine1());
		addressDetails.setAddressLine2(addressDetails1.getAddressLine2());
		addressDetails.setAddressLine3(addressDetails1.getAddressLine3());
		addressDetails.setCityTown(addressDetails1.getCityTown());
		addressDetails.setCountry(addressDetails1.getCountry());
		addressDetails.setEmail(addressDetails1.getEmail());
		addressDetails.setFlatNo(addressDetails1.getFlatNo());
		addressDetails.setHouseName(addressDetails1.getHouseName());
		addressDetails.setLandline(addressDetails1.getLandline());
		addressDetails.setMobile(addressDetails1.getMobile());
		addressDetails.setModDate(addressDetails1.getModDate());
		addressDetails.setPinPostCode(addressDetails1.getPinPostCode());
		addressDetails.setStateProvince(addressDetails1.getStateProvince());
		addressDetails.setSysDate(addressDetails1.getSysDate());
		addressDetails.setType(addressDetails1.getType());

		return addressDetails;
	}

	private Users convertUsers(com.ccsbi.co.usermanagement.repository.entity.Users users) {

		return dozerMapper.map(users, Users.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.Users convertU(Users users) {

		return dozerMapper.map(users, com.ccsbi.co.usermanagement.repository.entity.Users.class);
	}

	

}
