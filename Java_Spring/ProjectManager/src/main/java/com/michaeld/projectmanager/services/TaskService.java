package com.michaeld.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.projectmanager.models.Task;
import com.michaeld.projectmanager.repositories.ProjectRepo;
import com.michaeld.projectmanager.repositories.TaskRepo;
import com.michaeld.projectmanager.repositories.UserRepo;

@Service
public class TaskService {

	@Autowired
	TaskRepo taskRepo;
	
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public Task create(Task t) {
		return taskRepo.save(t);
	}
	
	public Task create(Task t, Long projectId, Long userId) {
		t.setProject(projectRepo.findById(projectId).orElse(null));
		t.setCreatedBy(userRepo.findById(userId).orElse(null));
		return taskRepo.save(t);
	}
}
