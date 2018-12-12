package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.SecurityQuestions;

@Repository
public interface SecurityQuestionsRepo extends JpaRepository<SecurityQuestions, Long> {
	
	@Query("Select sq.hintQuestion from securityquestions sq where id=:id")
	String hintQuestion(@Param("id") int id);

}
