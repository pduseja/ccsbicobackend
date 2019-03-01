package com.ccsbi.co.usermanagement.service;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.LiveChatMembersRepo;
import com.ccsbi.co.usermanagement.service.model.LiveChatMembers;

@Service
@Transactional
public class ChatServiceImpl implements IChatService {

	@Autowired
	LiveChatMembersRepo liveChatMembersRepo;

	@Override
	public int getLatestQueueNumber(String userName, String department) {
		if ((StringUtils.startsWith(department, "C"))){
			department = "C";
		} else if((StringUtils.startsWith(department, "S"))){
			department = "S";
		} else if((StringUtils.startsWith(department, "T"))) {
			
			department = "T";
		}
		String status = "A";
		int number = liveChatMembersRepo.getLatestQueueNumber(userName, department, status);

		if (number > 0) {
			return number;
		} else {
			return 0;
		}

	}

	@Override
	public LiveChatMembers updateQueueNumber(LiveChatMembers liveChatMembers) {
		String department = liveChatMembers.getDepartment();
		if ((StringUtils.startsWith(department, "C"))){
			department = "C";
		} else if((StringUtils.startsWith(department, "S"))){
			department = "S";
		} else if((StringUtils.startsWith(department, "T"))) {
			
			department = "T";
		}
		int queue = 0;
		String status = "A";
		queue = liveChatMembersRepo.getLatestQueueNumber(liveChatMembers.getUserName(), department, status);
		if (liveChatMembers.getAddNumber().equalsIgnoreCase("Y")) {
			queue = queue + 1;
		} else {
			if(queue==0) {
				
			} else {
			queue = queue - 1;
			}
		}
		
		int update = liveChatMembersRepo.updateQueueNumber(liveChatMembers.getUserName(),
				department, queue);
		if (update > 0) {
			liveChatMembers.setQueue(queue);
			return liveChatMembers;
		} else {
			return new LiveChatMembers();
		}

	}
}
