package com.ccsbi.co.usermanagement.service;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.UsersDetailsRepo;
import com.ccsbi.co.usermanagement.repository.UsersLoginRecordRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersLoginRecord;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	UsersDetailsRepo usersDetailsRepo;

	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	UsersLoginRecordRepo usersLoginRecordRepo;

	@Autowired
	private Mapper dozerMapper;
	
	@Override
	public String login(UsersLoginRecord login) {

		String userName = login.getUserName();
		String password = null;
		int userId = usersRepo.loginUser(userName);

		if (userId >0) {

			password = usersDetailsRepo.loginUser(userId);
		}
		if (password.equals(login.getPassword())) {
			return "Success";
		} else {
			return "";
		}

	}

	@Override
	public String getUserName(UsersLoginRecord login) {
		String token = login.getToken();
		String cookie = login.getCookie();
		Users users = new Users();
		String name = null;
		int userId = usersLoginRecordRepo.verifyUser(cookie, token);
		
		if(userId>0) {
			users = convertUsers(usersRepo.getUsers(userId));
			if (!StringUtils.isEmpty(users.getFirstName())){
				name = users.getFirstName()+ " "+ users.getLastName();
			}
		}
		return name;
	}

	private Users convertUsers(com.ccsbi.co.usermanagement.repository.entity.Users users) {
		
		return dozerMapper.map(users,Users.class);
	}
	
	
}
