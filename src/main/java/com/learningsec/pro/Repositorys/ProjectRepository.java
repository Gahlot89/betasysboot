package com.learningsec.pro.Repositorys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningsec.pro.Model.Project;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
}
