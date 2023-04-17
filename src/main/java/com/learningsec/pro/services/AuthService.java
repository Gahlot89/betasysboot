package com.learningsec.pro.services;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningsec.pro.Model.AuthModel;
import com.learningsec.pro.Model.CommonResponse;
import com.learningsec.pro.Model.User;
import com.learningsec.pro.Repositorys.AuthRepository;
import com.learningsec.pro.Repositorys.UserRepository;

import jakarta.persistence.PersistenceException;

@Service
public class AuthService {

	@Autowired
	AuthRepository authRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CommonResponse respones;
	
	
	public boolean saveEmailForOTPData(AuthModel authModel) {
			try {
				AuthModel ExistUser = authRepository.findByEmail(authModel.getEmail());
				if(ExistUser==null) {
					authRepository.save(authModel);
					return true;
				}else {
					ExistUser.setOtp(authModel.getOtp());
					ExistUser.setPassword(authModel.getPassword());
					authRepository.save(ExistUser);
					return true;
				}
			}catch (Exception e) {
				return false;
			}	
	}

	public boolean verifyOTP(AuthModel authModel) {
		
		try {
			AuthModel ExistUser = authRepository.findByEmail(authModel.getEmail());
			if(ExistUser.getOtp().equals(authModel.getOtp())) {
				return true;
			}else {
				return false;
			}
			
		}catch (Exception e) {
			return false;
		}
		
	}

	
	
	
}
