package com.learningsec.pro.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Project{
	
	@Id
	@GeneratedValue
	int id;
	
	@Column
	String projectName;
	
	@Column
	String projectDescription;
	
	@Lob
	@Column(length = 1000)
	byte[] projectLogo;
	
	@Column
	int managerID;
	
	@Transient
	String managerName;
	
	@Transient
	String managerEmail;
	
	@Transient
	byte[] managerProfile;

	@OneToMany(targetEntity = TeamMember.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id",referencedColumnName = "id")
	List<TeamMember> teamMember;
	
	@Transient
	int TotalTask;
	
	@Transient
	int pendingTask;
	
	public Project() {

	}

	

	public Project(int id, String projectName, String projectDescription, byte[] projectLogo, int managerID,
			String managerName, String managerEmail, byte[] managerProfile, List<TeamMember> teamMember, int totalTask,
			int pendingTask) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectLogo = projectLogo;
		this.managerID = managerID;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerProfile = managerProfile;
		this.teamMember = teamMember;
		TotalTask = totalTask;
		this.pendingTask = pendingTask;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getProjectDescription() {
		return projectDescription;
	}



	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}



	public byte[] getProjectLogo() {
		return projectLogo;
	}



	public void setProjectLogo(byte[] projectLogo) {
		this.projectLogo = projectLogo;
	}



	public int getManagerID() {
		return managerID;
	}



	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}



	public String getManagerName() {
		return managerName;
	}



	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}



	public String getManagerEmail() {
		return managerEmail;
	}



	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}



	public byte[] getManagerProfile() {
		return managerProfile;
	}



	public void setManagerProfile(byte[] managerProfile) {
		this.managerProfile = managerProfile;
	}



	public List<TeamMember> getTeamMember() {
		return teamMember;
	}



	public void setTeamMember(List<TeamMember> teamMember) {
		this.teamMember = teamMember;
	}



	public int getTotalTask() {
		return TotalTask;
	}



	public void setTotalTask(int totalTask) {
		TotalTask = totalTask;
	}



	public int getPendingTask() {
		return pendingTask;
	}



	public void setPendingTask(int pendingTask) {
		this.pendingTask = pendingTask;
	}
	
	
  
}
