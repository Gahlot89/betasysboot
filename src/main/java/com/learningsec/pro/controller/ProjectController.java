package com.learningsec.pro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learningsec.pro.Model.CommonResponse;
import com.learningsec.pro.Model.Project;
import com.learningsec.pro.Model.TeamMember;
import com.learningsec.pro.services.ProjectService;

@RestController
@RequestMapping("/Project")
public class ProjectController {
	
	
	@Autowired
	CommonResponse response;
	
	@Autowired
	ProjectService projectService;
	
	
	
	@RequestMapping(value = "/myProjects",method = RequestMethod.GET)
	public Project getProject() {
		return null;
	}
	
	
	@RequestMapping(value = "/AddProject",method = RequestMethod.POST)
	public CommonResponse addProject(@RequestBody Project project) {
		
		if(projectService.saveProject(project)) {
			setResponse("Project Added Successfully","Success", null);
		}else {
			setResponse("Something went wrong","Failed", null);
		}
		return response;
	}
	
	
	public void setResponse(String message,String status,String data) {
		response.setMessage(message);
		response.setStatus(status);
		response.setData(data);
	}

}
