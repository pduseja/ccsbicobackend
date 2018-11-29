package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
	
	@Query("SELECT userId FROM users WHERE userName=:userName")
	int loginUser(@Param("userName") String userName);
	
	@Query("SELECT u FROM users u WHERE userId=:userId")
	Users getUsers(@Param("userId") int userId);

}
