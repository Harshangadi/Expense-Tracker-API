package com.harsh.expensetracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harsh.expensetracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

	List<Expense> findByCategory(String category);
}
