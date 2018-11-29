package com.ccsbi.co.common.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccsbi.co.common.api.repository.entity.Countries;

public interface CountryRepo extends JpaRepository<Countries, Long> {

}
