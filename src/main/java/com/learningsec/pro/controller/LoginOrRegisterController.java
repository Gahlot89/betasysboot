package com.learningsec.pro.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learningsec.pro.Model.AuthModel;
import com.learningsec.pro.Model.CommonResponse;
import com.learningsec.pro.Utility.EmailUtility;
import com.learningsec.pro.services.AuthService;

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
		
		boolean isVarified = authService.verifyOTP();
		
		return null;
	}
	
	
	public static String generateOtp(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
	
	
	
	
	@RequestMapping(value = "/Register",method = RequestMethod.GET)
	public String Register() throws UnsupportedEncodingException, MessagingException {
	
		String content = "<h1>Hi</h1>";
		content += "<p>Verifiy Your Account by Clicking <a></a>";
		
		
		
		return "Register Success";
	}
}
