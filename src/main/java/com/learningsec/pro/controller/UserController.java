package com.learningsec.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learningsec.pro.Model.User;
import com.learningsec.pro.services.UserService;

@RestController
@RequestMapping(value = "/User")
public class UserController {
	

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/getUserProfile",method = RequestMethod.GET)
	private User getUser(@RequestParam("email") String  email) {
		return userService.getUserData(email);
	}
	
	

}
