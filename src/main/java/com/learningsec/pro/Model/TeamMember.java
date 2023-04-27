package com.learningsec.pro.Model;

import java.io.Serializable;

import org.hibernate.annotations.ManyToAny;
import org.springframework.boot.context.properties.bind.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class TeamMember{
	
	@Id
	@GeneratedValue
	int id;
	
	@Column
	int memberId;
	
	@Transient
	String memberName;
	
	@Lob
	@Transient
	@Column(length = 1000)
	byte[] memberProfile;
	
	@Transient
	String memberEmail;
	
	@Column
	String memberRole;
	
	

	public TeamMember() {
		super();
	}

	


	public TeamMember(int id, int memberId, String memberName, byte[] memberProfile, String memberEmail,
			String memberRole) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberProfile = memberProfile;
		this.memberEmail = memberEmail;
		this.memberRole = memberRole;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}



	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public byte[] getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(byte[] memberProfile) {
		this.memberProfile = memberProfile;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}
		
}
