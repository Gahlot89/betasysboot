package com.learningsec.pro.Model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
public class ModuleDocMaster {
	
	@Id
	int id;
	
	@Column
	String fileName;
	
	@Column
	String Date;
	
	@Lob
	@Column
	byte[] docFile;
	
	@Column
	int module_ID;
	
	

	public ModuleDocMaster() {
		super();
	}

	public ModuleDocMaster(int id, String fileName, String date, byte[] docFile, int module_ID) {
		super();
		this.id = id;
		this.fileName = fileName;
		Date = date;
		this.docFile = docFile;
		this.module_ID = module_ID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public byte[] getDocFile() {
		return docFile;
	}

	public void setDocFile(byte[] docFile) {
		this.docFile = docFile;
	}

	public int getModule_ID() {
		return module_ID;
	}

	public void setModule_ID(int module_ID) {
		this.module_ID = module_ID;
	}
}
