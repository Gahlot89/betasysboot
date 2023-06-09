package com.learningsec.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learningsec.pro.Model.User;
import com.learningsec.pro.services.UserService;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "Requestor-Type")
@RestController
@RequestMapping(value = "/User")
public class UserController {
	

	@Autowired
	UserService userService;
	
	
	

	@RequestMapping(value = "/getUserProfile",method = RequestMethod.GET)
	private User getUser(@RequestParam("email") String  email) {
		User user = null;
		try {
			user = userService.getUserData(email);
		}catch (Exception e) {
			user.setMessage(e.getMessage());
			user.setStatus("Failed");
		}
		
		return user;
	}
	
}
