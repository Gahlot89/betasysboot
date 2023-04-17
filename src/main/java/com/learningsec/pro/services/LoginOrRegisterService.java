package com.learningsec.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learningsec.pro.Model.CommonResponse;
import com.learningsec.pro.Model.User;
import com.learningsec.pro.Repositorys.UserRepository;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;


@Service
public class LoginOrRegisterService {
	

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CommonResponse response;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public CommonResponse registerUser(User user) {
			
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		
		
		System.out.print(user.getPassword());
		
		User isUserExist = userRepository.findByEmail(user.getEmail());
		if(isUserExist!=null) {
			response.setMessage("This user is already Register with Betasys");
			response.setStatus("Failed");
			response.setData("");
		}else {
			if(userRepository.save(user)!=null) {
				response.setMessage("User Registered Successfully");
				response.setStatus("Success");
				response.setData("");
			}else {
				response.setMessage("Registered Failed");
				response.setStatus("Failed");
				response.setData("");
			}
		}
		
		return response;
	}
	


}
