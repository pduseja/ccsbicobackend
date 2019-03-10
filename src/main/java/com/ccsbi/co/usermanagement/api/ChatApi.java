package com.ccsbi.co.usermanagement.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.json.JSONObject;
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

import com.ccsbi.co.usermanagement.client.entity.LiveChat;
import com.ccsbi.co.usermanagement.client.entity.LiveChatMembers;
import com.ccsbi.co.usermanagement.service.IChatService;
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
public class ChatApi {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChatApi.class);

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	private IChatService chatService;

	@ApiOperation(value = "Get The Queue Number", notes = "Get The Queue Number", nickname = "Get The Queue Number")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/queueNumber/{userName}/{department}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public int getLatestQueueNumber(@ApiParam(value = "", required = true) @PathVariable String userName,
			@ApiParam(value = "", required = true) @PathVariable String department) {

		int number = chatService.getLatestQueueNumber(userName, department);
		if (number > 0) {
			return number;
		} else {
			return 0;
		}

	}

	@ApiOperation(value = "Update Queue Number", notes = "Update Queue Number", nickname = "Update Queue Number")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PatchMapping(path = "/updateQueueNumber", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LiveChatMembers> updateQueueNumber(
			@ApiParam(value = "", required = true) @RequestBody LiveChatMembers liveChatMembers) {

		LOGGER.debug("Inside Update Queue Number Method");
		liveChatMembers = convertModel(chatService.updateQueueNumber(convert(liveChatMembers)));
		if (!StringUtils.isEmpty(liveChatMembers.getUserName())) {
			return ResponseEntity.ok().body(liveChatMembers);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@ApiOperation(value = "Get The Queue Number", notes = "Get The Queue Number", nickname = "Get The Queue Number")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@GetMapping(path = "/liveChat/{department}", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<LiveChat> getlivechatAsPerDepartment(
			@ApiParam(value = "", required = true) @PathVariable String department) {

		List<LiveChat> list = convertLCClientList(chatService.getlivechatAsPerdepartment(department));
		if (list.isEmpty()) {
			return new ArrayList<LiveChat>();
		} else {
			return list;
		}

	}

	@ApiOperation(value = "Get The Queue Number", notes = "Get The Queue Number", nickname = "Get The Queue Number")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/liveChatRequest", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<LiveChat> getLivechatRequestQueue(
			@ApiParam(value = "", required = true) @Valid String liveChat) throws Exception {

		LOGGER.info("Inside {}.getLivechatRequestQueue()", getClass().getSimpleName());

		JSONObject jsonObj = new JSONObject(liveChat);

		ObjectMapper mapper = new ObjectMapper();
		LiveChat livechatClient = mapper.readValue(jsonObj.toString(), LiveChat.class);

		LiveChat list = convertLCClientList(chatService.getLivechatRequestQueue(convertLC(livechatClient)));
		if (list.getLiveChatId() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else if (list.getLiveChatId() == 0) {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@ApiOperation(value = "Get The Queue Number", notes = "Get The Queue Number", nickname = "Get The Queue Number")
	@ApiResponses({ @ApiResponse(code = 200, message = "Success!"),
			@ApiResponse(code = 404, message = "Page not found") })
	@PostMapping(path = "/broadcastMessage", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE  })
	public ResponseEntity<String> broadcastMessage(@ApiParam(value = "", required = true) @Valid String userName,
			@ApiParam(value = "", required = true) @Valid String department) throws Exception {

		LOGGER.info("Inside {}.broadcastMessage()", getClass().getSimpleName());

		
		String success = chatService.broadcastMessage(userName,department);
		if (!StringUtils.isEmpty(success)) {
			return new ResponseEntity<>(success, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	private LiveChat convertLCClientList(com.ccsbi.co.usermanagement.service.model.LiveChat livechatRequestQueue) {

		return dozerMapper.map(livechatRequestQueue, LiveChat.class);
	}

	private com.ccsbi.co.usermanagement.service.model.LiveChat convertLC(LiveChat liveChat) {

		return dozerMapper.map(liveChat, com.ccsbi.co.usermanagement.service.model.LiveChat.class);
	}

	@SuppressWarnings("unchecked")
	private List<LiveChat> convertLCClientList(
			List<com.ccsbi.co.usermanagement.service.model.LiveChat> getlivechatAsPerdepartment) {
		List<LiveChat> list = new ArrayList<>();
		return (List<LiveChat>) dozerMapper.map(getlivechatAsPerdepartment, list.getClass());
	}

	private LiveChatMembers convertModel(com.ccsbi.co.usermanagement.service.model.LiveChatMembers updateQueueNumber) {

		return dozerMapper.map(updateQueueNumber, LiveChatMembers.class);
	}

	private com.ccsbi.co.usermanagement.service.model.LiveChatMembers convert(LiveChatMembers liveChatMembers) {

		return dozerMapper.map(liveChatMembers, com.ccsbi.co.usermanagement.service.model.LiveChatMembers.class);
	}

}
