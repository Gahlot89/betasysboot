package com.learningsec.pro.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningsec.pro.Model.AuthModel;
import com.learningsec.pro.Model.CommonResponse;
import com.learningsec.pro.Model.User;
import com.learningsec.pro.Utility.EmailUtility;
import com.learningsec.pro.Utility.ImageUtility;
import com.learningsec.pro.services.AuthService;
import com.learningsec.pro.services.LoginOrRegisterService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class LoginOrRegisterController {
	
	@Autowired
	CommonResponse response;

	
	@Autowired
	public JavaMailSender mailSender;
	
	@Autowired
	private EmailUtility emailUtility;
	
	@Autowired
	AuthService authService;
	
		
	@Autowired
	LoginOrRegisterService loginRegisterService;
	
	
	@Autowired
	ObjectMapper objectMapper;
	
	@RequestMapping(value="/EmailVerification",method = RequestMethod.POST)
	public CommonResponse emailVerification(@RequestBody AuthModel authModel) {

	
		authModel.setOtp(generateOtp(6));
		authModel.setEnable(false);
		
		response.setMessage("Something went wrong try Again Later");
		response.setStatus("Fail");
		response.setData("");
		
		boolean isStored = authService.saveEmailForOTPData(authModel);
		
		if(isStored) {
			
			String toEmail = authModel.getEmail();
			String subject = "Betasys Account Verification\n";
			String message = "B-"+authModel.getOtp();
			
			
			boolean status = emailUtility.sendMessage(toEmail, subject, message);
			
			if(status) {
				response.setMessage("Verification Code is Sended to your email id - "+toEmail);
				response.setStatus("Success");
				response.setData("");
			}
		}
		
		return response;
	}
	
	
	
	
	@PostMapping("/EmailOTPVerification")
	public CommonResponse emailOTPVerification(@RequestBody AuthModel authModel){
		
		
		boolean isVerified = authService.verifyOTP(authModel);
		if(isVerified) {
			response.setStatus("Success");
			response.setMessage("Email Verified Successfully");
			response.setData("");
		}else {
			response.setStatus("Failed");
			response.setMessage("Invalid OTP");
			response.setData("");
		}
		
		return response;
	}
	
	
	public static String generateOtp(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
	
	
	@RequestMapping(value = "/Register",method = RequestMethod.POST)
	public CommonResponse Register(@RequestParam("profile") MultipartFile profile,@RequestParam("model") String jsonObject){
		
		User user = new User();
		try {
			user = objectMapper.readValue(jsonObject, User.class);
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			user.setProfile(ImageUtility.compressImage(profile.getBytes()));
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		return loginRegisterService.registerUser(user);
	
	}
}
