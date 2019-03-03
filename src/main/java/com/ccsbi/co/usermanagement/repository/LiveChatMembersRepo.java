package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.LiveChatMembers;


public interface LiveChatMembersRepo extends JpaRepository<LiveChatMembers, Long> {

	@Query("SELECT lcm.queue from livechatmembers lcm where lcm.userName=:userName and lcm.department=:department and lcm.status=:status")
	int getLatestQueueNumber(@Param("userName") String userName,@Param("department") String department,@Param("status") String status);
	
	@Modifying
	@Query("Update livechatmembers lcm set lcm.queue=:queue where lcm.userName=:userName and lcm.department=:department")
	int updateQueueNumber(@Param("userName") String userName,@Param("department") String department,@Param("queue") int queue);
	
	@Modifying
	@Query("Update livechatmembers lcm set lcm.status=:status where lcm.userName=:userName")
	int update(@Param("status") String status,@Param("userName") String userName);
}
