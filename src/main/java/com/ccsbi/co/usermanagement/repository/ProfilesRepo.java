package com.ccsbi.co.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ccsbi.co.usermanagement.repository.entity.Profiles;

public interface ProfilesRepo extends JpaRepository<Profiles, Long> {
	
	@Query("Select p from profiles p where p.pClass<>:superUser")
	List<Profiles> findProfiles(@Param("superUser") String superUser);

}
