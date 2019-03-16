package com.ccsbi.co.usermanagement.service;

import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersLoginRecord;

public interface ILoginService {

	/**
	 * Description : This method is used for Checking user credentials and login in it.
	 * 
	 * @param login
	 * @return
	 */
	public Users login(UsersLoginRecord login);
	
	/**
	 * Description : 
	 * 
	 * @param login
	 * @return
	 */
	public Users getUserName(UsersLoginRecord login);
	

	/**
	 * Description : This method is check the Login attempts of the user
	 * 
	 * @param login
	 * @param userId
	 * @return
	 */
	public int loginAttempts(UsersLoginRecord login, int userId);	
	
	/**
	 * Description : Logout the user with userName
	 * @param userName
	 * @return
	 */
	public String logout(String userName);

	
}
