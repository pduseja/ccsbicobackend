package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.Profiles;

public interface IProfilesService {
	
	List<Profiles> getProfilesList();
	
	List<String> getProfileRoles(int profileId);
	

}
