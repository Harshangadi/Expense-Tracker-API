package com.harsh.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.expensetracker.model.Expense;
import com.harsh.expensetracker.repository.ExpenseRepository;
import com.harsh.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
	
	
	private final ExpenseRepository expenseRepository;

    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // 🔍 GET expenses by category
    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {
        return expenseRepository.findByCategory(category);
    }
	
	@Autowired
	private ExpenseService service;
	
	@GetMapping
	public List<Expense> getAllExpenses(){
		return service.getAllExpenses();
	}
	
	@GetMapping("/{id}")
	public Expense getExpense(@PathVariable Long id) {
		return service.getExpenseById(id);
	}
	
	@PostMapping
	public Expense addExpense(@RequestBody Expense expense) {
		return service.createExpense(expense);
	}
	
	@PutMapping("/{id}")
	public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
		return service.updateExpense(id, expense);
	}
	
	@DeleteMapping("/{id}")
	public void deleteExpense(@PathVariable Long id) {
		service.deleteExpense(id);
	}
	
//	@GetMapping("/category/{category}")
//	public List<Expense> getByCategory(@PathVariable String category){
//		return service.getExpensesByCategory(category);
//	}
	
}
