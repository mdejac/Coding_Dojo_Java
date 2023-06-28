package com.michaeld.savetravels.controllers;

import java.util.List;

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

import com.michaeld.savetravels.models.Expense;
import com.michaeld.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> allExpenses = expenseService.allExpenses();
		Double totalSpent = 0.0;
		for (Expense expenses : allExpenses) {
			totalSpent += expenses.getAmount();
		}
		model.addAttribute("allExpenses", allExpenses);
		model.addAttribute("totalSpent", totalSpent);
		return "index.jsp";
	}
	
	@PostMapping("/create/submit")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		}
		expenseService.create(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "show.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		model.addAttribute("expenseName", expense.getName());
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editSubmit(@Valid @ModelAttribute("expense") Expense expense,
							BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expense", expense);
			model.addAttribute("expenseName", expenseService.findExpense(expense.getId()).getName());
			return "edit.jsp";
		}
		expenseService.update(expense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.delete(id);
		return "redirect:/expenses";
	}

}
