package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.LiveChat;
import com.ccsbi.co.usermanagement.service.model.LiveChatMembers;

public interface IChatService {
	
	public int getLatestQueueNumber(String userName, String department);
	
	public LiveChatMembers updateQueueNumber(LiveChatMembers liveChatMembers);
	
	public List<LiveChat> getlivechatAsPerdepartment(String department);
	
	public LiveChat getLivechatRequestQueue(LiveChat livechat);
	
	public int getLatestQueueForUser(String userName, String department);
	
	public String broadcastMessage(String userName, String department);

}
