package com.capital.loan.calculator;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

	private final LoanCalculator loanCalculator;

	public CalculatorController(LoanCalculator loanCalculator) {
		this.loanCalculator = loanCalculator;
	}

	@GetMapping("/calculator")
	public String calculate(@RequestParam(defaultValue = "10000000") long loanAmount,
			@RequestParam(defaultValue = "3") double annualRate,
			@RequestParam(defaultValue = "36") int months,
			@RequestParam(defaultValue = "0.1") double feeRate,
			Model model) {

		List<ScheduleRow> rows = loanCalculator.schedule(loanAmount, annualRate, months);
		long fee = loanCalculator.fee(loanAmount, feeRate);

		model.addAttribute("loanAmount", loanAmount);
		model.addAttribute("annualRate", annualRate);
		model.addAttribute("months", months);
		model.addAttribute("feeRate", feeRate);

		model.addAttribute("monthlyPayment", loanCalculator.monthlyPayment(loanAmount, annualRate, months));
		model.addAttribute("fee", fee);
		model.addAttribute("netAmount", loanAmount - fee);
		model.addAttribute("totalInterest", loanCalculator.totalInterest(rows));
		model.addAttribute("rows", rows);

		return "calculator";
	}
}