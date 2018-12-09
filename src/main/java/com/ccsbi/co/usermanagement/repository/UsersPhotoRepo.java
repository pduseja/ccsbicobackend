package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.UsersPhoto;

@Repository
public interface UsersPhotoRepo extends JpaRepository<UsersPhoto, Long> {
	
	@SuppressWarnings("unchecked")
	UsersPhoto save(UsersPhoto usersPhoto);

}
