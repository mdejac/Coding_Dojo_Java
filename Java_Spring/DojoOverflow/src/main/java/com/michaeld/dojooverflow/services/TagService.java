package com.michaeld.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.dojooverflow.models.Tag;
import com.michaeld.dojooverflow.repositories.AnswerRepo;
import com.michaeld.dojooverflow.repositories.QuestionRepo;
import com.michaeld.dojooverflow.repositories.TagRepo;

@Service
public class TagService {

	@Autowired
	QuestionRepo questionRepo;
	@Autowired
	AnswerRepo answerRepo;
	@Autowired
	TagRepo tagRepo;
	
	public Tag create(Tag t) {
		return tagRepo.save(t);
	}
	
	public Tag getById(Long id) {
		return tagRepo.findById(id).orElse(null);
	}
	
	public List<Tag> getAll() {
		return tagRepo.findAll();
	}
	
	public Tag getByText(String text) {
		return tagRepo.findBySubject(text).orElse(null);
	}
	
	public Tag update(Tag t) {
		return tagRepo.save(t);
	}
}
