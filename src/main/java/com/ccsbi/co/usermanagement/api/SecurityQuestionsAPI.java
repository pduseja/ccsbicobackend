package com.ccsbi.co.usermanagement.api;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccsbi.co.usermanagement.client.entity.SecurityQuestions;
import com.ccsbi.co.usermanagement.service.ISecurityQuestionsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SecurityQuestionsAPI {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityQuestionsAPI.class);

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	ISecurityQuestionsService iSecurityQuestionsService;

	@ApiOperation(value = "Security Questions", notes = "Security Questions", nickname = "security Questions")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/questions/{questionsList}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<List<SecurityQuestions>> questionsList(
			@ApiParam(value = "", required = true) @PathVariable String questionsList) {

		LOGGER.debug("Inside Security Questions Get Method");
		List<SecurityQuestions> list = new ArrayList<>();
		List<List<SecurityQuestions>> finalList = new ArrayList<>();
		list = convert(iSecurityQuestionsService.listOfSecurityQuestions());
		int listInt = list.size();
		int divNum = 2;
		int divcount = listInt / divNum;
		List<SecurityQuestions> listOne = new ArrayList<>();
		List<SecurityQuestions> listTwo = new ArrayList<>();
		if (divcount > 0) {
			listOne = list.subList(0, divcount);
			listTwo = list.subList(divcount, listInt);
		}		
		finalList.add(listOne);
		finalList.add(listTwo);
		return finalList;

	}

	@SuppressWarnings("unchecked")
	private List<SecurityQuestions> convert(
			List<com.ccsbi.co.usermanagement.service.model.SecurityQuestions> listOfSecurityQuestions) {
		List<SecurityQuestions> list = new ArrayList<>();

		return (List<SecurityQuestions>) dozerMapper.map(listOfSecurityQuestions, list.getClass());
	}

	
}
