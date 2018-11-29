package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.UsersLoginRecord;

public interface ILoginService {

	public List<Object> login(UsersLoginRecord login);
	
	public List<Object> getUserName(UsersLoginRecord login);
}
