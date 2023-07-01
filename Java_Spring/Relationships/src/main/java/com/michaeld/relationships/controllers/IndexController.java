package com.michaeld.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michaeld.relationships.services.PersonService;

@Controller
public class IndexController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("allPersons", personService.getAll());
		return "index.jsp";
	}
	
}
