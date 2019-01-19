package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.repository.FaqRepo;
import com.ccsbi.co.usermanagement.service.model.Faq;

@Transactional
@Service
public class FaqServiceImpl implements IFaqService {

	@Autowired
	private FaqRepo faqRepo;

	@Autowired
	Mapper dozerMapper;

	@Override
	public List<Faq> getActiveFaq() {
		List<Faq> list = new ArrayList<>();

		List<com.ccsbi.co.usermanagement.repository.entity.Faq> listEnt = new ArrayList<>();
		String status = "A";
		listEnt = faqRepo.getActiveFaq(status);
		if (!listEnt.isEmpty()) {
			list = convert(listEnt);
		}

		return list;
	}

	@Override
	public Faq saveFaq(Faq faq) {
		com.ccsbi.co.usermanagement.repository.entity.Faq faqEnt = faqRepo.save(convertFaq(faq));
		Faq faqM = new Faq();
		if (faqEnt.getId() > 0) {
			faqM = convertFaqE(faqEnt);
		}
		return faqM;
	}

	@Override
	public int updateFaq(Faq faq) {
		
		int update = 0;
		String question = faq.getQuestion();
		String answer = faq.getAnswer();		
		Date modDate = new Date(Calendar.getInstance().getTime().getTime());
		update = faqRepo.updateFaq(faq.getId(),question,answer,modDate
				);
		if(update!=0) {
			return update;
		} else {
			return 0;
		}
		
	}

	@Override
	public int deleteFaq(Faq faq) {
		
		int delete = 0;
		
		delete = faqRepo.deleteFaq(faq.getId());
		if(delete!=0) {
			return delete;
		} else {
			return delete;
		}
		
	}
	
	private Faq convertFaqE(com.ccsbi.co.usermanagement.repository.entity.Faq faqEnt) {

		return dozerMapper.map(faqEnt, Faq.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.Faq convertFaq(Faq faq) {

		return dozerMapper.map(faq, com.ccsbi.co.usermanagement.repository.entity.Faq.class);
	}

	@SuppressWarnings("unchecked")
	private List<Faq> convert(List<com.ccsbi.co.usermanagement.repository.entity.Faq> listEnt) {
		List<Faq> list = new ArrayList<>();

		return (List<Faq>) dozerMapper.map(listEnt, list.getClass());
	}

}
