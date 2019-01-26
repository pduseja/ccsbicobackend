package com.ccsbi.co.usermanagement.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ccsbi.co.usermanagement.repository.UsersPhotoRepo;
import com.ccsbi.co.usermanagement.service.model.UsersPhoto;

@Transactional
@Service
public class UsersPhotoServiceImpl implements IUsersPhotoService {

	@Autowired
	private Mapper dozerMapper;

	@Autowired
	private UsersPhotoRepo usersPhotoRepo;

	// Linux: tmp directory in tomcat server
	// Windows: Tmp dir in tomcat server
	private static String UPLOAD_DIR = System.getProperty("java.io.tmpdir") + "/ccsbi/";

	@Override
	public UsersPhoto save(UsersPhoto usersPhoto, MultipartFile photo) throws Exception {
		// Make sure directory exists!
		File uploadDir = new File(UPLOAD_DIR);
		uploadDir.mkdirs();

		// Normalize file name
		String fileName = StringUtils.cleanPath(photo.getOriginalFilename());

		byte[] bytes = photo.getBytes();
		Path path = Paths.get(UPLOAD_DIR+fileName);
		Files.write(path, bytes);

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
			}

		} catch (IOException ex) {
			throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
		}

		usersPhoto.setPhoto(UPLOAD_DIR+fileName);
		
		return convertUsersPhoto(usersPhotoRepo.save(convertUsersP(usersPhoto)));
	}

	@Override
	public int update(UsersPhoto usersPhoto, MultipartFile userPhoto) throws Exception {
		// Make sure directory exists!
		int update = 0;
		File uploadDir = new File(UPLOAD_DIR);
		uploadDir.mkdirs();

		// Normalize file name
		String fileName = StringUtils.cleanPath(userPhoto.getOriginalFilename());

		byte[] bytes = userPhoto.getBytes();
		Path path = Paths.get(UPLOAD_DIR+fileName);
		Files.write(path, bytes);

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
			}

		} catch (IOException ex) {
			throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
		}

 		String photo = UPLOAD_DIR+fileName;
		
		return usersPhotoRepo.update(usersPhoto.getPhotoId(),bytes,photo);
		 
	}
	
	private UsersPhoto convertUsersPhoto(com.ccsbi.co.usermanagement.repository.entity.UsersPhoto usersPhoto) {

		return dozerMapper.map(usersPhoto, UsersPhoto.class);
	}

	private com.ccsbi.co.usermanagement.repository.entity.UsersPhoto convertUsersP(UsersPhoto usersPhoto) {

		return dozerMapper.map(usersPhoto, com.ccsbi.co.usermanagement.repository.entity.UsersPhoto.class);
	}

	

}
