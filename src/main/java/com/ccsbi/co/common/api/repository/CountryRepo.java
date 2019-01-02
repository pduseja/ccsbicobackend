package com.ccsbi.co.common.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.common.api.repository.entity.Countries;

@Repository
public interface CountryRepo extends JpaRepository<Countries, Long> {
	
	@Query("Select c.id from countries c where c.name=:name")
	int getCountryId(@Param("name") String name);
	

}
