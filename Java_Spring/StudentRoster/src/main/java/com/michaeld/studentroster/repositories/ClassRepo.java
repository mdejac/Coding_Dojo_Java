package com.michaeld.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaeld.studentroster.models.Class;
import com.michaeld.studentroster.models.Student;

@Repository
public interface ClassRepo extends CrudRepository<Class, Long> {
	List<Class> findAll();
	List<Class> findAllByStudentsNotContaining(Student student);
}
