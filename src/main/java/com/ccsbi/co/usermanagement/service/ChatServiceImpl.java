package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.LiveChatMembersRepo;
import com.ccsbi.co.usermanagement.repository.LiveChatRepo;
import com.ccsbi.co.usermanagement.service.model.LiveChat;
import com.ccsbi.co.usermanagement.service.model.LiveChatMembers;

@Service
@Transactional
public class ChatServiceImpl implements IChatService {

	@Autowired
	LiveChatMembersRepo liveChatMembersRepo;

	@Autowired
	LiveChatRepo liveChatRepo;

	@Autowired
	Mapper dozerMapper;

	@Override
	public int getLatestQueueNumber(String userName, String department) {
		department = findDepartment(department);
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
		String department = findDepartment(liveChatMembers.getDepartment());
		int queue = 0;
		int update = 0;
		int decrease = 0;
		String status = "A";
		queue = liveChatMembersRepo.getLatestQueueNumber(liveChatMembers.getUserName(), department, status);
		if (liveChatMembers.getAddNumber().equalsIgnoreCase("Y")) {
			queue = queue + 1;
			update = liveChatMembersRepo.updateQueueNumber(liveChatMembers.getUserName(), department, queue);
		} else {
			if (queue == 0) {
				decrease = updateQueue(department, status);
				update=0;
			} else {
				queue = queue - 1;
				decrease = updateQueue(department, status);
				update = liveChatMembersRepo.updateQueueNumber(liveChatMembers.getUserName(), department, queue);
			}
		}
		
		if (update > 0) {
			liveChatMembers.setQueue(queue);
			return liveChatMembers;
		} else {
			return liveChatMembers;
		}

	}


	@Override
	public List<LiveChat> getlivechatAsPerdepartment(String department) {

		department = findDepartment(department);
		String status = "A";
		List<com.ccsbi.co.usermanagement.repository.entity.LiveChat> listent =liveChatRepo.getlivechatAsPerdepartment(department, status); 
		List<LiveChat> listLiveChat = new ArrayList<>();
		if (listent.isEmpty()) {
			return new ArrayList<LiveChat>();
		} else {
			Iterator<com.ccsbi.co.usermanagement.repository.entity.LiveChat> itr = listent.iterator();
			while(itr.hasNext()) {
				LiveChat liveChatModel = convertLCModel(itr.next());
				listLiveChat.add(liveChatModel);
			}
			return listLiveChat;
		}

	}

	@Override
	public LiveChat getLivechatRequestQueue(LiveChat liveChat) {

		String department = findDepartment(liveChat.getDepartment());
		String status = "A";
		int number = 0;
		List<com.ccsbi.co.usermanagement.repository.entity.LiveChat> list = liveChatRepo
				.getLiveChatQueueNumber(department, status);
		if (!list.isEmpty()) {
			number = liveChatRepo.getChatQueueNumber(department, status);
		} else {
			number = liveChatMembersRepo.getQueueNumber(department, status);
		}

		liveChat.setQueue(number + 1);
		liveChat = convertLCModel(liveChatRepo.save(convertEnt(liveChat)));
		return liveChat;
	}

	private int updateQueue(String department, String status) {
		int i = 0;
		List<LiveChat> list = getlivechatAsPerdepartment(department);
		if (!list.isEmpty()) {
			Iterator<LiveChat> itr = list.iterator();
			while (itr.hasNext()) {
				LiveChat lc = itr.next();
				int queue = lc.getQueue();
				if (queue > 0) {
					queue = queue - 1;
				}
				i = liveChatRepo.updateQueue(queue,lc.getLiveChatId()); 

			}
		}
		return i;
	}
	
	private String findDepartment(String department) {
		if ((StringUtils.startsWith(department, "C"))) {
			department = "C";
		} else if ((StringUtils.startsWith(department, "S"))) {
			department = "S";
		} else if ((StringUtils.startsWith(department, "T"))) {

			department = "T";
		}
		return department;
	}

	private LiveChat convertLCModel(com.ccsbi.co.usermanagement.repository.entity.LiveChat save) {

		return dozerMapper.map(save, LiveChat.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.LiveChat convertEnt(LiveChat liveChat) {

		return dozerMapper.map(liveChat, com.ccsbi.co.usermanagement.repository.entity.LiveChat.class);
	}

}
