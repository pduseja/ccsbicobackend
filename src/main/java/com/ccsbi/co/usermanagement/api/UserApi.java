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

import com.ccsbi.co.usermanagement.client.entity.Users;
import com.ccsbi.co.usermanagement.client.entity.UsersLoginRecord;
import com.ccsbi.co.usermanagement.service.ILoginService;
import com.ccsbi.co.usermanagement.service.IUsersService;

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

	
	@Autowired
	IUsersService usersService;

	/**
	 * Method Description: 
	 * 
	 * @param 
	 * @return
	 */
	@ApiOperation(value = "User Login", notes = "User Login", nickname = "login")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/login", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE })
	public Users login(@ApiParam(value = "", required = true) @RequestBody UsersLoginRecord login) {
		LOGGER.info("Inside {}.login()", getClass().getSimpleName());
		
		Users user =  new Users();

		if (StringUtils.isEmpty(login.getCookie())) {
			user = convertUser(loginService.login(convertLogin(login)));
			if (!StringUtils.isEmpty(user.getUserName())) {
				
				return user;
			} else {
				return null;
			}
		} else {
			List<Object> list1 = new ArrayList<>();
			list1 = loginService.getUserName(convertLogin(login));
			user = convertUser((com.ccsbi.co.usermanagement.service.model.Users)list1.get(0));
			
			
		}

		return user;
	}

	/**
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value = "User registration", notes = "User registration", nickname = "registration")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/registration", produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE })
	public String registration(@ApiParam(value = "", required = true) @RequestBody Users user) throws Exception {
		
		String userName = null; 
		user = convertUsers(usersService.save(convert(user)));
		if(!StringUtils.isEmpty(user.getUserName())) {
			userName = user.getUserName();
		}
		
		return "You are registered with us and your UserName is : "+userName+ " Admin will verify your details and will contact you via email";
	}
	
	private Users convertUsers(com.ccsbi.co.usermanagement.service.model.Users user) {
		
		return dozerMapper.map(user, Users.class);
	}


	private com.ccsbi.co.usermanagement.service.model.Users convert(Users user) {
		
		return dozerMapper.map(user, com.ccsbi.co.usermanagement.service.model.Users.class);
	}

	

	private UsersLoginRecord convertLoginClient(
			com.ccsbi.co.usermanagement.service.model.UsersLoginRecord usersLoginRecord) {
		
		return dozerMapper.map(usersLoginRecord, UsersLoginRecord.class);
	}



	private Users convertUser(com.ccsbi.co.usermanagement.service.model.Users login) {
		
		return dozerMapper.map(login, Users.class);
	}



	private com.ccsbi.co.usermanagement.service.model.UsersLoginRecord convertLogin(UsersLoginRecord login) {

		return dozerMapper.map(login, com.ccsbi.co.usermanagement.service.model.UsersLoginRecord.class);
	}

}
