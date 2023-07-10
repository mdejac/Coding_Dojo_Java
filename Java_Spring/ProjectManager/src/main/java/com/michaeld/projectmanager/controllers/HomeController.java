package com.michaeld.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michaeld.projectmanager.models.User;
import com.michaeld.projectmanager.services.ProjectService;
import com.michaeld.projectmanager.services.UserService;
import com.michaeld.projectmanager.validators.LoginUser;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "loginAndReg.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.getById((Long) session.getAttribute("userId"));
		model.addAttribute("allProjects", projectService.getAllWithoutMember(user));
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
}
