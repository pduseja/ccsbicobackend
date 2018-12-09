package com.ccsbi.co.usermanagement.service;

import com.ccsbi.co.usermanagement.service.model.UsersDetails;

public interface IUsersDetailsService {

	public UsersDetails save(UsersDetails userDetails);
	
	public UsersDetails getUsersDetails(String userName);
}
