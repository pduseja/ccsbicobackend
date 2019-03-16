package com.ccsbi.co.usermanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.ccsbi.co.usermanagement.service.IChatService;

@Controller
public class ChatController {

	@Autowired
	private IChatService chatService;

	@MessageMapping("/chatQueue")
	@SendTo("/topic/chatQueue")
	public String getUser(String userName, String department) throws Exception {
		int queue = chatService.getLatestQueueForUser(userName, department);
		System.out.println("Queue "+queue);
		String supportUserName = chatService.getLatestQueueForUserName(userName, department);
		if(queue==0 && supportUserName!=null) {
			System.out.println("Hello : "+supportUserName);
			return String.valueOf(queue)+":"+supportUserName;
		} else {
			Thread.sleep(4000);
			return String.valueOf(queue);
		}
		
	}
}
