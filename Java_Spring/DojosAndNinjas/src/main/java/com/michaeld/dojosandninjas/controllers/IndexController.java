package com.michaeld.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michaeld.dojosandninjas.services.DojoService;

@Controller
public class IndexController {
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allDojos", dojoService.getAll());
		return "index.jsp";
	}
}
