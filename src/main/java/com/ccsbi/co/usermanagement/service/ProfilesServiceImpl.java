package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.ProfilesRepo;
import com.ccsbi.co.usermanagement.service.model.Profiles;

@Service
public class ProfilesServiceImpl implements IProfilesService {

	@Autowired
	ProfilesRepo profilesRepo;

	@Autowired
	Mapper dozerMapper;

	@Override
	public List<Profiles> getProfilesList() {
		List<Profiles> list = new ArrayList<>();
		final String superUser = "SU";
		list = convert(profilesRepo.findProfiles(superUser));
				
		return list;
	}



	@Override
	public List<String> getProfileRoles(int profileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<Profiles> convert(List<com.ccsbi.co.usermanagement.repository.entity.Profiles> findAll) {
		List<Profiles> list = new ArrayList<>();
		
		return (List<Profiles>)dozerMapper.map(findAll, list.getClass());
	}
	
}
