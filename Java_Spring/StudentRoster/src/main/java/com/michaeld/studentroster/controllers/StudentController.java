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
import org.springframework.web.bind.annotation.RequestParam;

import com.michaeld.studentroster.models.Student;
import com.michaeld.studentroster.services.ClassService;
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
	
	@Autowired
	ClassService classService;
	
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
	
	@GetMapping("/{studentId}/view")
	public String viewStudent(@PathVariable("studentId") Long studentId, Model model) {
		Student student= studentService.getById(studentId);
		model.addAttribute("allClasses", classService.getAllWithoutStudent(student));
		model.addAttribute("student", student);
		return "studentView.jsp";
	}
	
	@PostMapping("/{studentId}/view")
	public String viewStudentSubmit(@PathVariable("studentId") Long studentId, Model model,
				@RequestParam("classId") Long classId) {
		studentService.addStudentIdToClassId(studentId, classId);
		return "redirect:/students/" + studentId + "/view";
	}
	
	@GetMapping("/{studentId}/remove/{classId}")
	public String dropClass(@PathVariable("studentId") Long studentId, @PathVariable("classId") Long classId) {
		Student student = studentService.getById(studentId);
		student.getClasses().remove(classService.getById(classId));
		studentService.update(student);
		return "redirect:/students/" + studentId + "/view";
	}
}
