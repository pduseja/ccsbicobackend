package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.Users;

public interface IUsersRegistrationService {
	
	List<Users> getPendingUsersList();
	
	List<Users> getApprovedUsersList();
	
	int deleteUser(String userName);
	
	int updateUser(Users users);

}
