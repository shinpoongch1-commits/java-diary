package com.hospital.dailyreport.expense;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity                                                  // ★
public class Expense {

	@Id                                                  // ★
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // ★
	private Long id;                                     // ★

	private String name;
	private int amount;

	protected Expense() {                                // ★
	}

	public Expense(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}

	public Long getId() {                                // ★
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}
}