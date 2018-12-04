package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.SystemParams;

@Repository
public interface SystemParamsRepo extends JpaRepository<SystemParams, Long> {

}
