package com.michaeld.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.michaeld.savetravels.models.Expense;
import com.michaeld.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public Expense create(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();
	}
	
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        return optionalExpense.isPresent() ? optionalExpense.get() : null;
    }
	
	public Expense update(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}
}
