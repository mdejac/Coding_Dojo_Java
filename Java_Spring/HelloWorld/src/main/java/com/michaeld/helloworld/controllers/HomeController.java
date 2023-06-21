package com.michaeld.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/index")
public class HomeController {
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("fruit1", "pineapple");
		model.addAttribute("fruit2", "watermelon");
		return "index.jsp";
	}
	
}

