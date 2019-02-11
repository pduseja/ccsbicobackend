package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.IMessageFollowUpRepo;
import com.ccsbi.co.usermanagement.service.model.IMessageFollowUp;

@Service
public class IMessageFollowUpServiceImpl implements IIMessageFollowUpService {

	@Autowired
	private IMessageFollowUpRepo iMessageFollowUpRepo;
	
	@Autowired
	private Mapper dozerMapper;
	
	@Override
	public List<IMessageFollowUp> getIMessageFollowUpList(int iMessageId) {
		
		List<com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp> iMessageFollowUpEntList = iMessageFollowUpRepo.getIMessageFollowUpList(iMessageId);
		List<IMessageFollowUp> iMessageFollowUpList = new ArrayList<>();
		
		if(!iMessageFollowUpEntList.isEmpty()) {
			iMessageFollowUpList = convertIMessageFollowUp(iMessageFollowUpEntList);
		}
		return iMessageFollowUpList;
	}

	@SuppressWarnings("unchecked")
	private List<IMessageFollowUp> convertIMessageFollowUp(
			List<com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp> iMessageFollowUpEntList) {
		List<IMessageFollowUp> iMessageFollowUpList = new ArrayList<>();
		return (List<IMessageFollowUp>)dozerMapper.map(iMessageFollowUpEntList, iMessageFollowUpList.getClass());
	}

}
