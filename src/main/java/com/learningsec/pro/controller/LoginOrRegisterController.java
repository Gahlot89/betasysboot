package com.learningsec.pro.controller;

import java.io.UnsupportedEncodingException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class LoginOrRegisterController {

	
	@Autowired
	public JavaMailSender mailSender;
	
	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	public Principal user(Principal principal){
		return principal;
	}
	
	
	@RequestMapping(value = "/Register",method = RequestMethod.GET)
	public String Register() throws UnsupportedEncodingException, MessagingException {
	
		String content = "<h1>Hi</h1>";
		content += "<p>Verifiy Your Account by Clicking <a></a>";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("gahlotnaresh4u@gmail.com","Naresh Darji");
		helper.setTo("sakibkhanudaipur786@gmail.com");
		helper.setText("Verification code 8859");
		helper.setSubject("Certificate OF");
		mailSender.send(message);
		
		return "Register Success";
	}
}
