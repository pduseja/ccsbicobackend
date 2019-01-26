package com.ccsbi.co.usermanagement.service;

import com.ccsbi.co.usermanagement.service.model.AddressDetails;

public interface IAddressDetailsService {
	
	AddressDetails save(AddressDetails addressDetails);
	
	int update(AddressDetails addressDetails,int userid);

}
