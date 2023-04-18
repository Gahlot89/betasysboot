package com.learningsec.pro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LerApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(LerApplication.class, args);
	}

}
