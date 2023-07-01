package com.michaeld.relationships.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.relationships.models.Person;
import com.michaeld.relationships.services.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person ) {
		return "createPerson.jsp";
	}
	
	@PostMapping("/create")
	public String newPersonSubmit(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "createPerson.jsp";
		}
		personService.create(person);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}")
	public String viewPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", personService.getById(id));
		return "personView.jsp";
	}
}
