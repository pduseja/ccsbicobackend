package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers;


public interface LiveChatMembersRepo extends JpaRepository<LiveChatMembers, Long> {

	@Query("SELECT lcm from livechatmembers lcm where lcm.userName=:userName and lcm.department=:department and lcm.status=:status")
	LiveChatMembers getLatestQueueNumber(@Param("userName") String userName,@Param("department") String department,@Param("status") String status);
	
	@Modifying
	@Query("Update livechatmembers lcm set lcm.queue=:queue where lcm.userName=:userName and lcm.department=:department")
	int updateQueueNumber(@Param("userName") String userName,@Param("department") String department,@Param("queue") int queue);
	
	@Modifying
	@Query("Update livechatmembers lcm set lcm.status=:status where lcm.userName=:userName")
	int update(@Param("status") String status,@Param("userName") String userName);
	
	@Query("SELECT COALESCE(max(lcm.queue),0) from livechatmembers lcm where lcm.department=:department and lcm.status=:status order by lcm.department")
	int getQueueNumber(@Param("department") String department,@Param("status") String status);
	
	@Query("select lcm from livechatmembers lcm where lcm.userName=:userName and lcm.department=:department and lcm.status=:status")
	LiveChatMembers getLiveChatMember(@Param("userName") String userName,@Param("department") String department,@Param("status") String status);
	
	@Query("select lcm from livechatmembers lcm where lcm.department=:department and lcm.status=:status")
	List<LiveChatMembers> getListLiveChatMember(@Param("department") String department,@Param("status") String status);
	
	@Query("select lcm.userName from livechatmembers lcm where lcm.department=:department and lcm.status=:status and userName<>:userName")
	List<String> broadcastMessage(@Param("userName") String userName,@Param("department") String department,@Param("status") String status);
	
}
