package com.ccsbi.co.common.api;

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

import com.ccsbi.co.usermanagement.client.entity.Profiles;
import com.ccsbi.co.usermanagement.service.IProfilesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfilesApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfilesApi.class);

	@Autowired
	private IProfilesService profilesServiceImpl;

	@Autowired
	Mapper dozerMapper;

	@ApiOperation(value = "Profiles List", notes = "Profiles List", nickname = "Profiles List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/profiles/{profiles}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Profiles> profilesList(@ApiParam(value = "", required = true) @PathVariable String profiles) {

		LOGGER.debug("Inside Params Get Method");
		List<Profiles> list = new ArrayList<>();
		list = convert(profilesServiceImpl.getProfilesList());
		return list;

	}

	@SuppressWarnings("unchecked")
	private List<Profiles> convert(List<com.ccsbi.co.usermanagement.service.model.Profiles> profilesList) {
		List<Profiles> list = new ArrayList<>();
		return (List<Profiles>)dozerMapper.map(profilesList, list.getClass());
	}

}
