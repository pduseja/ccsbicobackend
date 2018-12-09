package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.SecurityQuestions;

@Repository
public interface SecurityQuestionsRepo extends JpaRepository<SecurityQuestions, Long> {

}
