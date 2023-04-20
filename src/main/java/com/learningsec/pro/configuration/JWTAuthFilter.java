package com.learningsec.pro.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.learningsec.pro.Utility.JWTUtility;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {
	
	
	@Autowired
	JWTUtility jwtUtility;
	
	@Autowired
	UserDetailServiceClass userDetailServiceClass;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException,UsernameNotFoundException {
		
		String authHeader = request.getHeader("Authentication");
		String token = null;
		String username = null;
		
		if(authHeader!=null&&authHeader.startsWith("Bearer")) {
			
			token = authHeader.substring(7);
			username = jwtUtility.extractUsername(token);
			
		}
		
		try {
			if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userDetails = userDetailServiceClass.loadUserByUsername(username);
				if(jwtUtility.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}else {
					throw new UsernameNotFoundException("User Not Found");
				}
			}
		}catch (Exception e) {
			throw new ServletException("Token has expired", e);
		}
		
		
		
		filterChain.doFilter(request, response);
	}
	
	
	

}
