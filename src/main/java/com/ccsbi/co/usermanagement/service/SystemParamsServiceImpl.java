package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.SystemParamsRepo;
import com.ccsbi.co.usermanagement.service.model.SystemParams;

@Service
public class SystemParamsServiceImpl implements ISystemParamsService {

	@Autowired
	private SystemParamsRepo systemParamsRepo;
	
	@Autowired
	Mapper dozerMapper;
	
	@Override
	public List<SystemParams> getParamsList() {
		List<SystemParams> list = new ArrayList<>();
		
		list = convert(systemParamsRepo.findAll());
		return list;
	}

	@SuppressWarnings("unchecked")
	private List<SystemParams> convert(List<com.ccsbi.co.usermanagement.repository.entity.SystemParams> findAll) {
		List<SystemParams> list = new ArrayList<>();
		
		return (List<SystemParams>) dozerMapper.map(findAll, list.getClass());
	}

	@Override
	public List<String> getMsgAboutList() {
		String keyVal1 = "Contact_Us";
		String keyVal2 = "iMessage";
		String keyVal3 = "msgAbout";
		int orderBy = 0;
		String msgAbout = systemParamsRepo.getMsgAboutUs(keyVal1, keyVal2, keyVal3,orderBy);
		String msgAbout1 = systemParamsRepo.getMsgAboutUs1(keyVal1, keyVal2, keyVal3,orderBy);
		String msgAbout2 = systemParamsRepo.getMsgAboutUs2(keyVal1, keyVal2, keyVal3,orderBy);
		List<String> msgAboutList = new ArrayList<>();
		msgAboutList.add(msgAbout);
		msgAboutList.add(msgAbout1);
		msgAboutList.add(msgAbout2);
		
		return msgAboutList;
	}

	@Override
	public List<String> getContactUsDepartment() {
		String keyVal1 = "Contact_Us";
		String keyVal2 = "iMessage";
		String keyVal3 = "department";
		List<String> contactUsDepartmentList = new ArrayList<>(); 
		String department1 = systemParamsRepo.getcontactUsDepatment(keyVal1, keyVal2, keyVal3);
		String department2 = systemParamsRepo.getcontactUsDepatment1(keyVal1, keyVal2, keyVal3);
		String department3 = systemParamsRepo.getcontactUsDepatment2(keyVal1, keyVal2, keyVal3);
		contactUsDepartmentList.add(department1);
		contactUsDepartmentList.add(department2);
		contactUsDepartmentList.add(department3);
		return contactUsDepartmentList;
	}

}
