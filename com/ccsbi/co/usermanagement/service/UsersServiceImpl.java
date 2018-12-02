package com.ccsbi.co.usermanagement.service;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.AddressDetails;
import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersDetails;
import com.ccsbi.co.usermanagement.service.model.UsersPhoto;

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
	UserNameGeneratorService userNameGeneratorService;

	@Override
	@Transactional
	public Users save(Users users) throws Exception {

		AddressDetails addressDetails;
		UsersPhoto usersPhoto;
		UsersDetails userDetails;

		if (users != null) {

			usersPhoto = users.getUsersPhoto();
			// AddressDetails
			addressDetails = users.getAddressDetails();

			users.setPhotoId(1);
			userDetails = users.getUsersDetails();
			if (!StringUtils.isEmpty(userDetails.getMemorableWord())) {
				userDetails = usersDetailsServiceImpl.save(userDetails);
				users.setSecDetId(String.valueOf(userDetails.getId()));

				String userName = userNameGeneratorService.userNameGen(users.getFirstName(), users.getLastName());
				users.setUserName(userName);

				users.setPermAId(String.valueOf(1));
				users = convertUsers(usersRepo.save(convertU(users)));
			}

			
			if (!StringUtils.isEmpty(addressDetails.getType())) {
				if (addressDetails.getType().equals("PermA")) {
					addressDetails.setUserId(users.getUserId());
					addressDetails = addressDetailsService.save(addressDetails);

					users.setPermAId(String.valueOf(addressDetails.getId()));
				}

				if (addressDetails.getType().equals("TempA")) {
					addressDetails.setUserId(users.getUserId());
					addressDetails = addressDetailsService.save(addressDetails);
					users.setTempAId(String.valueOf(addressDetails.getId()));
				}

				if (addressDetails.getType().equals("WorkA")) {
					addressDetails.setUserId(users.getUserId());
					addressDetails = addressDetailsService.save(addressDetails);
					users.setWorkAId(String.valueOf(addressDetails.getId()));
				}

				if (addressDetails.getType().equals("BillA")) {
					addressDetails.setUserId(users.getUserId());
					addressDetails = addressDetailsService.save(addressDetails);
					users.setBillAId(String.valueOf(addressDetails.getId()));
				}
			} else {
				throw new Exception("One Address is minimum required for registration");
			}
			String premAId = users.getPermAId();
			//String tempAId = !(users.getTempAId().equals(null)) ? "0" : users.getTempAId();
			//String workAId = !(users.getWorkAId().equals(null)) ? "0" : users.getWorkAId();
			//String billAId = !(users.getBillAId().equals(null)) ? "0" : users.getBillAId();

			int userNo = usersRepo.updateUsers(users.getUserId(), premAId, "0", "0", "0");
			
			if(userNo>0) {
				return users;
			} else {
				return new Users();
			}
		}
		return users;
	}

	private Users convertUsers(com.ccsbi.co.usermanagement.repository.entity.Users users) {

		return dozerMapper.map(users, Users.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.Users convertU(Users users) {

		return dozerMapper.map(users, com.ccsbi.co.usermanagement.repository.entity.Users.class);
	}

}
