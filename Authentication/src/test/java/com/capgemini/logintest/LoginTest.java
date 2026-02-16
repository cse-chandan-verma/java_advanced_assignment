package com.capgemini.logintest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.capgemini.login.Login;

public class LoginTest {
	
	@Test
	void validUser1() {
		assertTrue(Login.isValidUserName("chandanv03"));
	}
	
	@Test
	void checkPassword1() {
		assertTrue(Login.isValidPassword("chandan@Password123"));
	}
	
	@Test 
	void validUser2() {
		assertFalse(Login.isValidUserName("Demo"));
	}
	
	@Test
	void checkPassword2() {
		assertFalse(Login.isValidPassword("demo231"));
	}
	
	@Test
	void validateUser() {
		assertEquals("Logged In successfully",Login.loginUser("username", "passWord12@"));
	}
	
	
	@Test
	void nullUserName() {
		assertFalse(Login.isValidUserName(null));
	}
	
	
}
