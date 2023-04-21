package com.learningsec.pro.Model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class TeamMember {
	
	@Id
	@GeneratedValue
	int id;
	
	@Column
	int memberid;
	
	@ManyToOne
	Project project;
	
	@Transient
	String memebrName;
	
	@Transient
	String memberProfile;
	
	@Transient
	String memberEmail;
	
	@Column
	String role;
	
	

	public TeamMember() {
		super();
	}



	public TeamMember(int memberid, Project project, String memebrName, String memberProfile, String memberEmail,
			String role) {
		super();
		this.memberid = memberid;
		this.project = project;
		this.memebrName = memebrName;
		this.memberProfile = memberProfile;
		this.memberEmail = memberEmail;
		this.role = role;
	}



	public int getMemberid() {
		return memberid;
	}



	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}



	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}



	public String getMemebrName() {
		return memebrName;
	}



	public void setMemebrName(String memebrName) {
		this.memebrName = memebrName;
	}



	public String getMemberProfile() {
		return memberProfile;
	}



	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}



	public String getMemberEmail() {
		return memberEmail;
	}



	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
}
