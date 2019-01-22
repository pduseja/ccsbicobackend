package com.ccsbi.co.usermanagement.api;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccsbi.co.usermanagement.client.entity.Users;
import com.ccsbi.co.usermanagement.service.IUsersRegistrationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminApi.class);

	@Autowired
	private IUsersRegistrationService usersRegistrationServiceImpl;

	@Autowired
	Mapper dozerMapper;

	@ApiOperation(value = "Pending Users List", notes = "Pending Users List", nickname = "Pending Users List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/pending/{userName}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Users> pendingUsersList(@ApiParam(value = "", required = true) @PathVariable String userName) {

		LOGGER.debug("Inside pendingUsersList Get Method");
		List<Users> list = new ArrayList<>();
		list = convert(usersRegistrationServiceImpl.getPendingUsersList());
		return list;

	}

	@ApiOperation(value = "Approved Users List", notes = "Approved Users List", nickname = "Approved Users List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/approved/{userName}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Users> approvedUsersList(@ApiParam(value = "", required = true) @PathVariable String userName) {

		LOGGER.debug("Inside approvedUsersList Get Method");
		List<Users> list = new ArrayList<>();
		list = convert(usersRegistrationServiceImpl.getApprovedUsersList());
		return list;

	}

	@ApiOperation(value = "Update User", notes = "Update User", nickname = "Update User")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ResponseEntity<Users> updateUsers(@ApiParam(value = "", required = true) @RequestBody Users user) {
		
		LOGGER.info("Inside {}.updateUsers()", getClass().getSimpleName());
		Users users = user;
		users = convertUsers(usersRegistrationServiceImpl.updateUser(convertU(users)));

		if (users.getUserId()>0) {			
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	private Users convertUsers(com.ccsbi.co.usermanagement.service.model.Users updateUser) {
		
		return dozerMapper.map(updateUser, Users.class);
	}

	@ApiOperation(value = "Delete User", notes = "Delete User", nickname = "Delete User")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/delete", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public ResponseEntity<Users> deleteUsers(@ApiParam(value = "", required = true) @RequestBody Users user) {
		
		LOGGER.info("Inside {}.deleteUsers()", getClass().getSimpleName());
		Users users = user;
		int delete = usersRegistrationServiceImpl.deleteUser(users.getUserName());

		if (delete > 0) {
			users = new Users();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	

	private com.ccsbi.co.usermanagement.service.model.Users convertU(Users users) {

		return dozerMapper.map(users, com.ccsbi.co.usermanagement.service.model.Users.class);
	}

	@SuppressWarnings("unchecked")
	private List<Users> convert(List<com.ccsbi.co.usermanagement.service.model.Users> pendingUsersList) {
		List<Users> list = new ArrayList<>();

		return (List<Users>) dozerMapper.map(pendingUsersList, list.getClass());
	}

}
