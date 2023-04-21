package com.learningsec.pro.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Project {
	
	@Id
	@GeneratedValue
	int ProjectID;
	
	@Column
	String projectName;
	
	@Column
	String projectDescription;
	
	@Column
	String projectManager;
	
	@Transient
	String managerName;
	
	@Transient
	String managerEmail;
	
	@Transient
	String managerProfile;

	
	@OneToMany(mappedBy = "project")
	List<TeamMember> members;
	
	@Transient
	int TotalTask;
	
	@Transient
	int pendingTask;
	
	public Project() {
		super();
	}

	public Project(int projectID, String projectName, String projectDescription, String projectManager,
			String managerName, String managerEmail, String managerProfile, List<TeamMember> members, int totalTask,
			int pendingTask) {
		super();
		ProjectID = projectID;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectManager = projectManager;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.managerProfile = managerProfile;
		this.members = members;
		TotalTask = totalTask;
		this.pendingTask = pendingTask;
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

	public String getManagerProfile() {
		return managerProfile;
	}

	public void setManagerProfile(String managerProfile) {
		this.managerProfile = managerProfile;
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

	public int getProjectID() {
		return ProjectID;
	}

	public void setProjectID(int projectID) {
		ProjectID = projectID;
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

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public List<TeamMember> getMembers() {
		return members;
	}

	public void setMembers(List<TeamMember> members) {
		this.members = members;
	}


}
