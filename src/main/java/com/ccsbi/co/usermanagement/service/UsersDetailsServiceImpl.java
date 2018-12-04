package com.ccsbi.co.usermanagement.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.UsersDetailsRepo;
import com.ccsbi.co.usermanagement.service.model.UsersDetails;

@Service
public class UsersDetailsServiceImpl implements IUsersDetailsService {

	@Autowired
	UsersDetailsRepo usersDetailsRepo;
	
	@Autowired
	private Mapper dozerMapper;
	
	@Override
	public UsersDetails save(UsersDetails userDetails) {
		
		return convertUserDetails(usersDetailsRepo.save(convertUsersD(userDetails)));
	}

	private UsersDetails convertUserDetails(com.ccsbi.co.usermanagement.repository.entity.UsersDetails save) {
		
		return dozerMapper.map(save, UsersDetails.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.UsersDetails convertUsersD(UsersDetails userDetails) {
		
		return dozerMapper.map(userDetails, com.ccsbi.co.usermanagement.repository.entity.UsersDetails.class);
	}

}
