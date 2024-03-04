package com.BankingApp.dto;

public class AccountDTO {

	private Long id;
	private String acctHolderName;
	private double balance;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAcctHolderName() {
		return acctHolderName;
	}
	public void setAcctHolderName(String acctHolderName) {
		this.acctHolderName = acctHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDTO(Long id, String acctHolderName, double balance) {
		super();
		this.id = id;
		this.acctHolderName = acctHolderName;
		this.balance = balance;
	}
	
	
}
