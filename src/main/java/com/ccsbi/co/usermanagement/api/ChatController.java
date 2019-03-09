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
	public int getUser(String userName, String department) throws Exception {
		int queue = chatService.getLatestQueueForUser(userName, department);
		if(queue==0) {
			return 0;
		} else {
			Thread.sleep(4000);
			return queue;
		}
		
	}
}
