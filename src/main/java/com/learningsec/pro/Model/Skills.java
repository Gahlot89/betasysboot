package com.learningsec.pro.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SKILLS")
public class Skills {
	
	@Id
	int id;

	@Column(name="SKILL")
	String skill;
}
