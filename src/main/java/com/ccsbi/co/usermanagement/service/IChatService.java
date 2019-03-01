package com.ccsbi.co.usermanagement.service;

import com.ccsbi.co.usermanagement.service.model.LiveChatMembers;

public interface IChatService {
	
	public int getLatestQueueNumber(String userName, String department);
	
	public LiveChatMembers updateQueueNumber(LiveChatMembers liveChatMembers);

}
