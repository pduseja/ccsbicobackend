package com.ccsbi.co.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.UserNameGeneratorRepo;

@Service
public class UserNameGeneratorService {
	
	@Autowired
	UserNameGeneratorRepo userNameRepo;
	
	public String userNameGen(String firstName, String lastName) {
		
		char firstN = firstName.charAt(0);
		char lastN = lastName.charAt(0);
		String prefix = new StringBuilder().append(firstN).append(lastN).toString();
		int prefixNum = userNameRepo.findLatestNumber(prefix);
		
		if(prefixNum != 0) {
			@SuppressWarnings("unused")
			int updatePrefixNum = userNameRepo.updateSequenceNumber(prefixNum+1,prefix);
		}
		String userName = prefix+prefixNum;
		
		return userName;
	}

}
