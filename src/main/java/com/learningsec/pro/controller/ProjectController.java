package com.learningsec.pro.controller;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningsec.pro.Model.CommonResponse;
import com.learningsec.pro.Model.Project;
import com.learningsec.pro.Model.TeamMember;
import com.learningsec.pro.Model.User;
import com.learningsec.pro.Utility.ImageUtility;
import com.learningsec.pro.services.ProjectService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

@RestController
@RequestMapping("/Project")
public class ProjectController {
	
	
	@Autowired
	CommonResponse response;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	ProjectService projectService;
	

	
	
	
	@RequestMapping(value = "/myProjects",method = RequestMethod.GET)
	public List<Project> getProject(@RequestParam("userID") int userID) {
		
		Project project = new Project();
		
		TeamMember teamMember = new TeamMember();
		List<TeamMember> list = new ArrayList<>();
		list.add(teamMember);
		
		return projectService.getAllProjects(1);
	}
	
	
	@RequestMapping(value = "/AddProject",method = RequestMethod.POST)
	public CommonResponse addProject(@RequestParam("projectLogo") MultipartFile projectLogo ,@RequestParam("data") String projectJson) {
		
		
		Project project = new Project();
		try {
			project = objectMapper.readValue(projectJson, Project.class);
			project.setProjectLogo(ImageUtility.compressImage(projectLogo.getBytes()));
			
		}catch (Exception e) {
			setResponse(e.getMessage(), "Failed", projectJson);
			return response;
		}
		
		if(projectService.saveProject(project)) {
			setResponse("Project Added Successfully","Success", null);
		}else {
			setResponse("Something went wrong","Failed", null);		}
		return response;
	}
	
	@RequestMapping(value = "/getProjects",method = RequestMethod.GET)
	public Project getProjects() {
		
		Project project = new Project();
		List<TeamMember> member = new ArrayList<>();
		TeamMember temMember = new TeamMember();
		member.add(temMember);

		return project;
	}
	
	
	
	@RequestMapping(value = "/pro",method = RequestMethod.GET)
	public List<TeamMember> getProjectsj(@RequestParam("id") int id) {
		
		return projectService.getPro(id);
	}
	
	
	
	
	
	public void setResponse(String message,String status,String data) {
		response.setMessage(message);
		response.setStatus(status);
		response.setData(data);
	}

}
