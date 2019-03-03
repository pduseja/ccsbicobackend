package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
