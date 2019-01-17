package com.ccsbi.co.usermanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.Faq;

@Repository
public interface FaqRepo extends JpaRepository<Faq, Long> {

	@Query("SELECT u FROM faq u where u.status=:status")
	List<Faq> getActiveFaq(@Param("status") String status);
	
	@Modifying
	@Query("Update faq f set f.question=:question,f.answer=:answer,f.modDate=:modDate where f.id=:id")
	int updateFaq(@Param("id") int id,@Param("question") String question,@Param("answer") String answer,@Param("modDate") Date modDate);		
}
