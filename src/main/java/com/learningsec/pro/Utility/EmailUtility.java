package com.learningsec.pro.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtility {
	
	
	public static String EMAIL = "gahlotnaresh4u@gmail.com";
	
	
	@Autowired
	public JavaMailSender mailSender;
	
	public boolean sendMessage(String toEmail,String subject,String emailMessage) {		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);			
			helper.setFrom(EMAIL);
			helper.setTo(toEmail);
			helper.setText(emailMessage);
			helper.setSubject(subject);
			mailSender.send(message);			
			return true;
		}catch (Exception e) {
			return false;	
		}

	}

}
