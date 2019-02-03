package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.IMessage;

public interface IContactUsService {

	public IMessage saveIMessage(IMessage iMessage);
	
	public List<IMessage> getIMessageList(String userName);
}
