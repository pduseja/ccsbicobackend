package com.ccsbi.co.usermanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.IMessage;

public interface IMessageRepo extends JpaRepository<IMessage, Long> {
	
	@Query("SELECT im from imessage im where im.userName=:userName")
	List<IMessage> getMessageLst(@Param("userName") String userName);
	
	@Query("SELECT im from imessage im where im.department=:department")
	List<IMessage> getMessageList(@Param("department") String department);
	
	@Modifying
	@Query("update imessage im set im.messageReply=:messageReply, im.responseStatus=:responseStatus,"
			+ "im.readStatus=:readStatus, im.modBy=:modBy, im.modDate=:modDate,im.fileContent=:fileContent"
			+ " where im.iMessageId=:iMessageId")
	int updateiMessage(@Param("messageReply") String messageReply,@Param("responseStatus") String responseStatus,
			@Param("readStatus") String readStatus,@Param("modBy") String modBy,
			@Param("modDate") Date modDate,@Param("fileContent") byte[] fileContent,
			@Param("iMessageId") int iMessageId);

}
