package com.michaeld.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michaeld.dojooverflow.services.QuestionService;

@Controller
public class HomeController {

	@Autowired
	QuestionService questionService;

	@GetMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("allQuestions", questionService.getAll());
		return "dashboard.jsp";
	}
}
