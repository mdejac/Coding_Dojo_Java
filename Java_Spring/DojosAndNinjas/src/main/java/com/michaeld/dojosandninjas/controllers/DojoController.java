package com.michaeld.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.dojosandninjas.models.Dojo;
import com.michaeld.dojosandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	@Autowired
	DojoService dojoService;

	@GetMapping("/new")
	public String dojoNew(@ModelAttribute("dojo") Dojo dojo) {
		return "dojoCreate.jsp";
	}
	
	@PostMapping("/create")
	public String dojoNewSubmit(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "dojoCreate.jsp";
		}
		dojoService.create(dojo);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}")
	public String dojoView(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.getById(id));
		return "dojoView.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String dojoEdit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.getById(id));
		model.addAttribute("dojoName", (dojoService.getById(id)).getName());
		return "dojoEdit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String dojoEditSubmit(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, 
								Model model, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			model.addAttribute("dojoName", (dojoService.getById(id)).getName());
			return "dojoEdit.jsp";
		}
		dojoService.update(dojo);
		return "redirect:/";
	}
	
	@DeleteMapping("/delete/{dojoId}")
	public String dojoDelete(@PathVariable("dojoId") Long id) {
		dojoService.delete(id);
		return "redirect:/";
	}
}
