package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.IMessage;

public interface IMessageRepo extends JpaRepository<IMessage, Long> {
	
	@Query("SELECT im from imessage im where im.userName=:userName")
	List<IMessage> getMessageLst(@Param("userName") String userName);
	
	@Query("SELECT im from imessage im where im.department=:department")
	List<IMessage> getMessageList(@Param("department") String department);
}
