package com.michaeld.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaeld.dojooverflow.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{
	List<Question> findAll();
}
