package com.michaeld.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaeld.studentroster.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
	List<Student> findAll();
}
