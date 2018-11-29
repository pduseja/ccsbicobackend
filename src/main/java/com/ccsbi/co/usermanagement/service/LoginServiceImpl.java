package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

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
	public Users login(UsersLoginRecord login) {
		
		String userName = login.getUserName();
		String password = null;
		Users user = convertUsers(usersRepo.loginUser(userName));

		if (user.getUserId() >0) {

			password = usersDetailsRepo.loginUser(user.getUserId());
		}
		if (password.equals(login.getPassword())) {
			
			return user;
		} else {
			return new Users();
		}

	}

	@Override
	public List<Object> getUserName(UsersLoginRecord login) {
		List<Object> list = new ArrayList<>();
		String token = login.getToken();
		String cookie = login.getCookie();
		Users users = new Users();

		UsersLoginRecord usersLoginRecord = convertULR(usersLoginRecordRepo.verifyUser(cookie, token));
		
		if(usersLoginRecord.getUserId()>0) {
			users = convertUsers(usersRepo.getUsers(usersLoginRecord.getUserId()));
			if (!StringUtils.isEmpty(users.getFirstName())){
				list.add(users);
				list.add(usersLoginRecord);
			}
		}
		return list;
	}

	private UsersLoginRecord convertULR(com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord verifyUser) {
		
		return dozerMapper.map(verifyUser,UsersLoginRecord.class);
	}

	private Users convertUsers(com.ccsbi.co.usermanagement.repository.entity.Users users) {
		
		return dozerMapper.map(users,Users.class);
	}
	
	
}
