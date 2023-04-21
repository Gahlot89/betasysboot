package com.learningsec.pro.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {
	
	
	@Autowired
	JWTAuthFilter jwtAuthFilter;
	
	
	@Autowired
	JWTAuthenticationEntryPoint entryPoint;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailServiceClass();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/Register").permitAll()
		.requestMatchers("/UserLogin","/Project/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authenticationProvider(authenticationProvider())
		.exceptionHandling().authenticationEntryPoint(entryPoint).and()
		.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	  CorsConfiguration configuration = new CorsConfiguration();
	  configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
	  configuration.setAllowedMethods(Arrays.asList("GET","POST","PATCH", "PUT", "DELETE", "OPTIONS", "HEAD"));
	  configuration.setAllowCredentials(true);
	  configuration.setAllowedHeaders(Arrays.asList("Authorization", "Requestor-Type"));
	  configuration.setExposedHeaders(Arrays.asList("X-Get-Header"));
	  configuration.setMaxAge(3600L);
	  UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	  source.registerCorsConfiguration("/**", configuration);
	  return source;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
	
	

	

}