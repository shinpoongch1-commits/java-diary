package com.capital.loan.calculator;

public class ScheduleRow {
	
	private int seq;
	private long payment;
	private long principal;
	private long interest;
	private long balance;
	
	public ScheduleRow (int seq, long payment, long principal, long interest, long balance){
		this.seq=seq;
		this.payment= payment;
		this.principal= principal;
		this.interest= interest;
		this.balance= balance;
		
	
	}

		public int getSeq() {return seq;}
		public long getPayment() {return payment;}
		public long getPrincipal() {return principal;}
		public long getInterest() {return interest;}
		public long getBalance() {return balance;}
	

}
