package com.michaeld.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michaeld.studentroster.models.Dorm;
import com.michaeld.studentroster.models.Student;
import com.michaeld.studentroster.services.DormService;
import com.michaeld.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dorms")
public class DormController {

	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("allDorms", dormService.getAll());
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "dormNew.jsp";
	}
	
	@PostMapping("/new")
	public String newDormSubmit(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "dormNew.jsp";
		}
		dormService.create(dorm);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}")
	public String viewDorm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dorm", dormService.getById(id));
		model.addAttribute("allStudents", studentService.getAll());
		return "dormView.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDorm(@PathVariable("id") Long id) {
		dormService.delete(id);
		return "redirect:/";
	}
	
	@PostMapping("/add/student/{dormId}")
	public String addStudent(@PathVariable("dormId") Long dormId, @RequestParam(value="studentId") Long studentId) {
		Student tempStudent = studentService.getById(studentId);
		tempStudent.setDorm(dormService.getById(dormId));
		studentService.update(tempStudent);
		return "redirect:/dorms/view/" + dormId;
	}
	
	@GetMapping("/remove/student/{studentId}")
	public String removeStudent(@PathVariable("studentId") Long studentId) {
		Student tempStudent = studentService.getById(studentId);
		Long dormId = tempStudent.getDorm().getId();
		tempStudent.setDorm(null);
		studentService.update(tempStudent);
		return "redirect:/dorms/view/" + dormId;
	}
}
