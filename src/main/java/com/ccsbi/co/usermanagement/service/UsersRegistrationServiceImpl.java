package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.UsersDetailsRepo;
import com.ccsbi.co.usermanagement.repository.UsersPhotoRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.Users;

@Transactional
@Service
public class UsersRegistrationServiceImpl implements IUsersRegistrationService {

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	UsersDetailsRepo usersDetailsRepo;

	@Autowired
	UsersPhotoRepo usersPhotoRepo;

	@Autowired
	private Mapper dozerMapper;

	@Override
	public List<Users> getPendingUsersList() {
		List<Users> listPend = new ArrayList<>();
		List<com.ccsbi.co.usermanagement.repository.entity.Users> listEntPend = new ArrayList<>();
		final String flag = "N";
		listEntPend = usersRepo.getPendingUsersList(flag);

		if (listEntPend.size() > 0) {
			listPend = convert(listEntPend);
		}

		return listPend;
	}

	@Override
	public List<Users> getApprovedUsersList() {
		List<Users> listAppr = new ArrayList<>();
		List<com.ccsbi.co.usermanagement.repository.entity.Users> listEntAppr = new ArrayList<>();
		final String flag = "Y";
		listEntAppr = usersRepo.getApprovedUsersList(flag);

		if (listEntAppr.size() > 0) {
			listAppr = convert(listEntAppr);
		}

		return listAppr;
	}

	@Override
	public int deleteUser(String userName) {

		int delete = 0;
		int delDetails = 0;
		com.ccsbi.co.usermanagement.repository.entity.Users userEnt = usersRepo.loginUser(userName);
		int userId = userEnt.getUserId();
		int photoId = userEnt.getPhotoId();
		delete = usersRepo.delete(userName);
		if (delete > 0) {
			if (photoId > 0) {
				photoId = usersPhotoRepo.delete(photoId);
			}
			delDetails = usersDetailsRepo.delete(userId);
			if (delDetails > 0) {
				return delete;
			} else {
				return 0;
			}
		}

		return delete;
	}

	@Override
	public int updateUser(Users users) {
		int update = 0;
		String userName = users.getUserName();
		String active = users.getActive();
		int profileId = users.getProfileId();
		if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(active)) {
			update = usersRepo.updateUsersStatus(userName, active,profileId);
			// TODO add logic to send email to user
		} else {
			update = 0;
		}

		return update;
	}

	@SuppressWarnings("unchecked")
	private List<Users> convert(List<com.ccsbi.co.usermanagement.repository.entity.Users> listEntPend) {
		List<Users> list = new ArrayList<>();
		return (List<Users>) dozerMapper.map(listEntPend, list.getClass());
	}

}
