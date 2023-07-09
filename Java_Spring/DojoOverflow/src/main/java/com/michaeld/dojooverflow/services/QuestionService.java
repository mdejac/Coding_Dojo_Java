package com.michaeld.dojooverflow.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.michaeld.dojooverflow.models.Question;
import com.michaeld.dojooverflow.models.Tag;
import com.michaeld.dojooverflow.repositories.AnswerRepo;
import com.michaeld.dojooverflow.repositories.QuestionRepo;
import com.michaeld.dojooverflow.repositories.TagRepo;

@Service
public class QuestionService {

	@Autowired
	QuestionRepo questionRepo;
	@Autowired
	AnswerRepo answerRepo;
	@Autowired
	TagRepo tagRepo;
	
	public Question create(Question q) {
		return questionRepo.save(q);
	}
	
	public Question validateFormData(Question q, BindingResult result, String tagString) {
		if (tagString.equals("")) {
			result.rejectValue("tags", "Error", "Must have at least one tag.");
		} else {
			if (Arrays.asList(tagString.split(",")).size() > 3) {
				result.rejectValue("tags", "Error", "You may only choose three tags.");
			}
			
			if (!tagString.matches("^\\s*\\w+(\\s*,\\s*\\w+)*\\s*$")) {
				result.rejectValue("tags", "Error", "All tags must be separated by commas.");
			}		
		}
		if (result.hasErrors()) {
			return null;
		}
		questionRepo.save(q);
		return q;
	}
	
	public List<Question> getAll() {
		return questionRepo.findAll();
	}
	
	public Question getById(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	public void addTagToQuestion(Long questionId, Long tagId) {
		Question question = findQuestionById(questionId);
		Tag tag = findTagById(tagId);
		
		//Without this getTags() throws a null error. Does not work that way on ProductsAndCategories.
		if (question.getTags() == null) {
			question.setTags(new ArrayList<Tag>());
		}
		
		question.getTags().add(tag);
		questionRepo.save(question);
	}
	
	private Question findQuestionById(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	private Tag findTagById(Long id) {
		return tagRepo.findById(id).orElse(null);
	}
}
