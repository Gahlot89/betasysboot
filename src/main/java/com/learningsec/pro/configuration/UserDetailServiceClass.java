package com.learningsec.pro.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learningsec.pro.Model.User;
import com.learningsec.pro.Repositorys.UserRepository;


@Service
public class UserDetailServiceClass implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		System.out.print("-------------------------------------------------------------------------------------------------------");
		if(user==null) {
			throw new UsernameNotFoundException("NO USER");
		}
		
		return new UserDetailClass(user);
	}

}
