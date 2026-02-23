package com.capgemini.login.Bank;

public class BankServices {
	
	public boolean deposit(BankAccount accountNumber, double amount) {
		if(amount < 0) {
			return false;
		}
		
		double balance = accountNumber.getCurrentBalance();
		accountNumber.setCurrentBalance(balance + amount);
		return true;
	}
	
	public boolean withdrawl(BankAccount accountNumber, double amount) {
		double balance = accountNumber.getCurrentBalance();
		
		if(amount > balance) {
			return false;
		}
		
		accountNumber.setCurrentBalance(balance - amount);
		return true;
	}
	
	public boolean checkBalance(BankAccount accountNumber) {
		if(accountNumber.getCurrentBalance() < 1000) {
			return false;
		}
		
		return true;
	}
}
