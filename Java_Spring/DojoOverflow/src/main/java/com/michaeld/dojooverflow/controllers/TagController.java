package com.michaeld.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.dojooverflow.services.AnswerService;
import com.michaeld.dojooverflow.services.QuestionService;
import com.michaeld.dojooverflow.services.TagService;

@Controller
@RequestMapping("/tags")
public class TagController {

	@Autowired
	QuestionService questionService;
	@Autowired
	AnswerService answerService;
	@Autowired
	TagService tagService;
}
