package com.michaeld.studentroster.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.studentroster.models.Class;
import com.michaeld.studentroster.models.Student;
import com.michaeld.studentroster.repositories.ClassRepo;
import com.michaeld.studentroster.repositories.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	ClassRepo classRepo;
	
	
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
	
	public void addStudentIdToClassId(Long studentId, Long classId) {
		Student student = studentRepo.findById(studentId).orElse(null);
		Class newClass = classRepo.findById(classId).orElse(null);
		if (student.getClasses() == null) {
			student.setClasses(new ArrayList<Class>());
		}
		student.getClasses().add(newClass);
		studentRepo.save(student);
	}
	
	public void delete(Long id) {
		studentRepo.deleteById(id);
	}
}
