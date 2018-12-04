package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.SecurityQuestionsRepo;
import com.ccsbi.co.usermanagement.service.model.SecurityQuestions;

@Service
public class SecurityQuestionsServiceImpl implements ISecurityQuestionsService {

	@Autowired
	SecurityQuestionsRepo securityQuestionsRepo;
	
	@Autowired
	Mapper dozerMapper;
	
	@Override
	public List<SecurityQuestions> listOfSecurityQuestions() {
	
		List<SecurityQuestions> list = convert(securityQuestionsRepo.findAll());
		return list;
	}

	@SuppressWarnings("unchecked")
	private List<SecurityQuestions> convert(
			List<com.ccsbi.co.usermanagement.repository.entity.SecurityQuestions> findAllQuestions) {
		List<SecurityQuestions> list = new ArrayList<>();
		return (List<SecurityQuestions>) dozerMapper.map(findAllQuestions, list.getClass());
	}

}
