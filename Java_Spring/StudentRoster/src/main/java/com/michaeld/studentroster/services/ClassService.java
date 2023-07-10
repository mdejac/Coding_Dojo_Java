package com.michaeld.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.studentroster.models.Class;
import com.michaeld.studentroster.models.Student;
import com.michaeld.studentroster.repositories.ClassRepo;
import com.michaeld.studentroster.repositories.StudentRepo;

@Service
public class ClassService {

	@Autowired
	ClassRepo classRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	public Class create(Class c) {
		return classRepo.save(c);
	}
	
	public List<Class> getAll() {
		return classRepo.findAll();
	}
	
	public Class getById(Long Id) {
		return classRepo.findById(Id).orElse(null);
	}
	
	public List<Class> getAllWithoutStudent(Student student) {
		return classRepo.findAllByStudentsNotContaining(student);
	}
	
	public Class update(Class c) {
		return classRepo.save(c);
	}
		
	public void delete(Long id) {
		classRepo.deleteById(id);
	}
}
