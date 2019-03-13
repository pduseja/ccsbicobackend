package com.ccsbi.co.usermanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsbi.co.usermanagement.config.Appconfig;
import com.ccsbi.co.usermanagement.email.IEmailService;
import com.ccsbi.co.usermanagement.repository.LiveChatMembersRepo;
import com.ccsbi.co.usermanagement.repository.LiveChatRepo;
import com.ccsbi.co.usermanagement.repository.SystemParamsRepo;
import com.ccsbi.co.usermanagement.repository.UsersRepo;
import com.ccsbi.co.usermanagement.service.model.AddressDetails;
import com.ccsbi.co.usermanagement.service.model.LiveChat;
import com.ccsbi.co.usermanagement.service.model.LiveChatMembers;

@Service
@Transactional
public class ChatServiceImpl implements IChatService {

	@Autowired
	LiveChatMembersRepo liveChatMembersRepo;

	@Autowired
	LiveChatRepo liveChatRepo;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	AddressDetailsServiceImpl addressDetailsServiceImpl;

	@Autowired
	IEmailService iEmailService;

	@Autowired
	private SystemParamsRepo systemParamsRepo;

	@Autowired
	Appconfig appConfig;

	@Autowired
	Mapper dozerMapper;

	@Override
	public int getLatestQueueNumber(String userName, String department) {
		department = findDepartment(department);
		String status = "A";
		com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers number = liveChatMembersRepo
				.getLatestQueueNumber(userName, department, status);

		if (number != null) {
			return number.getQueue();
		} else {
			return 0;
		}

	}

	@Override
	public LiveChatMembers updateQueueNumber(LiveChatMembers liveChatMembers) {
		String department = findDepartment(liveChatMembers.getDepartment());
		int queue = 0;
		int update = 0;
		int decrease = 0;
		int add = 0;
		String status = "A";
		String userNameChat = liveChatMembers.getChatMember() != null ? liveChatMembers.getChatMember() : "";
		com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers livechatM = liveChatMembersRepo
				.getLatestQueueNumber(liveChatMembers.getUserName(), department, status);
		
		// If a New chat is started then increment of Queue Number for support
		// User Queue, but not the user with whom chat has started
		if (liveChatMembers.getAddNumber().equalsIgnoreCase("Y")) {
			queue = livechatM.getQueue() + 1;
			if (!StringUtils.isEmpty(userNameChat)) {
				add = liveChatRepo.updateSupportUserName(0, status, liveChatMembers.getUserName(), userNameChat);
				// Sending Queue number to inform UI that User with whom you
				// have initiated chat is still active. '0' means active: '1' :
				// Means inactive
				if (add != 0) {
					liveChatMembers.setQueue(0);
				} else {
					liveChatMembers.setQueue(1);
				}
			}
			update = liveChatMembersRepo.updateQueueNumber(liveChatMembers.getUserName(), department, queue);
		} else {
			if (queue == 0) {
				decrease = updateQueueZero(department, status, queue);

				add = liveChatRepo.updateSupportUserName(0, status, liveChatMembers.getUserName(), userNameChat);
				if (add != 0) {
					liveChatMembers.setQueue(0);
				} else {
					liveChatMembers.setQueue(1);
				}
				update = 0;
			} else {
				queue = livechatM.getQueue() - 1;
				decrease = updateQueue(department, status);
				update = liveChatMembersRepo.updateQueueNumber(liveChatMembers.getUserName(), department, queue);
			}
		}

		if (update > 0) {

			return liveChatMembers;
		} else {
			return liveChatMembers;
		}

	}

	@Override
	public List<LiveChat> getlivechatAsPerdepartment(String department) {

		department = findDepartment(department);
		String status = "A";
		List<com.ccsbi.co.usermanagement.repository.entity.LiveChat> listent = liveChatRepo
				.getlivechatAsPerdepartment(department, status);
		List<LiveChat> listLiveChat = new ArrayList<>();
		if (listent.isEmpty()) {
			return new ArrayList<LiveChat>();
		} else {
			Iterator<com.ccsbi.co.usermanagement.repository.entity.LiveChat> itr = listent.iterator();
			while (itr.hasNext()) {
				LiveChat liveChatModel = convertLCModel(itr.next());
				listLiveChat.add(liveChatModel);
			}
			return listLiveChat;
		}

	}

	@Override
	public LiveChat getLivechatRequestQueue(LiveChat liveChat) {
		String status = "A";
		int number = 0;
		int update = 0;
		String department = findDepartment(liveChat.getDepartment());
		department = getDepartment(department);
		com.ccsbi.co.usermanagement.repository.entity.LiveChat chatEnt = liveChatRepo.findUser(liveChat.getUserName(),
				status, department);
		if (chatEnt != null) {
			number = chatEnt.getQueue();
		}
		List<com.ccsbi.co.usermanagement.repository.entity.LiveChat> list = liveChatRepo
				.getLiveChatQueueNumber(department, status);
		if (number == 0) {
			if (!list.isEmpty()) {
				number = liveChatRepo.getChatQueueNumber(department, status);
			} else {
				List<com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers> listEnt = liveChatMembersRepo
						.getListLiveChatMember(department, status);
				if (!listEnt.isEmpty()) {
					number = liveChatMembersRepo.getQueueNumber(department, status);
				} else {
					number = 0;
					LiveChat livechatModel = new LiveChat();
					livechatModel.setLiveChatId(0);
					return livechatModel;
				}
			}
			liveChat.setQueue(number + 1);
			liveChat = convertLCModel(liveChatRepo.save(convertEnt(liveChat)));
			return liveChat;
		} else {
			status = "N";
			if (chatEnt != null) {
				update = liveChatRepo.updateLiveChat(chatEnt.getLiveChatId(), status);
				if (update > 0) {
					liveChat.setQueue(chatEnt.getQueue());
					liveChat = convertLCModel(liveChatRepo.save(convertEnt(liveChat)));
					return liveChat;
				} else {
					return new LiveChat();
				}
			} else {
				liveChat.setQueue(number);
				liveChat = convertLCModel(liveChatRepo.save(convertEnt(liveChat)));
				return liveChat;
			}
		}
	}

	@Override
	public int getLatestQueueForUser(String userName, String department) {
		department = findDepartment(department);
		String status = "A";
		com.ccsbi.co.usermanagement.repository.entity.LiveChat queue = liveChatRepo.getLatestQueueForUser(department,
				status, userName);
		if (queue != null) {
			return queue.getQueue();
		} else {
			return 0;
		}
	}

	@Override
	public String getLatestQueueForUserName(String userName, String department) {
		department = findDepartment(department);
		String status = "A";
		int queue = 0;
		com.ccsbi.co.usermanagement.repository.entity.LiveChat liveChat = liveChatRepo
				.getLatestQueueForUserSupportName(status, userName, queue);
		if (liveChat != null) {
			return liveChat.getSupportUserName();
		} else {
			return "";
		}
	}

	@Override
	public String broadcastMessage(String userName, String department) {
		department = findDepartment(department);
		String departmentStr = getDepartment(department);
		String status = "A";
		List<String> listActiveUsers = liveChatMembersRepo.broadcastMessage(userName, department, status);
		if (!listActiveUsers.isEmpty()) {
			Iterator<String> itr = listActiveUsers.iterator();
			while (itr.hasNext()) {
				String userName1 = itr.next();
				com.ccsbi.co.usermanagement.repository.entity.Users users = usersRepo.loginUser(userName1);
				AddressDetails addressDetails = addressDetailsServiceImpl.getAddressDetails(users.getUserId());

				String to = addressDetails.getEmail() != null ? addressDetails.getEmail() : "";
				String subject = "Too many customers awaiting chat responses";
				String text = "Hello " + users.getFirstName() + "\n"
						+ " Many customers are awaiting response for Chat for department \n" + departmentStr
						+ "Please Login to attend the extra rush of Queries.\n" + " Thanks & regards,\n"
						+ "CCSBI Admin";
				if (!StringUtils.isEmpty(to)) {
					if (appConfig.getEmail().equalsIgnoreCase("YES")) {
						iEmailService.sendRegistrationMail(to, subject, text);
					}
				}
			}
			return "success";
		} else {
			return "No User Available now";
		}
	}

	@Override
	public String joinChat(String userName) {
		String success = new String();
		int update = 0;
		String status = "A";
		update = liveChatMembersRepo.update(status, userName);
		if (update > 0) {
			success = "Success";
		} else {
			success = "";
		}
		return success;
	}

	@Override
	public String leaveChat(String userName) {
		String success = new String();
		int update = 0;
		String status = "N";
		update = liveChatMembersRepo.update(status, userName);
		if (update > 0) {
			success = "Success";
		} else {
			success = "";
		}
		return success;
	}

	private String getDepartment(String department) {
		String keyVal1 = "Contact_Us";
		String keyVal2 = "live_chat";
		String keyVal3 = "Department";
		if ((StringUtils.startsWith(department, "C"))) {
			department = systemParamsRepo.getcontactUsDepatmentValue(keyVal1, keyVal2, keyVal3, department);
		} else if ((StringUtils.startsWith(department, "S"))) {
			department = systemParamsRepo.getcontactUsDepatmentValue(keyVal1, keyVal2, keyVal3, department);
		} else if ((StringUtils.startsWith(department, "T"))) {
			department = systemParamsRepo.getcontactUsDepatmentValue(keyVal1, keyVal2, keyVal3, department);
		}
		return department;
	}

	private int updateQueue(String department, String status) {
		int i = 0;
		List<LiveChat> list = getlivechatAsPerdepartment(department);
		if (!list.isEmpty()) {
			Iterator<LiveChat> itr = list.iterator();
			while (itr.hasNext()) {
				LiveChat lc = itr.next();
				int queue = lc.getQueue();
				if (queue > 0) {
					queue = queue - 1;
				}
				i = liveChatRepo.updateQueue(queue, lc.getLiveChatId());

			}
		}
		return i;
	}

	private int updateQueueZero(String department, String status, int queue) {
		int i = 0;
		List<LiveChat> list = getlivechatAsPerdepartment(department);
		if (!list.isEmpty()) {
			Iterator<LiveChat> itr = list.iterator();
			while (itr.hasNext()) {
				LiveChat lc = itr.next();
				queue = lc.getQueue();

				i = liveChatRepo.updateQueue(queue, lc.getLiveChatId());

			}
		}
		return i;
	}

	private String findDepartment(String department) {
		if ((StringUtils.startsWith(department, "C"))) {
			department = "C";
		} else if ((StringUtils.startsWith(department, "S"))) {
			department = "S";
		} else if ((StringUtils.startsWith(department, "T"))) {

			department = "T";
		}
		return department;
	}

	private LiveChat convertLCModel(com.ccsbi.co.usermanagement.repository.entity.LiveChat save) {

		return dozerMapper.map(save, LiveChat.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.LiveChat convertEnt(LiveChat liveChat) {

		return dozerMapper.map(liveChat, com.ccsbi.co.usermanagement.repository.entity.LiveChat.class);
	}

}
