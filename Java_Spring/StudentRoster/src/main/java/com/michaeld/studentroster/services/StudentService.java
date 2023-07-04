package com.michaeld.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.studentroster.models.Student;
import com.michaeld.studentroster.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	public Student create(Student s) {
		return studentRepo.save(s);
	}
	
	public List<Student> getAll() {
		return studentRepo.findAll();
	}
	
	public Student getById(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public Student update(Student s) {
		return studentRepo.save(s);
	}
	
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
}
