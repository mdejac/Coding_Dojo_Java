package com.michaeld.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.loginandregistration.models.User;
import com.michaeld.loginandregistration.services.UserService;
import com.michaeld.loginandregistration.validators.LoginUser;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "loginAndReg.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result,
							Model model, HttpSession session) {
		
		User user = userService.register(newUser, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			model.addAttribute("renderRegisterForm", true);
			return "loginAndReg.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/users/home";
	}
	
	@PostMapping("/login")
	public String loginSubmit(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result,
							Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "loginAndReg.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		return "redirect:/users/home";
	}

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/users/login";
		}
		model.addAttribute("user", userService.getById((Long) session.getAttribute("userId")));
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/users/login";
	}
	
}
