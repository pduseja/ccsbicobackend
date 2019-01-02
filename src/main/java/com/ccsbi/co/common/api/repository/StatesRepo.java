package com.ccsbi.co.common.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.common.api.repository.entity.States;

public interface StatesRepo extends JpaRepository<States, Long> {
	
	@Query("Select s.id from states s where s.countryId=:countryId and name=:name")
	int getStateId(@Param("countryId") int countryId,@Param("name") String name);

}
