package com.ccsbi.co.usermanagement.api;

import java.io.IOException;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsbi.co.usermanagement.client.entity.Users;
import com.ccsbi.co.usermanagement.client.entity.UsersDetails;
import com.ccsbi.co.usermanagement.client.entity.UsersLoginRecord;
import com.ccsbi.co.usermanagement.client.entity.UsersPhoto;
import com.ccsbi.co.usermanagement.service.ILoginService;
import com.ccsbi.co.usermanagement.service.IUsersDetailsService;
import com.ccsbi.co.usermanagement.service.IUsersPhotoService;
import com.ccsbi.co.usermanagement.service.IUsersService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = { "Content-Disposition" })
public class UserApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	ILoginService loginService;

	@Autowired
	IUsersService usersService;

	@Autowired
	IUsersPhotoService usersPhotoService;

	@Autowired
	IUsersDetailsService usersDetailsService;

	/**
	 * Method Description:
	 * 
	 * @param
	 * @return
	 */
	@ApiOperation(value = "User Login", notes = "User Login", nickname = "login")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/login", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE })
	public Users login(@ApiParam(value = "", required = true) @RequestBody UsersLoginRecord login) {
		LOGGER.info("Inside {}.login()", getClass().getSimpleName());

		Users user = new Users();
		
		if (!(login.getRememberMe())) {
			user = convertUser(loginService.login(convertLogin(login)));
			if (!StringUtils.isEmpty(user.getUserName())) {
				if (user.getUserId() != 0) {
					user = loginAttemptsConditioncheck(login, user);
				}
			
			}
		}else {
			user = convertUser(loginService.getUserName(convertLogin(login)));
			user = loginAttemptsConditioncheck(login, user);
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
	@PostMapping(path = "/registration", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public String registration(@ApiParam(value = "user", required = true) @Valid String users,
			@RequestParam(value = "photo", required = false) MultipartFile photo) throws Exception {

		String userName = null;
		UsersPhoto userPhoto = new UsersPhoto();
		JSONObject jsonObj = new JSONObject(users);

		ObjectMapper mapper = new ObjectMapper();
		Users user = mapper.readValue(jsonObj.toString(), Users.class);

		// Content of Photo from input
		if (photo != null) {
			String fileName = StringUtils.cleanPath(photo.getOriginalFilename());

			try {
				// Check if the file's name contains invalid characters
				if (fileName.contains("..")) {
					throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
				}
			} catch (IOException ex) {
				throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
			}
			byte[] photoContent = photo.getBytes();

			userPhoto = user.getUsersPhoto();

			userPhoto.setPhotoContent(photoContent);
			userPhoto = convertPClient(usersPhotoService.save(convertPModel(userPhoto), photo));
			user.setPhotoId(userPhoto.getPhotoId());
		}

		user = convertUsers(usersService.save(convert(user)));

		if (!StringUtils.isEmpty(user.getUserName())) {
			userName = user.getUserName();
		}

		return "You are registered with us and your UserName is : " + userName
				+ " Admin will verify your details and will contact you via email";
	}

	/**
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "User registration", notes = "User registration", nickname = "registration")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/passwordReset", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> resetDone(@ApiParam(value = "", required = true) @RequestBody Users users)
			throws Exception {

		int update = 0;
		if (!StringUtils.isEmpty(users.getUserName())) {

			update = usersService.changePassword(users.getUserName(), users.getUsersDetails().getPassword());
			if (update > 0) {
				return ResponseEntity.ok().build();

			} else {
				return ResponseEntity.badRequest().build();
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@ApiOperation(value = "Reset Password", notes = "Reset Password", nickname = "Reset Password")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/reset/{userName}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UsersDetails> paramList(
			@ApiParam(value = "", required = true) @PathVariable String userName) {

		UsersDetails usersDetails = new UsersDetails();

		usersDetails = convertUsersDetails(usersDetailsService.getUsersDetails(userName));
		if (!StringUtils.isEmpty(usersDetails.getMemorableWord())) {
			return ResponseEntity.ok().body(usersDetails);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	private Users loginAttemptsConditioncheck(UsersLoginRecord login, Users user) {
		int loginAttempts = 0;
		if (user.getUserId() != 0) {
			loginAttempts = loginService.loginAttempts(convertLogin(login), user.getUserId());
			if (loginAttempts < 3 || loginAttempts == 0) {
				user.setUsersDetails(null);
				user.setUserId(0);
				return user;
			} else {
				return new Users();
			}
		}
		return user;
	}

	private UsersDetails convertUsersDetails(com.ccsbi.co.usermanagement.service.model.UsersDetails usersDetails) {

		return dozerMapper.map(usersDetails, UsersDetails.class);
	}

	private UsersPhoto convertPClient(com.ccsbi.co.usermanagement.service.model.UsersPhoto usersPhoto) {

		return dozerMapper.map(usersPhoto, UsersPhoto.class);
	}

	private com.ccsbi.co.usermanagement.service.model.UsersPhoto convertPModel(UsersPhoto userPhoto) {

		return dozerMapper.map(userPhoto, com.ccsbi.co.usermanagement.service.model.UsersPhoto.class);
	}

	private Users convertUsers(com.ccsbi.co.usermanagement.service.model.Users user) {

		return dozerMapper.map(user, Users.class);
	}

	private com.ccsbi.co.usermanagement.service.model.Users convert(Users user) {

		return dozerMapper.map(user, com.ccsbi.co.usermanagement.service.model.Users.class);
	}

	@SuppressWarnings("unused")
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
