package com.ccsbi.co.common.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.common.api.repository.entity.Countries;

@Repository
public interface CountryRepo extends JpaRepository<Countries, Long> {
	
	
	@Query("SELECT c.countryName FROM countries c WHERE c.countryCode=:countryCode")
	String getCountryName(@Param("countryCode") String countryCode);

}
