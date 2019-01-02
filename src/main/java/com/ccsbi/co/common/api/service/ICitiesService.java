package com.ccsbi.co.common.api.service;

import java.util.List;

public interface ICitiesService {

	public List<String> getCitiesList(String countryName,String stateName);
	
}
