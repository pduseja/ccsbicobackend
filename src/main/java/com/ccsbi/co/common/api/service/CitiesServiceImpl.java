package com.ccsbi.co.common.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.common.api.repository.CitiesRepo;
import com.ccsbi.co.common.api.repository.CountryRepo;
import com.ccsbi.co.common.api.repository.StatesRepo;

@Service
public class CitiesServiceImpl implements ICitiesService {

	@Autowired
	CountryRepo countryRepo;

	@Autowired
	StatesRepo statesRepo;

	@Autowired
	CitiesRepo citiesRepo;

	@Override
	public List<String> getCitiesList(String countryName, String stateName) {
		List<String> list = new ArrayList<>();
		int countryId = countryRepo.getCountryId(countryName);

		if (countryId > 0) {
			int stateId = statesRepo.getStateId(countryId, stateName);

			if (stateId > 0) {
				list = citiesRepo.getCitiesList(stateId);
				if (list.size() == 0) {

					list.add(stateName);

				}
			}
		}

		return list;
	}

}
