package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
	
	@Query("SELECT u FROM users u WHERE u.userName=:userName")
	Users loginUser(@Param("userName") String userName);
	
	@Query("SELECT u FROM users u WHERE u.userId=:userId")
	Users getUsers(@Param("userId") int userId);
	
	@Query("SELECT u FROM users u where u.active=:flag")
	List<Users> getPendingUsersList(@Param("flag") String flag);
	
	@Query("SELECT u FROM users u where u.active=:flag")
	List<Users> getApprovedUsersList(@Param("flag") String flag);
	
	@Modifying
    @Query("UPDATE users u SET u.active=:active,u.profileId=:profileId WHERE u.userName=:userName")
	int updateUsersStatus(@Param("userName") String userName,@Param("active") String active,@Param("profileId") int profileId);

	@Modifying
	@Query("delete from users u where u.userName=:userName")
	int delete(@Param("userName") String userName);
	
	@Query("SELECT u.userId FROM users u WHERE u.userName=:userName")
	int getUserId(@Param("userName") String userName);
	
}
