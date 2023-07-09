package com.michaeld.dojooverflow.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michaeld.dojooverflow.models.Answer;
import com.michaeld.dojooverflow.models.Question;
import com.michaeld.dojooverflow.models.Tag;
import com.michaeld.dojooverflow.services.AnswerService;
import com.michaeld.dojooverflow.services.QuestionService;
import com.michaeld.dojooverflow.services.TagService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;
	@Autowired
	TagService tagService;
	
	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "questionNew.jsp";
	}
	
	@PostMapping("/new")
	public String newQuestionSubmit(
			@Valid @ModelAttribute("question") Question question, BindingResult result,
			@RequestParam("tagString") String tagString, Model model) {

		
		Question newQuestion = questionService.validateFormData(question, result, tagString);
		if (result.hasErrors()) {
			model.addAttribute("tagString", tagString);
			return "questionNew.jsp";
		}
		
		List<String> tagList = Arrays.asList(tagString.split(","));
		for (String tag : tagList) {
			tag = tag.trim();
			Tag tempTag = tagService.getByText(tag);
			if (tempTag == null) {
				Tag newTag = new Tag();
				newTag.setSubject(tag);
				tagService.update(newTag);
				questionService.addTagToQuestion(newQuestion.getId(), newTag.getId());
			} else {
				questionService.addTagToQuestion(newQuestion.getId(), tempTag.getId());
			}
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/{questionId}/view")
	public String viewQuestion(@PathVariable("questionId") Long questionId, @ModelAttribute("answer") Answer answer, Model model) {
		model.addAttribute("question", questionService.getById(questionId));
		return "questionView.jsp";
	}
	
	@PostMapping("/{questionId}/view")
	public String answerSubmit(@PathVariable("questionId") Long questionId, @Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("question", questionService.getById(questionId));
			return "questionView.jsp";
		}
		Answer newAnswer = answerService.create(answer);
		newAnswer.setQuestion(questionService.getById(questionId));
		answerService.update(answer);		
		return "redirect:/questions/" + questionId + "/view";
	}
}
