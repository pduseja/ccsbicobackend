package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.IMessageFollowUp;

public interface IIMessageFollowUpService {
	
	List<IMessageFollowUp> getIMessageFollowUpList(int iMessageId);

}
