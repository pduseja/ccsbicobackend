package com.ccsbi.co.usermanagement.service;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.AddressDetailsRepo;
import com.ccsbi.co.usermanagement.service.model.AddressDetails;

@Transactional
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
	
	@Override
	public int update(AddressDetails addressDetails,int userid) {
		
		String flatNo = addressDetails.getFlatNo()!=null?addressDetails.getHouseName():"";
		String houseName = addressDetails.getHouseName()!=null?addressDetails.getHouseName():"";
		String addressLine1 = addressDetails.getAddressLine1()!=null?addressDetails.getAddressLine1():"";
		String addressLine2 = addressDetails.getAddressLine2()!=null?addressDetails.getAddressLine2():"";
		String addressLine3 = addressDetails.getAddressLine3()!=null?addressDetails.getAddressLine3():"";
		String cityTown = addressDetails.getCityTown()!=null?addressDetails.getCityTown():"";
		String stateProvince = addressDetails.getStateProvince()!=null?addressDetails.getStateProvince():"";
		String country = addressDetails.getCountry()!=null?addressDetails.getCountry():"";
		String pinPostCode = addressDetails.getPinPostCode()!=null?addressDetails.getPinPostCode():"";
		String type = addressDetails.getType()!=null?addressDetails.getType():"";
		String active = addressDetails.getActive()!=null?addressDetails.getActive():"";
		String mobile = addressDetails.getMobile()!=null?addressDetails.getMobile():"";
		String landline = addressDetails.getLandline()!=null?addressDetails.getLandline():"";
		String email = addressDetails.getEmail()!=null?addressDetails.getEmail():"";
		
				
		int update = addressDetailsRepo.update(flatNo, houseName, addressLine1, 
				addressLine2, addressLine3, cityTown, stateProvince, country, 
				pinPostCode, type, active, mobile, landline, email, userid);
		if(update!=0) {
			return update;			
		} else {
			return 0;
		}
		
	}

	private AddressDetails convertAddressDetails(com.ccsbi.co.usermanagement.repository.entity.AddressDetails addressDetails) {

		return dozerMapper.map(addressDetails, AddressDetails.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.AddressDetails convertAddress(AddressDetails addressDetails) {
		
		return dozerMapper.map(addressDetails, com.ccsbi.co.usermanagement.repository.entity.AddressDetails.class);
	}

	

}
