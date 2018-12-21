package com.ccsbi.co.usermanagement.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	@Transactional
	public Users save(Users users) throws Exception {

		List<AddressDetails> addressDetailsList = users.getAddressDetailsList();
		Iterator<AddressDetails> itr = addressDetailsList.iterator();

		UsersDetails userDetails = users.getUsersDetails();

		if (users != null) {

			String userName = userNameGeneratorService.userNameGen(users.getFirstName(), users.getLastName());
			users.setUserName(userName);

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

		}

		return users;

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

	@Override
	public int changePassword(String userName, String password) {
		Users users = new Users();
		int update = 0;

		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
			users = convertUsers(usersRepo.loginUser(userName));
			
			com.ccsbi.co.usermanagement.repository.entity.UsersDetails usersDetails = usersDetailsRepo.getUsersDetails(users.getUserId());
			System.out.println("Hello");
			if (usersDetails!=null) {
				update = usersDetailsRepo.updateusersDetails(users.getUserId(), password);
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


}
