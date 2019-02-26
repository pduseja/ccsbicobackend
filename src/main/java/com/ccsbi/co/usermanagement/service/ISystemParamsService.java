package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.SystemParams;

public interface ISystemParamsService {

	public List<SystemParams> getParamsList();
	
	public List<String> getMsgAboutList();
	
	public List<String> getContactUsDepartment();
	
}
