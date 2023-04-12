package com.learningsec.pro.Model;



public class EmailAndPasswordModel {

	String email;
	String password;
	String otp;
	
	public EmailAndPasswordModel(String email, String password, String otp) {
		super();
		this.email = email;
		this.password = password;
		this.otp = otp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}
	
}
