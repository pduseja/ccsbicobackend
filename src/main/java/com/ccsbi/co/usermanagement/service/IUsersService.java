package com.ccsbi.co.usermanagement.service;

import com.ccsbi.co.usermanagement.service.model.Users;

public interface IUsersService {

	Users save(Users users) throws Exception;

	int changePassword(String userName, String password);

}
