package com.ccsbi.co.usermanagement.service;

import java.util.List;

import com.ccsbi.co.usermanagement.service.model.Faq;

public interface IFaqService {
	
	List<Faq> getActiveFaq();
	
	Faq saveFaq(Faq faq);
	
	int updateFaq(Faq faq);

}
