package com.BankingApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="acct_holder_name")
	private String acctHolderName;
	private double balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Account(Long id, String acctHolderName, double balance) {
		super();
		this.id = id;
		this.acctHolderName = acctHolderName;
		this.balance = balance;
	}


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
	
	
}
