package com.michaeld.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.studentroster.models.Class;
import com.michaeld.studentroster.services.ClassService;
import com.michaeld.studentroster.services.DormService;
import com.michaeld.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/classes")
public class ClassController {
	
	@Autowired
	ClassService classService;
	
	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("")
	public String allClasses(Model model) {
		model.addAttribute("allClasses", classService.getAll());
		return "classViewAll.jsp";
	}
	
	
	
	@GetMapping("/new")
	public String newClass (@ModelAttribute("newClass") Class newClass) {
			return "classNew.jsp";
	}
	
	@PostMapping("/new")
	public String newClassSubmit(@Valid @ModelAttribute("newClass") Class newClass, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:classNew.jsp";
		}
		classService.create(newClass);
		return "redirect:/";
	}
	
	@GetMapping("/{classId}/view")
	public String viewClass(@PathVariable("classId") Long id, Model model) {
		model.addAttribute("oneClass", classService.getById(id));
		return "classView.jsp";
	}
	
}
