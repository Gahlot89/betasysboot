package com.learningsec.pro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.learningsec.pro.Model.Project;
import com.learningsec.pro.Model.TeamMember;
import com.learningsec.pro.Model.User;
import com.learningsec.pro.Repositorys.ProjectRepository;
import com.learningsec.pro.Repositorys.TeamMemberRepository;
import com.learningsec.pro.Repositorys.UserRepository;
import com.learningsec.pro.Utility.ImageUtility;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	@Autowired
	TeamMemberRepository teamMemberRepository;
	
	@Autowired
	EntityManager entityManager;
	
	
	@Autowired
	UserRepository userRepository;
	
//
//	
	@Transactional
	public boolean saveProject(Project project) {
		
		try {
			projectRepository.save(project);
			return true;
		}catch (Exception e) {
			System.out.print(e.getMessage()+"------------------------------------------------------------");
			return false;
		}
	}

	
	
	public List<Project> getAllProjects(int memberID) {
		
		List<Project> projeList = projectRepository.getMyProjects(memberID);

		List<TeamMember> teamMembers;
		
		for(int i = 0;i<projeList.size();i++) {
			teamMembers = new ArrayList<>();
			for(TeamMember member : projeList.get(i).getTeamMember()) {
				User user = userRepository.findByIDForPro(member.getMemberId());
				member.setMemberName(user.getUserName());
				member.setMemberEmail(user.getEmail());
				member.setMemberProfile(ImageUtility.decompressImage(user.getProfile()));
				teamMembers.add(member);
				
				if(member.getMemberRole().equals("Manager")) {
					projeList.get(i).setManagerName(user.getUserName());
					projeList.get(i).setManagerEmail(user.getEmail());
					projeList.get(i).setManagerProfile(ImageUtility.decompressImage(user.getProfile()));
				}
			}
			projeList.get(i).setTeamMember(teamMembers);
		}

		return projeList;
	}
	
	
	public List<TeamMember> getPro(int id) {
		return teamMemberRepository.findProjectTeamMembersWithUserDetails(id);
	}

}
