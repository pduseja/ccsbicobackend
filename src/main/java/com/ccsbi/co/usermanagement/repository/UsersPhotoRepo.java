package com.ccsbi.co.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ccsbi.co.usermanagement.repository.entity.UsersPhoto;

@Repository
public interface UsersPhotoRepo extends JpaRepository<UsersPhoto, Long> {
	
	@SuppressWarnings("unchecked")
	UsersPhoto save(UsersPhoto usersPhoto);
	
	@Modifying
	@Query("delete from usersphoto up where up.photoId=:photoId")
	int delete(@Param("photoId") int photoId);

}
