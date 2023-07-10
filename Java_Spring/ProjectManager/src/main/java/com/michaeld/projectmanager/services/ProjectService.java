package com.michaeld.projectmanager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.projectmanager.models.Project;
import com.michaeld.projectmanager.models.User;
import com.michaeld.projectmanager.repositories.ProjectRepo;
import com.michaeld.projectmanager.repositories.UserRepo;

@Service
public class ProjectService {

	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	UserRepo userRepo;
	
	
	public Project create(Project p) {
		return projectRepo.save(p); 
	}
	
	public Project create(Project p, Long userId) {
		p.setCreator(userRepo.findById(userId).orElse(null));
		p.setTeamMembers(new ArrayList<User>());
		p.getTeamMembers().add(userRepo.findById(userId).orElse(null));
		return projectRepo.save(p); 
	}
	
	public Project getById(Long id) {
		return projectRepo.findById(id).orElse(null);
	}
	
	public List<Project> getAll() {
		return projectRepo.findAll();
	}
	
	public List<Project> getAllWithoutMember(User user) {
		return projectRepo.findAllByTeamMembersNotContains(user);
	}
	
	public Project update(Project p) {
		Project oldProject = projectRepo.findById(p.getId()).orElse(null);
		p.setCreator(oldProject.getCreator());
		p.setTeamMembers(oldProject.getTeamMembers());
		return projectRepo.save(p);
	}
	
	public void addUserIdtoProjectTeam(Long userId, Long projectId) {
		User user = userRepo.findById(userId).orElse(null);
		Project project = projectRepo.findById(projectId).orElse(null);
		if (project.getTeamMembers() == null) {
			project.setTeamMembers(new ArrayList<User>());
		}
		project.getTeamMembers().add(user);
		projectRepo.save(project);
	}
	
	public void removeUserIdFromProjectTeam(Long userId, Long projectId) {
		User user = userRepo.findById(userId).orElse(null);
		Project project = projectRepo.findById(projectId).orElse(null);
		project.getTeamMembers().remove(user);
		projectRepo.save(project);
	}
	
}
