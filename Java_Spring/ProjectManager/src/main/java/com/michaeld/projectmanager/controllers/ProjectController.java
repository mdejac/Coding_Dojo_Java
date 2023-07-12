package com.michaeld.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.michaeld.projectmanager.models.Project;
import com.michaeld.projectmanager.models.Task;
import com.michaeld.projectmanager.services.ProjectService;
import com.michaeld.projectmanager.services.TaskService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "projectNew.jsp";
	}
	
	@PostMapping("/new")
	public String newProjectSubmit(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "projectNew.jsp";
		}
		projectService.create(project, (Long)session.getAttribute("userId"));
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{projectId}/join")
	public String joinProject(@PathVariable("projectId") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		projectService.addUserIdtoProjectTeam((Long) session.getAttribute("userId"), id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{projectId}/leave")
	public String leaveProject(@PathVariable("projectId") Long id, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		projectService.removeUserIdFromProjectTeam((Long) session.getAttribute("userId"), id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{projectId}/edit")
	public String update(@PathVariable("projectId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Project project = projectService.getById(id);
		if (!project.getCreator().getId().equals((Long)session.getAttribute("userId"))) {
			return "redirect:/dashboard";
		}
		model.addAttribute("project", project);
		return "projectEdit.jsp";
	}
	
	@PutMapping("/{id}/edit")
	public String updateSubmit(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "projectEdit.jsp";
		}
		projectService.update(project);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{projectId}/view")
	public String viewProject(@PathVariable("projectId") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("project", projectService.getById(id));
		return "projectView.jsp";
	}
	
	@GetMapping("/{projectId}/tasks")
	public String projectTaskView(@PathVariable("projectId") Long projectId, @ModelAttribute("task") Task task, 
								Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("project", projectService.getById(projectId));
		return "projectTask.jsp";
	}
	
	@PostMapping("/{projectId}/tasks")
	public String projectTastViewSubmit(@PathVariable("projectId") Long projectId, HttpSession session,
										@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "projectTask.jsp";
		}
		taskService.create(task, projectId, (Long) session.getAttribute("userId"));
		return "redirect:/projects/" + projectId + "/tasks";
	}
	
	@GetMapping("/{projectId}/delete")
	public String delete(@PathVariable("projectId") Long id) {
		projectService.delete(id);
		return "redirect:/dashboard";
	}
}
