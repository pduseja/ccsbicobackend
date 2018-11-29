package com.ccsbi.co.usermanagement.service;

import com.ccsbi.co.usermanagement.service.model.UsersLoginRecord;

public interface ILoginService {

	public String login(UsersLoginRecord login);
	
	public String getUserName(UsersLoginRecord login);
}
