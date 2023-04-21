package com.learningsec.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learningsec.pro.Model.User;
import com.learningsec.pro.Repositorys.UserRepository;
import com.learningsec.pro.Utility.ImageUtility;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ImageUtility imageUtility;
	

	
	public User getUserData(String email) {
		
		User user = userRepository.findByEmail(email);
		
		if(user!=null) {
			user.setProfile(imageUtility.decompressImage(user.getProfile()));
			return user;
		}else {
			user.setMessage("User Not Exist");
			user.setMessage("OK");
			return user;
		}
	}
	
}
