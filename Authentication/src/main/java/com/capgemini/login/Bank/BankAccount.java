package com.capgemini.login.Bank;

public class BankAccount {
	private int accountNumber;
	private String accountHolderName;
	private double currentBalance;
	
	
	public BankAccount() {
		
	}

	public BankAccount(int accountNumber, String accountHolderName, double currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.currentBalance = currentBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	
	
}
