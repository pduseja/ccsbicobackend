package com.ccsbi.co.usermanagement.service;

import org.springframework.web.multipart.MultipartFile;

import com.ccsbi.co.usermanagement.service.model.UsersPhoto;

public interface IUsersPhotoService {
	
	UsersPhoto save(UsersPhoto usersPhoto, MultipartFile photo) throws Exception;
	
	int update(UsersPhoto usersPhoto, MultipartFile photo) throws Exception;

}
