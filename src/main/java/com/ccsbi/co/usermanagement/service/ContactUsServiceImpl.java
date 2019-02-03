package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.email.IEmailService;
import com.ccsbi.co.usermanagement.repository.IMessageRepo;
import com.ccsbi.co.usermanagement.repository.ProfilesRepo;
import com.ccsbi.co.usermanagement.repository.SystemParamsRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.IMessage;

@Service
public class ContactUsServiceImpl implements IContactUsService {

	@Autowired
	IMessageRepo iMessageRepo;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	ProfilesRepo profilesRepo;

	@Autowired
	private SystemParamsRepo systemParamsRepo;

	@Autowired
	Mapper dozerMapper;

	@Autowired
	IEmailService iEmailService;

	@Override
	public IMessage saveIMessage(IMessage iMessage) {
		IMessage iMessageSave = new IMessage();

		com.ccsbi.co.usermanagement.repository.entity.IMessage iMessageEnt = new com.ccsbi.co.usermanagement.repository.entity.IMessage();
		iMessageEnt = iMessageRepo.save(convertModel(iMessage));
		try {
			if (iMessageEnt.getiMessageId() > 0) {
				iMessageSave = convert(iMessageEnt);

				int refId = iMessageSave.getiMessageId();
				String to = iMessageSave.getEmail();
				String subject = iMessageSave.getSubject();
				String text = "Your message has been recorded with us and we will get back to you shortly\n"
						+ "Please use ref # in subject for your future communications";
				if (!StringUtils.isEmpty(to)) {
					// iMessage record creation email
					iEmailService.sendMailIMessage(to,
							subject + " in context to your request, this is your ref #: '" + refId+"'", text);
				} else {
					int mobile = iMessageSave.getMobile();
					// Add logic to send SMS
				}

			} else {
				return new IMessage();
			}

		} catch (Exception e) {

		}

		return iMessageSave;
	}

	@Override
	public List<IMessage> getIMessageList(String userName) {

		List<IMessage> listMessage = new ArrayList<>();
		List<com.ccsbi.co.usermanagement.repository.entity.IMessage> listMessageEnt = new ArrayList<>();
		int profileId = usersRepo.getProfileId(userName);
		String department = profilesRepo.getRole(profileId);
		String keyVal1 = "Contact_Us";
		String keyVal2 = "iMessage";
		String keyVal3 = "department";
		String department1 = systemParamsRepo.getcontactUsDepatment(keyVal1, keyVal2, keyVal3);
		String department2 = systemParamsRepo.getcontactUsDepatment1(keyVal1, keyVal2, keyVal3);
		String department3 = systemParamsRepo.getcontactUsDepatment2(keyVal1, keyVal2, keyVal3);

		if ((StringUtils.startsWith(department, "C")) || (StringUtils.startsWith(department, "S"))
				|| (StringUtils.startsWith(department, "T"))) {
			if (StringUtils.startsWith(department, "S")) {
				listMessageEnt = iMessageRepo.getMessageList(department1);
			} else if (StringUtils.startsWith(department, "C")) {
				listMessageEnt = iMessageRepo.getMessageList(department2);
			} else if (StringUtils.startsWith(department, "T")) {
				listMessageEnt = iMessageRepo.getMessageList(department3);
			}

		} else {
			listMessageEnt = iMessageRepo.getMessageLst(userName);
		}

		listMessage = convertIMessage(listMessageEnt);
		return listMessage;
	}

	@SuppressWarnings("unchecked")
	private List<IMessage> convertIMessage(
			List<com.ccsbi.co.usermanagement.repository.entity.IMessage> listMessageEnt) {
		List<IMessage> listMessage = new ArrayList<>();
		return (List<IMessage>) dozerMapper.map(listMessageEnt, listMessage.getClass());
	}

	private IMessage convert(com.ccsbi.co.usermanagement.repository.entity.IMessage iMessageEnt) {

		return dozerMapper.map(iMessageEnt, IMessage.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.IMessage convertModel(IMessage iMessage) {

		return dozerMapper.map(iMessage, com.ccsbi.co.usermanagement.repository.entity.IMessage.class);
	}

}
