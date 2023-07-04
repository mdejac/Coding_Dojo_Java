package com.michaeld.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.dojosandninjas.models.Ninja;
import com.michaeld.dojosandninjas.services.DojoService;
import com.michaeld.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;

	@GetMapping("/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoService.getAll());
		return "ninjaCreate.jsp";
	}
	
	@PostMapping("/create")
	public String createNinjaSubmit(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.getAll());
			return "ninjaCreate.jsp";
		}
		ninjaService.create(ninja);
		return "redirect:/";
	}
}
