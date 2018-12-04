package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.UsersLoginRecord;

@Repository
public interface UsersLoginRecordRepo extends JpaRepository<UsersLoginRecord, Long> {
	
	@Query("SELECT ulr FROM usersloginrecord ulr WHERE ulr.cookie=:cookie and ulr.token=:token")
	UsersLoginRecord verifyUser(@Param("cookie") String cookie,@Param("token") String token);

}
