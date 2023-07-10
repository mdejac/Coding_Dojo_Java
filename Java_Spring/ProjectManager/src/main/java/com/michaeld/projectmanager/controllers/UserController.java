package com.michaeld.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.projectmanager.models.User;
import com.michaeld.projectmanager.services.UserService;
import com.michaeld.projectmanager.validators.LoginUser;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
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
		return "redirect:/dashboard";
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
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
