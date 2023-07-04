package com.michaeld.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.studentroster.models.Dorm;
import com.michaeld.studentroster.repositories.DormRepo;

@Service
public class DormService {

	@Autowired
	DormRepo dormRepo;
	
	public Dorm create(Dorm d) {
		return dormRepo.save(d);
	}
	
	public Dorm getById(Long id) {
		return dormRepo.findById(id).orElse(null);
	}
	
	public List<Dorm> getAll() {
		return dormRepo.findAll();
	}
	
	public Dorm update(Dorm d) {
		return dormRepo.save(d);
	}
	
	public void delete(Long id) {
		dormRepo.deleteById(id);
	}
}
