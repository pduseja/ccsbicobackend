package com.ccsbi.co.usermanagement.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ccsbi.co.usermanagement.client.entity.IMessage;
import com.ccsbi.co.usermanagement.service.IContactUsService;
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

public class CommunicationDashboardAPI {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationDashboardAPI.class);

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	private IContactUsService iContactUsServiceImpl;

	@ApiOperation(value = "iMessage Support Team List", notes = "iMessage Support Team List", nickname = "iMessage Support Team List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/iMessageList/{userName}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<IMessage> getIMessage(@ApiParam(value = "", required = true) @PathVariable String userName) {

		LOGGER.info("Inside {}.getIMessage()", getClass().getSimpleName());

		List<IMessage> listMessage = convertiMessageList(iContactUsServiceImpl.getIMessageList((userName)));

		if (listMessage.size() > 0) {
			return listMessage;
		} else {
			return new ArrayList<>();
		}

	}


	@ApiOperation(value = "Update Followup IMessage by Support team", notes = "Update Followup IMessage by Support team", nickname = "Update Followup IMessage by Support team")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PatchMapping(path = "/followUpIMessageReply", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> saveFollowUpIMessageSupportTeam(
			@ApiParam(value = "iMessage", required = true) @Valid String iMessageFollowUp,
			@RequestParam(value = "fileAttached", required = false) MultipartFile fileAttached) throws Exception {

		LOGGER.debug("Inside {}.saveFollowUpIMessageSupportTeam", getClass().getSimpleName());

		JSONObject jsonObj = new JSONObject(iMessageFollowUp);
		System.out.println("JSON Object in API class: " + jsonObj);

		ObjectMapper mapper = new ObjectMapper();
		IMessage iMessage = mapper.readValue(jsonObj.toString(), IMessage.class);
		System.out.println("Value of Support Team " + iMessage.getModBy() + " & fileAttached " + fileAttached);
		byte[] fileContent = null;

		// Content of Attached File from input
		if (fileAttached != null) {
			String fileName = StringUtils.cleanPath(fileAttached.getOriginalFilename());
			System.out.println("File name " + fileName);
			try {
				// Check if the file's name contains invalid characters
				if (fileName.contains("..")) {
					throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
				}
			} catch (IOException ex) {
				throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
			}
			fileContent = fileAttached.getBytes();
			iMessage.getiMessageFollowUpList().get(0).setFileContent(fileContent);
		}

		iMessage = convertiMessageClient(iContactUsServiceImpl.saveFollowUpIMessageSupportTeam(convertiMessage(iMessage)));
		System.out.println("FollowUp Message Updated by Support Team " + iMessage.getiMessageFollowUpList().size());
		System.out.println("FollowUp Message updated API Message ID " + iMessage.getiMessageId());
		if (iMessage.getModDate()!=null) {
			return new ResponseEntity<>("Your Follow Up Message is recorded and its reference number is: "
					+ iMessage.getiMessageFollowUpList().get(0).getiMessageFollowUpId()
					+ " But for next communication please use Original reference ID :" + iMessage.getiMessageId(),
					HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}


	@ApiOperation(value = "Update Followup IMessage by Support team", notes = "Update Followup IMessage by Support team", nickname = "Update Followup IMessage by Support team")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PatchMapping(path = "/iMessageReply", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> saveIMessageReplySupportTeam(
			@ApiParam(value = "iMessage", required = true) @Valid String iMessageFollowUp,
			@RequestParam(value = "fileAttached", required = false) MultipartFile fileAttached) throws Exception {

		LOGGER.debug("Inside {}.saveIMessageReplySupportTeam", getClass().getSimpleName());

		
		JSONObject jsonObj = new JSONObject(iMessageFollowUp);
		System.out.println("JSON Object in API class: " + jsonObj);

		ObjectMapper mapper = new ObjectMapper();
		IMessage iMessage = mapper.readValue(jsonObj.toString(), IMessage.class);
		System.out.println("Value of Support Team " + iMessage.getModBy() + " & fileAttached " + fileAttached);
		byte[] fileContent = null;

		// Content of Attached File from input
		if (fileAttached != null) {
			String fileName = StringUtils.cleanPath(fileAttached.getOriginalFilename());
			System.out.println("File name " + fileName);
			try {
				// Check if the file's name contains invalid characters
				if (fileName.contains("..")) {
					throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
				}
			} catch (IOException ex) {
				throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
			}
			fileContent = fileAttached.getBytes();
			iMessage.getiMessageFollowUpList().get(0).setFileContent(fileContent);
		}

		iMessage = convertiMessageClient(iContactUsServiceImpl.saveIMessageSupportTeam(convertiMessage(iMessage)));
		
		System.out.println("FollowUp Message updated API Message ID " + iMessage.getiMessageId());
		if (iMessage.getModDate()!=null) {
			return new ResponseEntity<>("Reply sent to User "+iMessage.getUserName(),HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	
	@SuppressWarnings("unchecked")
	private List<IMessage> convertiMessageList(List<com.ccsbi.co.usermanagement.service.model.IMessage> iMessageList) {
		List<IMessage> listMessage = new ArrayList<>();

		return (List<IMessage>) dozerMapper.map(iMessageList, listMessage.getClass());
	}
	
	private com.ccsbi.co.usermanagement.service.model.IMessage convertiMessage(IMessage iMessage) {

		return dozerMapper.map(iMessage, com.ccsbi.co.usermanagement.service.model.IMessage.class);
	}

	private IMessage convertiMessageClient(com.ccsbi.co.usermanagement.service.model.IMessage saveIMessage) {

		return dozerMapper.map(saveIMessage, IMessage.class);
	}


}
