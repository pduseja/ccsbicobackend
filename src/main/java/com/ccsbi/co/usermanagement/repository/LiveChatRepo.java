package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.LiveChat;

public interface LiveChatRepo extends JpaRepository<LiveChat, Long> {
	
	@Query("SELECT lc from livechat lc where lc.department like concat(:department,'%') and lc.status=:status")
	List<LiveChat> getlivechatAsPerdepartment(@Param("department") String department,@Param("status") String status);
	
	@Query("SELECT max(lc.queue) from livechat lc where lc.department like concat(:department,'%') and lc.status=:status order by lc.department")
	int getChatQueueNumber(@Param("department") String department,@Param("status") String status);
	
	@Query("SELECT lc from livechat lc where lc.department like concat(:department,'%') and lc.status=:status order by lc.department")
	List<LiveChat> getLiveChatQueueNumber(@Param("department") String department,@Param("status") String status);
	
	@Modifying
	@Query("update livechat lc set lc.queue=:queue where lc.liveChatId=:liveChatId")
	int  updateQueue(@Param("queue")int queue,@Param("liveChatId") int liveChatId);
	
	@Query("select lc from livechat lc where lc.department like concat(:department,'%') and lc.status=:status and lc.userName=:userName")
	LiveChat getLatestQueueForUser(@Param("department") String department,@Param("status") String status,@Param("userName") String userName);
	
	@Query("select lc from livechat lc where lc.userName=:userName and lc.status=:status and lc.department=:department")
	LiveChat findUser(@Param("userName") String userName,@Param("status") String status, @Param("department") String department);
	
	@Modifying
	@Query("update livechat lc set lc.status=:status where lc.liveChatId=:liveChatId")
	int  updateLiveChat(@Param("liveChatId") int liveChatId,@Param("status")String status);
}
