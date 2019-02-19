package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.email.IEmailService;
import com.ccsbi.co.usermanagement.repository.IMessageFollowUpRepo;
import com.ccsbi.co.usermanagement.repository.IMessageRepo;
import com.ccsbi.co.usermanagement.repository.ProfilesRepo;
import com.ccsbi.co.usermanagement.repository.SystemParamsRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.IMessage;
import com.ccsbi.co.usermanagement.service.model.IMessageFollowUp;
import com.ccsbi.co.usermanagement.util.Appconfig;

@Transactional
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
	IIMessageFollowUpService iMessageFollowUpServiceImpl;

	@Autowired
	IMessageFollowUpRepo iMessageFollowUpRepo;

	@Autowired
	Appconfig appConfig;

	@Autowired
	Mapper dozerMapper;

	@Autowired
	IEmailService iEmailService;

	@Override
	public IMessage saveIMessage(IMessage iMessage) {
		IMessage iMessageSave = new IMessage();

		com.ccsbi.co.usermanagement.repository.entity.IMessage iMessageEnt = new com.ccsbi.co.usermanagement.repository.entity.IMessage();
		String userName = iMessage.getUserName() != null ? iMessage.getUserName() : "";
		if (StringUtils.isEmpty(userName)) {
			iMessage.setCrBy(iMessage.getFirstName());
		}
		iMessageEnt = iMessageRepo.save(convertModel(iMessage));
		try {
			if (iMessageEnt.getiMessageId() > 0) {
				iMessageSave = convert(iMessageEnt);

				int refId = iMessageSave.getiMessageId();
				String to = iMessageSave.getEmail() != null ? iMessageSave.getEmail() : "";
				String subject = iMessageSave.getSubject();
				String text = "Your message has been recorded with us and we will get back to you shortly\n"
						+ "Please use ref # in subject for your future communications\n" + "\n" + "Cheers\n"
						+ "Thanks & regards,\n" + "CCSBI Team";
				if (!StringUtils.isEmpty(to)) {
					// iMessage record creation email
					if (appConfig.getEmail().equalsIgnoreCase("YES")) {
						iEmailService.sendMailIMessage(to,
								subject + " in context to your request, this is your ref #: '" + refId + "'", text);
					}
				} else {
					int mobile = iMessageSave.getMobile();
					if (appConfig.getSms().equalsIgnoreCase("YES")) {

						// Add logic to send SMS
					}
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

		}
		if (!listMessageEnt.isEmpty()) {

			Iterator<com.ccsbi.co.usermanagement.repository.entity.IMessage> itr = listMessageEnt.iterator();

			while (itr.hasNext()) {
				com.ccsbi.co.usermanagement.repository.entity.IMessage iMessageEnt = itr.next();
				IMessage iMessageModel = convert(iMessageEnt);

				List<IMessageFollowUp> listIMessageFollowUp = iMessageFollowUpServiceImpl
						.getIMessageFollowUpList(iMessageModel.getiMessageId());

				iMessageModel.setiMessageFollowUpList(listIMessageFollowUp);
				listMessage.add(iMessageModel);

			}
		}
		return listMessage;
	}

	@Override
	public List<IMessage> getMyIMessage(String userName) {
		List<IMessage> listMessage = new ArrayList<>();
		List<com.ccsbi.co.usermanagement.repository.entity.IMessage> listMessageEnt = new ArrayList<>();
		listMessageEnt = iMessageRepo.getMessageLst(userName);
		if (!listMessageEnt.isEmpty()) {

			Iterator<com.ccsbi.co.usermanagement.repository.entity.IMessage> itr = listMessageEnt.iterator();

			while (itr.hasNext()) {
				com.ccsbi.co.usermanagement.repository.entity.IMessage iMessageEnt = itr.next();
				IMessage iMessageModel = convert(iMessageEnt);

				List<IMessageFollowUp> listIMessageFollowUp = iMessageFollowUpServiceImpl
						.getIMessageFollowUpList(iMessageModel.getiMessageId());

				iMessageModel.setiMessageFollowUpList(listIMessageFollowUp);
				listMessage.add(iMessageModel);

			}
		}
		return listMessage;
	}

	@Override
	public IMessage saveFollowUpIMessage(IMessage iMessage) {
		List<IMessageFollowUp> iMessageFollowUpList = iMessage.getiMessageFollowUpList();
		if (!iMessageFollowUpList.isEmpty()) {
			IMessageFollowUp iMessageFollowUp = iMessageFollowUpList.get(0);
			iMessageFollowUp.setCrBy(iMessage.getUserName());

			iMessageFollowUp.setiMessage(iMessage);
			com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp iMessageFollowUpEnt = iMessageFollowUpRepo
					.save(convertIMessageFollowUp(iMessageFollowUp));
			if (iMessageFollowUpEnt.getiMessageFollowUpId() > 0) {
				iMessageFollowUp = convertIMessageFollowupModel(iMessageFollowUpEnt);
				iMessage.getiMessageFollowUpList().clear();
				iMessageFollowUpList.clear();
				iMessageFollowUpList.add(iMessageFollowUp);
				iMessage.setiMessageFollowUpList(iMessageFollowUpList);
				System.out.println("New FollowUp Message Added");

				int originalRefId = iMessage.getiMessageId();
				int refId = iMessageFollowUpEnt.getiMessageFollowUpId();
				String to = iMessage.getEmail() != null ? iMessage.getEmail() : "";
				String subject = iMessage.getSubject();
				String text = "Your message has been recorded with us and we will get back to you shortly\n"
						+ "Please use ref # in subject for your future communications\n" + "\n" + "Cheers\n"
						+ "Thanks & regards,\n" + "CCSBI Team";
				if (!StringUtils.isEmpty(to)) {
					// iMessage record creation email
					if (appConfig.getEmail().equalsIgnoreCase("YES")) {
						iEmailService.sendMailIMessage(to,
								subject + " in context to your followup for your Original RefID: '" + originalRefId
										+ "' A new Followup ID is generated ref #: '" + refId + "' for your Reference"
										+ " Always use Original RefId for FollowUp",
								text);
					}
				} else {
					int mobile = iMessage.getMobile();
					if (appConfig.getSms().equalsIgnoreCase("YES")) {

						// Add logic to send SMS
					}

				}

			} else {
				new IMessage();
			}
		}

		return iMessage;
	}

	@Override
	public IMessage saveFollowUpIMessageSupportTeam(IMessage iMessage) {
		Date modDate = new Date(Calendar.getInstance().getTime().getTime());

		List<IMessageFollowUp> iMessageFollowUpList = iMessage.getiMessageFollowUpList();
		if (!iMessageFollowUpList.isEmpty()) {
			IMessageFollowUp iMessageFollowUp = iMessageFollowUpList.get(0);

			int iMessageFollowUpEnt = iMessageFollowUpRepo.updateiMessageFollowUp(iMessageFollowUp.getMessageReply(),
					"Y", "Y", iMessageFollowUp.getModBy(), modDate,
					iMessageFollowUp.getFileContent(), iMessageFollowUp.getiMessageFollowUpId());
			if (iMessageFollowUpEnt > 0) {

				System.out.println("Reply to FollowUp Message Recorded");

				int originalRefId = iMessage.getiMessageId();
				int refId = iMessageFollowUp.getiMessageFollowUpId();
				String to = iMessage.getEmail() != null ? iMessage.getEmail() : "";
				String subject = iMessage.getSubject();
				String text = "In context to your query: " + iMessage.getSubject() + "Your Message: "
						+ iMessage.getMessage() + "\n" + "Our Response is: " + iMessageFollowUp.getMessageReply() + "\n"
						+ "\n" + "Cheers\n" + "Thanks & regards,\n" + "CCSBI Team";
				if (!StringUtils.isEmpty(to)) {
					// iMessage record creation email
					if (appConfig.getEmail().equalsIgnoreCase("YES")) {
						iEmailService.sendMailIMessage(to,
								subject + " In Context to your followup for your Original Ref ID: " + originalRefId
										+ " and Subsequent followupID " + iMessageFollowUp.getiMessageFollowUpId(),
								text);
					}
				} else {
					int mobile = iMessage.getMobile();
					if (appConfig.getSms().equalsIgnoreCase("YES")) {

						// Add logic to send SMS
					}

				}

			} else {
				new IMessage();
			}
		}
		iMessage.setModDate(modDate);
		return iMessage;

	}

	@Override
	public IMessage saveIMessageSupportTeam(IMessage iMessage) {
		Date modDate = new Date(Calendar.getInstance().getTime().getTime());
		int iMessageUpdate = iMessageRepo.updateiMessage(iMessage.getMessageReply(), "Y", "Y", iMessage.getModBy(),
				modDate, iMessage.getFileContent(), iMessage.getiMessageId());
		
		if (iMessageUpdate > 0) {

			System.out.println("Reply to  Message Recorded");

			int originalRefId = iMessage.getiMessageId();

			String to = iMessage.getEmail() != null ? iMessage.getEmail() : "";
			String subject = iMessage.getSubject();
			String text = "In context to your query: " + iMessage.getSubject() + "Your Message: "
					+ iMessage.getMessage() + "\n" + "Our Response is: " + iMessage.getMessageReply() + "\n" + "\n"
					+ "Cheers\n" + "Thanks & regards,\n" + "CCSBI Team";
			if (!StringUtils.isEmpty(to)) {
				// iMessage record creation email
				if (appConfig.getEmail().equalsIgnoreCase("YES")) {
					iEmailService.sendMailIMessage(to,
							subject + " In Context to your followup for your Original Ref ID: " + originalRefId, text);
				}
			} else {
				int mobile = iMessage.getMobile();
				if (appConfig.getSms().equalsIgnoreCase("YES")) {

					// Add logic to send SMS
				}

			}

		} else {
			new IMessage();
		}
		iMessage.setModDate(modDate);
		return iMessage;
	}

	private IMessageFollowUp convertIMessageFollowupModel(
			com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp iMessageFollowUpEnt) {

		return dozerMapper.map(iMessageFollowUpEnt, IMessageFollowUp.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp convertIMessageFollowUp(
			IMessageFollowUp iMessageFollowUp) {

		return dozerMapper.map(iMessageFollowUp, com.ccsbi.co.usermanagement.repository.entity.IMessageFollowUp.class);
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
