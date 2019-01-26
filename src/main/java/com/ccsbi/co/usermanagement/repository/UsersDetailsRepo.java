package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.UsersDetails;

@Repository
public interface UsersDetailsRepo extends JpaRepository<UsersDetails, Long> {

	@Query("SELECT ud.password FROM usersdetails ud WHERE ud.userId=:userId")
	String loginUser(@Param("userId") int userId);
	
	@Query("Select ud from usersdetails ud where ud.userId=:userId")
	UsersDetails getUsersDetails(@Param("userId") int userId);

	@Modifying
	@Query("update usersdetails ud set ud.password=:password where ud.userId=:userId")
	int updateusersDetails(@Param("userId")int userId, @Param("password") String password);
	
	@Query("select ud.loginAttempts from usersdetails ud where ud.userId=:userId")
	int loginAttempts(@Param("userId") int userId);
	
	@Modifying
	@Query("update usersdetails ud set ud.loginAttempts=ud.loginAttempts+1 where ud.userId=:userId")
	int updateloginAttempts(@Param("userId")int userId);

	@Modifying
	@Query("delete from usersdetails ud where ud.userId=:userId")
	int delete(@Param("userId")int userId);
	
	@Modifying
	@Query("update usersdetails ud set ud.password=:password,ud.memorableWord=:memorableWord,"
			+ "ud.securityAnswer1=:securityAnswer1,ud.securityAnswer2=:securityAnswer2,"
			+ "ud.isTempPassword=:isTempPassword,ud.accountLocked=:accountLocked,"
			+ "ud.securityQuestionId1=:securityQuestionId1,ud.securityQuestionId2=:securityQuestionId2 where ud.userId=:userId")
	int updateCompleteUsersDetails(@Param("userId")int userId,@Param("password") String password,
			@Param("memorableWord") String memorableWord,@Param("securityAnswer1") String securityAnswer1,@Param("securityAnswer2") String securityAnswer2,
			@Param("isTempPassword") char isTempPassword,@Param("accountLocked") String accountLocked,@Param("securityQuestionId1")int securityQuestionId1,
			@Param("securityQuestionId2")int securityQuestionId2);
}
