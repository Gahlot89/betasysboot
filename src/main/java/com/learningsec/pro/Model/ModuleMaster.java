package com.learningsec.pro.Model;

import java.sql.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table
public class ModuleMaster {

	@Id
	@GeneratedValue
	private int ModuleID;
	
	@Column
	private int ProjectID;
	
	@Column
	int CreatedBy;
	
	@Column
	String ModuleName;
	
	@Column
	String Description;
	
	
	@Column
	private Date BeginDate;
	

	@Column
	private Date EndDate;

	@OneToMany(targetEntity = ModuleDocMaster.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "dmodule_id",referencedColumnName = "ModuleID")
	List<ModuleDocMaster> moduleDocList;
	
	
	@Transient
	String status;
	
	@Transient
	String message;
	

	public ModuleMaster() {
		super();
	}

	public ModuleMaster(int moduleID, int projectID, int createdBy, String moduleName, String description,
			Date beginDate, Date endDate, List<ModuleDocMaster> moduleDocList) {
		super();
		ModuleID = moduleID;
		ProjectID = projectID;
		CreatedBy = createdBy;
		ModuleName = moduleName;
		Description = description;
		BeginDate = beginDate;
		EndDate = endDate;
		this.moduleDocList = moduleDocList;
	}

	public int getModuleID() {
		return ModuleID;
	}

	public void setModuleID(int moduleID) {
		ModuleID = moduleID;
	}

	public int getProjectID() {
		return ProjectID;
	}

	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}

	public int getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(int createdBy) {
		CreatedBy = createdBy;
	}

	public String getModuleName() {
		return ModuleName;
	}

	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getBeginDate() {
		return BeginDate;
	}

	public void setBeginDate(Date beginDate) {
		BeginDate = beginDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public List<ModuleDocMaster> getModuleDocList() {
		return moduleDocList;
	}

	public void setModuleDocList(List<ModuleDocMaster> moduleDocList) {
		this.moduleDocList = moduleDocList;
	}
	
}
