package com.ccsbi.co.usermanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.LiveChatMembersRepo;
import com.ccsbi.co.usermanagement.repository.ProfilesRepo;
import com.ccsbi.co.usermanagement.repository.UsersDetailsRepo;
import com.ccsbi.co.usermanagement.repository.UsersLoginRecordRepo;
import com.ccsbi.co.usermanagement.repository.UsersPhotoRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.AddressDetails;
import com.ccsbi.co.usermanagement.service.model.LiveChatMembers;
import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersDetails;
import com.ccsbi.co.usermanagement.service.model.UsersLoginRecord;
import com.ccsbi.co.usermanagement.service.model.UsersPhoto;
import com.ccsbi.co.usermanagement.util.ReallyStrongSecuredPassword;

@Transactional
@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	UsersDetailsRepo usersDetailsRepo;

	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	UsersDetailsServiceImpl usersDetailsServiceImpl;

	@Autowired
	UsersPhotoRepo usersPhotoRepo;

	@Autowired
	UsersLoginRecordRepo usersLoginRecordRepo;
	
	@Autowired
	ProfilesRepo profilesRepo;

	@Autowired
	AddressDetailsServiceImpl addressDetailsService;
	
	@Autowired
	LiveChatMembersRepo liveChatMembersRepo;

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	ReallyStrongSecuredPassword reallyStrongSecuredPassword;

	@Override
	public Users login(UsersLoginRecord login) {

		String userName = login.getUserName();
		String password = null;
		String encryptPassword = null;
		UsersDetails usersD = new UsersDetails();

		if (!StringUtils.isEmpty(login.getUserName())) {
			com.ccsbi.co.usermanagement.repository.entity.Users userEnt = usersRepo.loginUser(userName);
			if (userEnt != null && userEnt.getActive().equalsIgnoreCase("Y")) {
				Users user = convertUsers(userEnt);

				encryptPassword = reallyStrongSecuredPassword.encrypt(login.getPassword());
				com.ccsbi.co.usermanagement.repository.entity.UsersDetails usersDetailsEnt = usersDetailsRepo
						.getUsersDetails(user.getUserId());
				if (usersDetailsEnt != null) {
					usersD = convertDetails(usersDetailsEnt);
				} else {
					return new Users();
				}

				user.setUsersDetails(usersD);
				UsersLoginRecord usersLoginRecord = new UsersLoginRecord();
				if (user.getUserId() > 0) {

					password = usersDetailsRepo.loginUser(user.getUserId());
				}
				if (password.equals(encryptPassword)) {
					// Trace user login
					com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord usersLoginRecordEnt = usersLoginRecordRepo
							.getRecord(user.getUserId());

					if (usersLoginRecordEnt != null) {
						usersLoginRecord = convertULR(usersLoginRecordEnt);
						if (usersLoginRecord.getUserId() == user.getUserId()) {
							if (login.getRememberMe()) {
								usersLoginRecord.setRememberMe(login.getRememberMe());
								usersLoginRecord = updateUsersLoginRecord(usersLoginRecord, user);
							} else {
								usersLoginRecord.setRememberMe(false);
								usersLoginRecord = updateUsersLoginRecord(usersLoginRecord, user);
							}
						} else {
							if (login.getRememberMe()) {
								usersLoginRecord = saveUsersLoginRecord(login, user);
							} else {
								usersLoginRecord.setRememberMe(false);
								usersLoginRecord = updateUsersLoginRecord(login, user);
							}

						}
						user.setUsersLoginRecord(usersLoginRecord);
						// add usersdetails and addressdetails to users object.
						user = addUserDetailsAddressDetails(user);
						//Add Team details into LiveChatMembers
						int add = savechatMembers(user);
						
						return user;
					} else {
						// Add Login code
						if (!login.getRememberMe()) {
							usersLoginRecord.setRememberMe(false);
							usersLoginRecord = saveUsersLoginRecord(usersLoginRecord, user);
						} else {
							usersLoginRecord.setRememberMe(true);
							usersLoginRecord = saveUsersLoginRecord(usersLoginRecord, user);
						}
						user.setUsersLoginRecord(usersLoginRecord);
						// add usersdetails and addressdetails to users object.
						user = addUserDetailsAddressDetails(user);
						//Add Team details into LiveChatMembers
						int add = savechatMembers(user);
						return user;

					}
				} else {
					// Add Logic to update Login attempts.

					return new Users();
				}
			} else {
				Users user = new Users();
				user.setActive("N");
				return user;
			}
		} else {
			return new Users();
		}

	}

	@Override
	public Users getUserName(UsersLoginRecord login) {

		String token = login.getToken();
		String cookie = login.getCookie();
		Users users = new Users();
		UsersLoginRecord usersLoginRecord = new UsersLoginRecord();
		if (!StringUtils.isEmpty(cookie) && !StringUtils.isEmpty(token)) {
			com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord usersLoginRecordEnt = usersLoginRecordRepo
					.verifyUser(cookie, token);

			if (usersLoginRecordEnt != null) {
				usersLoginRecord = convertULR(usersLoginRecordEnt);

				if (usersLoginRecord.getUserId() > 0) {
					users = convertUsers(usersRepo.getUsers(usersLoginRecord.getUserId()));
					if (!StringUtils.isEmpty(users.getFirstName())) {
						usersLoginRecord = updateUsersLoginRecord(usersLoginRecord, users);
						users.setUsersLoginRecord(usersLoginRecord);
						// add usersdetails and addressdetails to users object.
						users = addUserDetailsAddressDetails(users);
						return users;
					}
				}
			} else {
				return users;
			}

		} else {
			users = login(login);
			return users;
		}
		return users;
	}

	private Users addUserDetailsAddressDetails(Users user) {

		UsersDetails usersD = new UsersDetails();
		usersD = usersDetailsServiceImpl.getUsersDetails(user.getUserName());
		
		usersD.setPassword("");
		user.setUsersDetails(usersD);

		List<AddressDetails> listAdd = addressDetailsService.getAddressList(user.getUserId());
		if (!listAdd.isEmpty()) {
			user.setAddressDetailsList(listAdd);
		} else {
			return new Users();
		}
		if (user.getPhotoId() > 0) {
			UsersPhoto userPhoto = convertUsersPhoto(usersPhotoRepo.findUsersPhoto(user.getPhotoId()));
			user.setUsersPhoto(userPhoto);
		}
		return user;
	}

	private UsersPhoto convertUsersPhoto(com.ccsbi.co.usermanagement.repository.entity.UsersPhoto findUsersPhoto) {

		return dozerMapper.map(findUsersPhoto, UsersPhoto.class);
	}

	public int loginAttempts(UsersLoginRecord login, int userId) {

		int loginAttempts = 0;

		loginAttempts = usersDetailsRepo.loginAttempts(userId);

		if (loginAttempts >= 3) {
			return 3;

		} else {
			return loginAttempts;
		}

	}

	private String generateCookieToken(String userName, String password, String firstName) {
		String cookieToken = null;
		if (!StringUtils.isEmpty(firstName)) {
			cookieToken = reallyStrongSecuredPassword.encrypt(userName + password + firstName);

		} else
			cookieToken = reallyStrongSecuredPassword.encrypt(userName + "CCSBI");

		return cookieToken;
	}

	private UsersLoginRecord saveUsersLoginRecord(UsersLoginRecord usersLoginRecord, Users users) {
		long currTime = System.currentTimeMillis();
		String cookieStr = generateCookieToken(users.getUserName(), usersLoginRecord.getPassword(),
				String.valueOf(currTime));

		String tokenStr = generateCookieToken(users.getUserName(), "", String.valueOf(currTime));

		usersLoginRecord.setUserId(users.getUserId());
		usersLoginRecord.setRememberMe(usersLoginRecord.getRememberMe());
		if (!usersLoginRecord.getRememberMe()) {
			usersLoginRecord.setCookie("");
			usersLoginRecord.setToken("");
			usersLoginRecord.setCookieExpirytime(0);
		} else {
			usersLoginRecord.setToken(tokenStr);
			usersLoginRecord.setCookie(cookieStr);
			// 1 day = 24 x 60 x 60
			usersLoginRecord.setCookieExpirytime(86400);
		}

		usersLoginRecord.setPassword(users.getUsersDetails().getPassword());
		usersLoginRecord.setUserName(users.getUserName());

		usersLoginRecord = convertULR(usersLoginRecordRepo.save(convertUsersLR(usersLoginRecord)));

		return usersLoginRecord;
	}

	private UsersLoginRecord updateUsersLoginRecord(UsersLoginRecord usersLoginRecord, Users users) {
		long currTime = System.currentTimeMillis();

		String cookieStr = "";
		String tokenStr = "";

		usersLoginRecord.setRememberMe(usersLoginRecord.getRememberMe());
		if (!usersLoginRecord.getRememberMe()) {
			usersLoginRecord.setCookie("");
			usersLoginRecord.setToken("");
			usersLoginRecord.setCookieExpirytime(0);
		} else {
			cookieStr = generateCookieToken(users.getUserName(), usersLoginRecord.getPassword(),
					String.valueOf(currTime));
			tokenStr = generateCookieToken(users.getUserName(), "", String.valueOf(currTime));
			usersLoginRecord.setToken(tokenStr);
			usersLoginRecord.setCookie(cookieStr);
			// 1 day = 24 x 60 x 60
			usersLoginRecord.setCookieExpirytime(86400);
		}
		int login = usersLoginRecordRepo.updateCookieToken(users.getUserId(), usersLoginRecord.getCookie(),
				usersLoginRecord.getToken(), usersLoginRecord.getCookieExpirytime());
		if (login != 0) {
			return usersLoginRecord;
		} else {
			return new UsersLoginRecord();
		}

	}
	
	private int savechatMembers(Users user){
		int add = 0;
		LiveChatMembers liveChatMembers = new LiveChatMembers();
		int profileId = user.getProfileId();
		String department = profilesRepo.getRole(profileId);
		if ((StringUtils.startsWith(department, "C")) || (StringUtils.startsWith(department, "S"))
				|| (StringUtils.startsWith(department, "T"))) {
			liveChatMembers.setDepartment(department);
			liveChatMembers.setFirstName(user.getFirstName());
			liveChatMembers.setPriority(0);
			liveChatMembers.setQueue(0);
			liveChatMembers.setStatus("A");
			liveChatMembers.setUserName(user.getUserName());
			liveChatMembers = convertChatModel(liveChatMembersRepo.save(convertChatent(liveChatMembers)));
			if(liveChatMembers.getLiveChatMembersId()>0) {
				add = 1;
				return add;
			}
		} else {
			return add;
		}
		
		
		
		return 0;
	}

	private LiveChatMembers convertChatModel(com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers save) {
		
		return dozerMapper.map(save, LiveChatMembers.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers convertChatent(LiveChatMembers liveChatMembers) {
		
		return dozerMapper.map(liveChatMembers, com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers.class);
	}

	private UsersDetails convertDetails(com.ccsbi.co.usermanagement.repository.entity.UsersDetails usersDetails) {

		return dozerMapper.map(usersDetails, UsersDetails.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord convertUsersLR(
			UsersLoginRecord usersLoginRecord) {

		return dozerMapper.map(usersLoginRecord, com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord.class);
	}

	private UsersLoginRecord convertULR(com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord verifyUser) {

		return dozerMapper.map(verifyUser, UsersLoginRecord.class);
	}

	private Users convertUsers(com.ccsbi.co.usermanagement.repository.entity.Users users) {

		return dozerMapper.map(users, Users.class);
	}

}