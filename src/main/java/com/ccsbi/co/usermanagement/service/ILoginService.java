package com.ccsbi.co.usermanagement.service;

import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersLoginRecord;

public interface ILoginService {

	public Users login(UsersLoginRecord login);
	
	public Users getUserName(UsersLoginRecord login);
	
	
	/**
	 * Description : This method is check the Login attempts of the user
	 * @param login
	 * @return
	 */
	public int loginAttempts(UsersLoginRecord login);	
}
