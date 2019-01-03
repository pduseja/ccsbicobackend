package com.ccsbi.co.common.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccsbi.co.common.api.service.ICitiesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CommonApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommonApi.class);

	@Autowired
	private ICitiesService citiesService;

	@ApiOperation(value = "Cities List", notes = "Cities List", nickname = "Cities List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/cities/{countryName}/{stateName}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> citiesList(@ApiParam(value = "", required = true) @PathVariable String countryName,
			@ApiParam(value = "", required = true) @PathVariable String stateName) {

		LOGGER.debug("Inside Params Get Method");
		List<String> list = new ArrayList<>();
		list = citiesService.getCitiesList(countryName, stateName);
		return list;

	}
}
