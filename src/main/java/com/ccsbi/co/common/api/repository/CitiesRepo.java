package com.ccsbi.co.common.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.common.api.repository.entity.Cities;

public interface CitiesRepo extends JpaRepository<Cities, Long> {
	
	@Query("Select c.name from cities c where c.stateId=:stateId")
	List<String> getCitiesList(@Param("stateId") int stateId);

}
