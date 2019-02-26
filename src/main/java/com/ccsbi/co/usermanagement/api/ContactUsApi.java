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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ccsbi.co.usermanagement.client.entity.IMessage;
import com.ccsbi.co.usermanagement.client.entity.IMessageFollowUp;
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
public class ContactUsApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsApi.class);

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	private IContactUsService iContactUsServiceImpl;

	@ApiOperation(value = "Record iMessage", notes = "Record iMessage", nickname = "Record iMessage")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/iMessageAdd", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> saveIMessage(@ApiParam(value = "iMessage", required = true) @Valid String iMessage,
			@RequestParam(value = "fileAttached", required = false) MultipartFile fileAttached) throws Exception {

		LOGGER.info("Inside {}.saveIMessage()", getClass().getSimpleName());

		JSONObject jsonObj = new JSONObject(iMessage);

		ObjectMapper mapper = new ObjectMapper();
		IMessage iMessages = mapper.readValue(jsonObj.toString(), IMessage.class);

		// Content of Attached File from input
		if (fileAttached != null) {
			String fileName = StringUtils.cleanPath(fileAttached.getOriginalFilename());

			try {
				// Check if the file's name contains invalid characters
				if (fileName.contains("..")) {
					throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
				}
			} catch (IOException ex) {
				throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
			}
			byte[] fileContent = fileAttached.getBytes();
			iMessages.setFileContent(fileContent);
		}
		String subject = "Feedback";
		iMessages = convertiMessageClient(iContactUsServiceImpl.saveIMessage(convertiMessage(iMessages)));

		if (iMessages.getiMessageId() > 0) {
			if(iMessages.getSubject().equalsIgnoreCase(subject)) {
				return new ResponseEntity<>(
						"Thanks a Lot for your Feedback.\n" +"Its valuable to us and helps us to improve our services",
						HttpStatus.OK);
			} else {
			return new ResponseEntity<>(
					"Your Message is recorded and its reference number is: " + iMessages.getiMessageId(),
					HttpStatus.OK);
			}
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@ApiOperation(value = "iMessage My List", notes = "iMessage My List", nickname = "iMessage My List")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/myIMessageList/{userName}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<IMessage> getMyIMessage(@ApiParam(value = "", required = true) @PathVariable String userName) {

		LOGGER.info("Inside {}.getMyIMessage()", getClass().getSimpleName());

		List<IMessage> listMessage = convertiMessageList(iContactUsServiceImpl.getMyIMessage((userName)));

		if (listMessage.size() > 0) {
			return listMessage;
		} else {
			return new ArrayList<>();
		}

	}


	@ApiOperation(value = "Add Followup IMessage", notes = "Add Followup IMessage", nickname = "Add Followup IMessage")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PatchMapping(path = "/addFollowUpIMessage", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<String> addFollowUpIMessage(
			@ApiParam(value = "iMessage", required = true) @Valid String iMessageFollowUp,
			@RequestParam(value = "fileAttached", required = false) MultipartFile fileAttached) throws Exception {

		LOGGER.debug("Inside {}.addFollowUpIMessage", getClass().getSimpleName());

		int iMessageFollowUpUpdate = 0;
		IMessageFollowUp iMessageFollowUpObj = new IMessageFollowUp();
		JSONObject jsonObj = new JSONObject(iMessageFollowUp);
		System.out.println("JSON Object in API class: " + jsonObj);

		ObjectMapper mapper = new ObjectMapper();
		IMessage iMessage = mapper.readValue(jsonObj.toString(), IMessage.class);
		System.out.println("Value of userName " + iMessage.getiMessageId() + " & fileAttached " + fileAttached);
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

		iMessage = convertiMessageClient(iContactUsServiceImpl.saveFollowUpIMessage(convertiMessage(iMessage)));
		System.out.println("New FollowUp Message Added API " + iMessage.getiMessageFollowUpList().size());
		System.out.println("New FollowUp Message Added API Message ID " + iMessage.getiMessageId());
		if (iMessage.getiMessageFollowUpList().size() > 0) {
			return new ResponseEntity<>("Your Follow Up Message is recorded and its reference number is: "
					+ iMessage.getiMessageFollowUpList().get(0).getiMessageFollowUpId()
					+ " But for next communication please use Original reference ID :" + iMessage.getiMessageId(),
					HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@SuppressWarnings("unchecked")
	private List<IMessage> convertiMessageList(List<com.ccsbi.co.usermanagement.service.model.IMessage> iMessageList) {
		List<IMessage> listMessage = new ArrayList<>();

		return (List<IMessage>) dozerMapper.map(iMessageList, listMessage.getClass());
	}

	private IMessage convertiMessageClient(com.ccsbi.co.usermanagement.service.model.IMessage saveIMessage) {

		return dozerMapper.map(saveIMessage, IMessage.class);
	}

	private com.ccsbi.co.usermanagement.service.model.IMessage convertiMessage(IMessage iMessage) {

		return dozerMapper.map(iMessage, com.ccsbi.co.usermanagement.service.model.IMessage.class);
	}

}
