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

}
