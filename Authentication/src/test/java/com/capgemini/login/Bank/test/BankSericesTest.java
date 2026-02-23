package com.capgemini.login.Bank.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.login.Bank.BankAccount;
import com.capgemini.login.Bank.BankServices;

public class BankSericesTest {
	
	BankAccount bankAccount = new BankAccount(1100110, "Chandan", 10000);
	BankServices bankServices = new BankServices();
	
	@Test
	void depositTest() {
		assertTrue(bankServices.deposit(bankAccount , 15000));
	}
	
	@Test
	void withdrawlCheck() {
		assertFalse(bankServices.withdrawl(bankAccount, 40000));
	}
	
	@Test
	void checkBalanceTest() {
		assertTrue(bankServices.checkBalance(bankAccount));
	}
}
