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
	
}
