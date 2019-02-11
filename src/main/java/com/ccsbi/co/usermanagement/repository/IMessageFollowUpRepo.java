package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp;

public interface IMessageFollowUpRepo extends JpaRepository<IMessageFollowUp, Long> {
	
	@Query("select imfp from imessagefollowup imfp where imfp.iMessage.iMessageId=:iMessageId")
	List<IMessageFollowUp> getIMessageFollowUpList(@Param("iMessageId") int iMessageId);

}
