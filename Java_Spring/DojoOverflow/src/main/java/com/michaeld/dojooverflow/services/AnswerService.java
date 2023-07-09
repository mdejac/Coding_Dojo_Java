package com.michaeld.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.dojooverflow.models.Answer;
import com.michaeld.dojooverflow.repositories.AnswerRepo;
import com.michaeld.dojooverflow.repositories.QuestionRepo;
import com.michaeld.dojooverflow.repositories.TagRepo;

@Service
public class AnswerService {

	@Autowired
	QuestionRepo questionRepo;
	@Autowired
	AnswerRepo answerRepo;
	@Autowired
	TagRepo tagRepo;
	
	public Answer create(Answer a) {
		return answerRepo.save(a);
	}
	
	public Answer getById(Long id) {
		return answerRepo.findById(id).orElse(null);
	}
	
	public List<Answer> getAll() {
		return answerRepo.findAll();
	}
	
	public Answer update(Answer a) {
		return answerRepo.save(a);
	}

}
