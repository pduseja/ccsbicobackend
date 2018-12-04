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
import com.ccsbi.co.usermanagement.client.entity.SystemParams;
import com.ccsbi.co.usermanagement.service.ISystemParamsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SystemParamsAPI {

	private static final Logger LOGGER = LoggerFactory.getLogger(SystemParamsAPI.class);

	@Autowired
	private Mapper dozerMapper;
	
	@Autowired
	private ISystemParamsService iSystemParamsService;
	
	@ApiOperation(value = "System Params", notes = "System Params", nickname = "System Params")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/params/{paramsList}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<SystemParams> paramList(@ApiParam(value = "", required = true) @PathVariable String paramsList) {
		
		LOGGER.debug("Inside Params Get Method");
		List<SystemParams> list = new ArrayList<>();
		list = convert(iSystemParamsService.getParamsList());
		return list;
			
	}

	@SuppressWarnings("unchecked")
	private List<SystemParams> convert(List<com.ccsbi.co.usermanagement.service.model.SystemParams> paramsList) {
		List<SystemParams> list = new ArrayList<>();
		return (List<SystemParams>) dozerMapper.map(paramsList, list.getClass());
	}
}
