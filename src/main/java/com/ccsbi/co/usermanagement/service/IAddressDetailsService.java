package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.AddressDetails;

public interface IAddressDetailsService {
	
	AddressDetails save(AddressDetails addressDetails);
	
	int update(AddressDetails addressDetails,int userid);
	
	List<AddressDetails> getAddressList(int userid);
	
	int sizeOfAddressList(int userId);

}
