package com.ccsbi.co.common.api;

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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccsbi.co.usermanagement.service.IFaqService;
import com.ccsbi.co.usermanagement.service.model.Faq;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FaqApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(FaqApi.class);

	@Autowired
	private IFaqService faqServiceImpl;

	@Autowired
	Mapper dozerMapper;

	@ApiOperation(value = "Update Faq", notes = "Update Faq", nickname = "Update Faq")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/faq/{faq}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Faq> getActiveFaqList(@ApiParam(value = "", required = true) @PathVariable String faq) {

		LOGGER.debug("Inside get FAQ Method");
		List<Faq> list = new ArrayList<>();
		List<com.ccsbi.co.usermanagement.service.model.Faq> faqM = new ArrayList<>();
		faqM = faqServiceImpl.getActiveFaq();
		if(faqM.size()>0) {
		
		list = convert(faqM);
		} 
		
		return list;

	}

	@ApiOperation(value = "Save Faq", notes = "Save Faq", nickname = "Save Faq")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/saveFaq", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> saveFaq(@ApiParam(value = "", required = true) @RequestBody Faq faq) {

		LOGGER.debug("Inside save FAQ Method");
		Faq faqN = faqServiceImpl.saveFaq(convertF(faq));
		if (faqN.getId() > 0) {
			return new ResponseEntity<>("New FAQ is added successful", HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@ApiOperation(value = "Faq List", notes = "Faq List", nickname = "Faq List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PatchMapping(path = "/updateFaq", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateFaq(@ApiParam(value = "", required = true) @RequestBody Faq faq) {

		LOGGER.debug("Inside update FAQ Method");
		int update = faqServiceImpl.updateFaq(convertF(faq));
		if (update > 0) {
			return new ResponseEntity<>("Update was successful", HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@ApiOperation(value = "Faq List", notes = "Faq List", nickname = "Faq List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/deleteFaq", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteFaq(@ApiParam(value = "", required = true) @RequestBody Faq faq) {

		LOGGER.debug("Inside delete FAQ Method");
		int update = faqServiceImpl.deleteFaq(convertF(faq));
		if (update > 0) {
			return new ResponseEntity<>("Delete was successful", HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	private com.ccsbi.co.usermanagement.service.model.Faq convertF(Faq faq) {

		return dozerMapper.map(faq, com.ccsbi.co.usermanagement.service.model.Faq.class);
	}

	@SuppressWarnings("unchecked")
	private List<Faq> convert(List<Faq> activeFaq) {
		List<Faq> list = new ArrayList<>();
		return (List<Faq>) dozerMapper.map(activeFaq, list.getClass());
	}

}
