package com.michaeld.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.studentroster.models.Student;
import com.michaeld.studentroster.services.DormService;
import com.michaeld.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@Autowired
	DormService dormService;
	
	@GetMapping("/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("allDorms", dormService.getAll());
		return "studentNew.jsp";
	}
	
	@PostMapping("/new")
	public String newStudentSubmit(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allDorms", dormService.getAll());
			return "studentNew.jsp";
		}
		studentService.create(student);
		return "redirect:/";
	}
}
