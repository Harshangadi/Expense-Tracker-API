package com.harsh.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harsh.expensetracker.model.Expense;
import com.harsh.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository repository;
	
	public List<Expense> getAllExpenses(){
		return repository.findAll();
	}
	
	public Expense getExpenseById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Expense createExpense(Expense expense) {
		return repository.save(expense);
	}
	
	public Expense updateExpense(Long id, Expense updatedExpense) {
		Optional<Expense> optional = repository.findById(id);
		if(optional.isPresent()) {
			Expense expense = optional.get();
			expense.setDescription(updatedExpense.getDescription());
			expense.setAmount(updatedExpense.getAmount());
			expense.setCategory(updatedExpense.getCategory());
			expense.setDate(updatedExpense.getDate());
			return repository.save(expense);
		}
		return null;
	}
	
	public void deleteExpense(Long id) {
		repository.deleteById(id);
	}
	
	public List<Expense> getExpensesByCategory(String category){
		return repository.findByCategory(category);
	}
}
