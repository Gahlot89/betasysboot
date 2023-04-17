package com.learningsec.pro.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "USER_DATA")
public class User {
	
	@Id
	@GeneratedValue
	int id;
	
    @Lob
    @Column(name = "PROFILE", length = 1000)
    private byte[] profile;
	
	@Column(name = "USERNAME")
	String UserName;
	
	@Column(name="EMAIL", unique = true)
	String email;
	
	@Column(name="GENDER")
	String Gender;
	
	@Column(name="DESIGNATION")
	String Designation;
	
	@Column(name="Experience")
	String ExperienceLevel;
	
	@Column(name="SKILLS")
	String Skills;
	
	@Column(name="PASSWORD")
	String Password;
	
	
	@Column(name="ENABLE")
	boolean enable;
	
	@Transient
	String message;
	
	@Transient
	String status;
	
	
	


	
	
	public User() {

	}
	
	
	
	
	public User(int id, byte[] profile, String userName, String email, String gender, String designation,
			String experienceLevel, String skills, String password, boolean enable, String message, String status) {
		super();
		this.id = id;
		this.profile = profile;
		UserName = userName;
		this.email = email;
		Gender = gender;
		Designation = designation;
		ExperienceLevel = experienceLevel;
		Skills = skills;
		Password = password;
		this.enable = enable;
		this.message = message;
		this.status = status;
	}




	public boolean isEnable() {
		return enable;
	}




	public void setEnable(boolean enable) {
		this.enable = enable;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public int getId() {
		return id;
	}




	public byte[] getProfile() {
		return profile;
	}





	public void setProfile(byte[] profile) {
		this.profile = profile;
	}





	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getExperienceLevel() {
		return ExperienceLevel;
	}

	public void setExperienceLevel(String experienceLevel) {
		ExperienceLevel = experienceLevel;
	}

	public String getSkills() {
		return Skills;
	}

	public void setSkills(String skills) {
		Skills = skills;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
	
	
}
