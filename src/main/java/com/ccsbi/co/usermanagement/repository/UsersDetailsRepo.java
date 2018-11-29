package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.UsersDetails;

@Repository
public interface UsersDetailsRepo extends JpaRepository<UsersDetails, Long> {

	@Query("SELECT ud.password FROM usersdetails ud WHERE ud.userId=:userId")
	String loginUser(@Param("userId") int userId);
}
