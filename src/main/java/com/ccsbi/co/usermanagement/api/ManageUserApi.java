package com.ccsbi.co.usermanagement.api;

import java.io.IOException;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsbi.co.usermanagement.client.entity.Users;
import com.ccsbi.co.usermanagement.client.entity.UsersPhoto;
import com.ccsbi.co.usermanagement.service.IAddressDetailsService;
import com.ccsbi.co.usermanagement.service.ILoginService;
import com.ccsbi.co.usermanagement.service.ISecurityQuestionsService;
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
public class ManageUserApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManageUserApi.class);

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

	@Autowired
	IAddressDetailsService addressDetailsService;

	@Autowired
	ISecurityQuestionsService securityQuestionsService;

	@ApiOperation(value = "Update Personal Info", notes = "Update Personal Info", nickname = "Update Personal Info")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PatchMapping(path = "/updatePerAddDetails", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<Users> updatePersonalAddressDetails(@ApiParam(value = "user", required = true) @Valid String users,
			@RequestParam(value = "photo", required = false) MultipartFile photo) throws Exception {

		LOGGER.debug("Inside update Personal Address Details Method");
		String userName = null;
		int updatePhoto = 0;
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
					userPhoto.setPhotoId(user.getPhotoId());
					userPhoto.setPhotoContent(photoContent);
					updatePhoto = usersPhotoService.update(convertPModel(userPhoto), photo);
					
				}

		
		int update = usersService.update(convertUsers(user));
		if (update>0 || updatePhoto>0) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	

	@ApiOperation(value = "Update Sec Info", notes = "Update Sec Info", nickname = "Update Sec Info")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PatchMapping(path = "/updatePerSecDetails", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Users> updatePersonalSecDetails(
			@ApiParam(value = "", required = true) @RequestBody Users users) {

		LOGGER.debug("Inside update Personal Security Details Method");
		int update = usersService.updateSecurityDetails(convertUsers(users));
		if (update != 0) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	private com.ccsbi.co.usermanagement.service.model.Users convertUsers(Users users) {

		return dozerMapper.map(users, com.ccsbi.co.usermanagement.service.model.Users.class);
	}

	private com.ccsbi.co.usermanagement.service.model.UsersPhoto convertPModel(UsersPhoto userPhoto) {

		return dozerMapper.map(userPhoto, com.ccsbi.co.usermanagement.service.model.UsersPhoto.class);
	}
	
	private UsersPhoto convertPClient(com.ccsbi.co.usermanagement.service.model.UsersPhoto usersPhoto) {

		return dozerMapper.map(usersPhoto, UsersPhoto.class);
	}

}
