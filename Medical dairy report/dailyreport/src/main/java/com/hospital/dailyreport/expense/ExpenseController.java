package com.hospital.dailyreport.expense;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExpenseController {

	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/expenses")
	public String list(Model model) {
		model.addAttribute("expenses", expenseService.findAll());
		model.addAttribute("total", expenseService.total());
		return "expenses/list";
	}

	@PostMapping("/expenses")
	public String add(@RequestParam String name, @RequestParam int amount) {
		expenseService.add(name, amount);
		return "redirect:/expenses";
	}
}