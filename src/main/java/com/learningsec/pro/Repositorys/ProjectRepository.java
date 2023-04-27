package com.learningsec.pro.Repositorys;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learningsec.pro.Model.Project;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
	
	@Query(value="select * from project where id in (select project_id from team_member where member_id = :userID)",nativeQuery = true)
	List<Project> getMyProjects(@Param("userID") int id);
	
	
		
	
}
