package com.hospital.dailyreport.expense;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}

	public void add(String name, int amount) {
		expenseRepository.save(new Expense(name, amount));
	}

	public int total() {
		int total = 0;
		for (Expense expense : findAll()) {
			total = total + expense.getAmount();
		}
		return total;
	}
}