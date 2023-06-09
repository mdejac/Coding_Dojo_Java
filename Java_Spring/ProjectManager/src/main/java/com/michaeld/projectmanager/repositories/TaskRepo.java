package com.michaeld.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaeld.projectmanager.models.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {
	List<Task> findAll();
}
