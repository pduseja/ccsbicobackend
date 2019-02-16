package com.ccsbi.co.usermanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp;

public interface IMessageFollowUpRepo extends JpaRepository<IMessageFollowUp, Long> {
	
	@Query("select imfp from imessagefollowup imfp where imfp.iMessage.iMessageId=:iMessageId")
	List<IMessageFollowUp> getIMessageFollowUpList(@Param("iMessageId") int iMessageId);
	
	@Modifying
	@Query("update imessagefollowup imfp set imfp.messageReply=:messageReply, imfp.responseStatus=:responseStatus,"
			+ "imfp.readStatus=:readStatus, imfp.modBy=:modBy, imfp.modDate=:modDate,imfp.fileContent=:fileContent"
			+ " where imfp.iMessageFollowUpId=:iMessageFollowUpId")
	int updateiMessageFollowUp(@Param("messageReply") String messageReply,@Param("responseStatus") String responseStatus,
			@Param("readStatus") String readStatus,@Param("modBy") String modBy,@Param("modDate") Date modDate,@Param("fileContent") byte[] fileContent,
			@Param("iMessageFollowUpId") int iMessageFollowUpId);

}
