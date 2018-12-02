package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.SecurityQuestions;

@Repository
public interface SecurityQuestionsRepo extends JpaRepository<SecurityQuestions, Long> {

}
