package com.ccsbi.co.usermanagement.api;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccsbi.co.usermanagement.client.entity.UsersLoginRecord;
import com.ccsbi.co.usermanagement.service.ILoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	ILoginService loginService;

	/**
	 * Method Description: This method is used to create a record in Orders
	 * Table for an order placed on site.
	 * 
	 * @param order
	 * @return
	 */
	@ApiOperation(value = "User Login", notes = "User Login", nickname = "login")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/login", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public List<Object> login(@ApiParam(value = "", required = true) @RequestBody UsersLoginRecord login) {
		LOGGER.info("Inside {}.login()", getClass().getSimpleName());
		List<Object> list = new ArrayList<>();

		if (StringUtils.isEmpty(login.getToken())) {
			list = loginService.login(convertLogin(login));
			if (!list.isEmpty()) {
				return list;
			} else {
				return null;
			}
		} else {
			list = loginService.getUserName(convertLogin(login));
			
		}

		return list;
	}

	private com.ccsbi.co.usermanagement.service.model.UsersLoginRecord convertLogin(UsersLoginRecord login) {

		return dozerMapper.map(login, com.ccsbi.co.usermanagement.service.model.UsersLoginRecord.class);
	}

}
