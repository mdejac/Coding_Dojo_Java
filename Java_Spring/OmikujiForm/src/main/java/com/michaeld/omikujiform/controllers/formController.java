package com.michaeld.omikujiform.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/omikuji")
public class formController {

	@GetMapping("")
	public String index(HttpSession session) {
		session.invalidate();
		return "form.jsp";
	}
	
	@PostMapping("/submit")
	public String submitForm(
			@RequestParam(value="number") String number,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="message") String message,
			HttpSession session){
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
		session.setAttribute("validSubmission", true);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/show")
	public String show(HttpSession session) {
		if (session.getAttribute("validSubmission") == null) {
			return "redirect:/omikuji";
		}
		return "show.jsp";
	}
	
}
