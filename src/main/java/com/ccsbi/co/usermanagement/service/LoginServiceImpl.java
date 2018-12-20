package com.ccsbi.co.usermanagement.service;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.UsersDetailsRepo;
import com.ccsbi.co.usermanagement.repository.UsersLoginRecordRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersDetails;
import com.ccsbi.co.usermanagement.service.model.UsersLoginRecord;
import com.ccsbi.co.usermanagement.util.ReallyStrongSecuredPassword;

@Transactional
@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	UsersDetailsRepo usersDetailsRepo;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	UsersLoginRecordRepo usersLoginRecordRepo;

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	ReallyStrongSecuredPassword reallyStrongSecuredPassword;

	@Override
	public Users login(UsersLoginRecord login) {

		String userName = login.getUserName();
		String password = null;
		String encryptPassword = null;
		if (!StringUtils.isEmpty(login.getUserName())) {
			Users user = convertUsers(usersRepo.loginUser(userName));

			encryptPassword = reallyStrongSecuredPassword.encrypt(login.getPassword());
			UsersDetails usersD = convertDetails(usersDetailsRepo.getUsersDetails(user.getUserId()));
			user.setUsersDetails(usersD);
			UsersLoginRecord usersLoginRecord = new UsersLoginRecord();
			if (user.getUserId() > 0) {

				password = usersDetailsRepo.loginUser(user.getUserId());
			}
			if (password.equals(encryptPassword)) {
				// Trace user login
				com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord usersLoginRecordEnt = usersLoginRecordRepo
						.getRecord(user.getUserId());
				
				if (usersLoginRecordEnt!=null) {
					usersLoginRecord = convertULR(usersLoginRecordEnt);
					if (usersLoginRecord.getUserId() == user.getUserId()) {
						if (login.getRememberMe()) {
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
					return user;
				} else {
					// Add Login code
					if (!login.getRememberMe()) {
						usersLoginRecord.setRememberMe(false);
						usersLoginRecord = saveUsersLoginRecord(usersLoginRecord, user);
					} else {						
						usersLoginRecord = saveUsersLoginRecord(usersLoginRecord, user);
					}
					user.setUsersLoginRecord(usersLoginRecord);
					return user;
					
				}
			} else {
				return new Users();
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
			usersLoginRecord = convertULR(usersLoginRecordRepo.verifyUser(cookie, token));

			if (usersLoginRecord.getUserId() > 0) {
				users = convertUsers(usersRepo.getUsers(usersLoginRecord.getUserId()));
				if (!StringUtils.isEmpty(users.getFirstName())) {
					usersLoginRecord = updateUsersLoginRecord(usersLoginRecord, users);
					users.setUsersLoginRecord(usersLoginRecord);
					return users;
				}
			}

		} else {
			users = login(login);

			if (!StringUtils.isEmpty(users.getUserName())) {
				usersLoginRecord.setPassword(login.getPassword());
				usersLoginRecord = convertULR(usersLoginRecordRepo.getRecord(users.getUserId()));
				if (usersLoginRecord.getUserId() == users.getUserId()) {
					usersLoginRecord = updateUsersLoginRecord(usersLoginRecord, users);
				} else {
					usersLoginRecord = saveUsersLoginRecord(usersLoginRecord, users);
				}
				users.setUsersLoginRecord(usersLoginRecord);
				return users;
			}

			return users;
		}
		return users;
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
		usersLoginRecord.setRememberMe(true);
		usersLoginRecord = convertULR(usersLoginRecordRepo.save(convertUsersLR(usersLoginRecord)));

		return usersLoginRecord;
	}

	private UsersLoginRecord updateUsersLoginRecord(UsersLoginRecord usersLoginRecord, Users users) {
		long currTime = System.currentTimeMillis();
		
		String cookieStr = generateCookieToken(users.getUserName(), usersLoginRecord.getPassword(),
				String.valueOf(currTime));
		String tokenStr = generateCookieToken(users.getUserName(), "", String.valueOf(currTime));
		// 1 day = 24 x 60 x 60
		
		usersLoginRecord.setRememberMe(usersLoginRecord.getRememberMe());
		if (!usersLoginRecord.getRememberMe()) {
			usersLoginRecord.setCookie("");
			usersLoginRecord.setToken("");
			usersLoginRecord.setCookieExpirytime(0);
		} else {
			usersLoginRecord.setToken(tokenStr);
			usersLoginRecord.setCookie(cookieStr);
			usersLoginRecord.setCookieExpirytime(86400);
		}
		int login = usersLoginRecordRepo.updateCookieToken(users.getUserId(), cookieStr, tokenStr);
		if (login != 0) {
			return usersLoginRecord;
		} else {
			return new UsersLoginRecord();
		}

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
