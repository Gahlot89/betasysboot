package com.learningsec.pro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningsec.pro.Model.Project;
import com.learningsec.pro.Repositorys.ProjectRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Transactional
	public boolean saveProject(Project project) {
		
		try {
			entityManager.persist(project);
			return true;
		}catch (Exception e) {
			System.out.print(e.getMessage()+"-------------------------------------------------------------");
			return false;
		}
	}
	

}
