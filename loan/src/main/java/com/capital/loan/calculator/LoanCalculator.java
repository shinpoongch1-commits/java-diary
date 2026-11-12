package com.capital.loan.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LoanCalculator {

	// ① 월 이율: 연 3(%) → 0.0025
	private BigDecimal monthlyRate(double annualRate) {
		return BigDecimal.valueOf(annualRate).divide(BigDecimal.valueOf(1200), 10, RoundingMode.DOWN);
	}

	// ② 월 상환액 (원리금균등, 원 미만 절사)
	public long monthlyPayment(long loanAmount, double annualRate, int months) {
		BigDecimal r = monthlyRate(annualRate);
		BigDecimal pow = BigDecimal.ONE.add(r).pow(months);
		BigDecimal top = BigDecimal.valueOf(loanAmount).multiply(r).multiply(pow);
		BigDecimal bottom = pow.subtract(BigDecimal.ONE);
		return top.divide(bottom, 0, RoundingMode.DOWN).longValue();
	}

	// ③ 선취수수료 (원 미만 절사)
	public long fee(long loanAmount, double feeRate) {
		return BigDecimal.valueOf(loanAmount).multiply(BigDecimal.valueOf(feeRate))
				.divide(BigDecimal.valueOf(100), 0, RoundingMode.DOWN).longValue();
	}

	// ④ 상환 스케줄 (회차별 한 줄씩)
	public List<ScheduleRow> schedule(long loanAmount, double annualRate, int months) {
		BigDecimal r = monthlyRate(annualRate);
		long payment = monthlyPayment(loanAmount, annualRate, months);
		List<ScheduleRow> rows = new ArrayList<>();
		long balance = loanAmount;

		for (int seq = 1; seq <= months; seq++) {
			long interest = BigDecimal.valueOf(balance).multiply(r)
					.setScale(0, RoundingMode.DOWN).longValue();
			long principal = payment - interest;
			if (seq == months) {
				principal = balance;
			}
			balance = balance - principal;
			rows.add(new ScheduleRow(seq, principal + interest, principal, interest, balance));
		}
		return rows;
	}
	
	// ⑤ 총이자: 36줄의 이자를 모두 더함
	public long totalInterest(List<ScheduleRow> rows) {
		long total = 0;
		for (ScheduleRow row : rows) {
			total = total + row.getInterest();
		}
		return total;
	}
}