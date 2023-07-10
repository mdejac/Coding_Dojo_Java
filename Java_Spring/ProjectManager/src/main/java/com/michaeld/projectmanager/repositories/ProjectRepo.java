package com.michaeld.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaeld.projectmanager.models.Project;
import com.michaeld.projectmanager.models.User;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long> {
	List<Project> findAll();
	List<Project> findAllByTeamMembersNotContains(User user);

}