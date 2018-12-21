package com.ccsbi.co.usermanagement.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.SecurityQuestionsRepo;
import com.ccsbi.co.usermanagement.repository.UsersDetailsRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.Users;
import com.ccsbi.co.usermanagement.service.model.UsersDetails;
import com.ccsbi.co.usermanagement.util.ReallyStrongSecuredPassword;

@Service
public class UsersDetailsServiceImpl implements IUsersDetailsService {

	@Autowired
	UsersDetailsRepo usersDetailsRepo;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	private SecurityQuestionsRepo securityQuestionsRepo;
	
	@Autowired
	ReallyStrongSecuredPassword reallyStrongSecuredPassword;


	@Override
	public UsersDetails save(UsersDetails userDetails) {

		return convertUserDetails(usersDetailsRepo.save(convertUsersD(userDetails)));
	}

	@Override
	public UsersDetails getUsersDetails(String userName) {

		Users user = new Users();
		UsersDetails usersDetails = new UsersDetails();

		com.ccsbi.co.usermanagement.repository.entity.Users users = usersRepo.loginUser(userName);
		if (users != null) {
			user = convertUsers(users);
		} else {
			return usersDetails;
		}

		int userId = 0;
		if (user != null) {
			userId = user.getUserId();
		} else {
			return usersDetails;
		}
		if (userId != 0) {
			usersDetails = convertUserDetails(usersDetailsRepo.getUsersDetails(userId));
		} else {
			return usersDetails;
		}
		int securityQuestion1 = usersDetails.getSecurityQuestionId1();
		int securityQuestion2 = usersDetails.getSecurityQuestionId2();

		String securityQuestions1 = securityQuestionsRepo.hintQuestion(securityQuestion1);
		String securityQuestions2 = securityQuestionsRepo.hintQuestion(securityQuestion2);
		usersDetails.setSecurityQuestionIdStr1(securityQuestions1);
		usersDetails.setSecurityQuestionIdStr2(securityQuestions2);
		String decryptMemorableWord = reallyStrongSecuredPassword.decrypt(usersDetails.getMemorableWord());
		String decryptSecurityAnswer1 = reallyStrongSecuredPassword.decrypt(usersDetails.getSecurityAnswer1());
		String decryptSecurityAnswer2 = reallyStrongSecuredPassword.decrypt(usersDetails.getSecurityAnswer2());
		usersDetails.setMemorableWord(decryptMemorableWord);
		usersDetails.setSecurityAnswer1(decryptSecurityAnswer1);
		usersDetails.setSecurityAnswer2(decryptSecurityAnswer2);

		return usersDetails;

	}

	private UsersDetails convertUserDetails(com.ccsbi.co.usermanagement.repository.entity.UsersDetails save) {

		return dozerMapper.map(save, UsersDetails.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.UsersDetails convertUsersD(UsersDetails userDetails) {

		return dozerMapper.map(userDetails, com.ccsbi.co.usermanagement.repository.entity.UsersDetails.class);
	}

	private Users convertUsers(com.ccsbi.co.usermanagement.repository.entity.Users loginUser) {

		return dozerMapper.map(loginUser, Users.class);
	}

}
