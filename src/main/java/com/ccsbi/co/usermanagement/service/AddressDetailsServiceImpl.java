package com.ccsbi.co.usermanagement.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.AddressDetailsRepo;
import com.ccsbi.co.usermanagement.service.model.AddressDetails;


@Service
public class AddressDetailsServiceImpl implements IAddressDetailsService {

	@Autowired
	private AddressDetailsRepo addressDetailsRepo;
	
	@Autowired
	private Mapper dozerMapper;
	
	@Override
	public AddressDetails save(AddressDetails addressDetails) {
		
		
		return convertAddressDetails(addressDetailsRepo.save(convertAddress(addressDetails)));
	}

	private AddressDetails convertAddressDetails(com.ccsbi.co.usermanagement.repository.entity.AddressDetails addressDetails) {

		return dozerMapper.map(addressDetails, AddressDetails.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.AddressDetails convertAddress(AddressDetails addressDetails) {
		
		return dozerMapper.map(addressDetails, com.ccsbi.co.usermanagement.repository.entity.AddressDetails.class);
	}

	

}
