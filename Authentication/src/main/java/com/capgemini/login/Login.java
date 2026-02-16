package com.capgemini.login;

public class Login {
	private String username;
	private String password;

	public static boolean isValidUserName(String username) {
		if(username == null || username.isEmpty()) {
			return false;
		}
		
		if(username.length() < 5 || username.length() > 15) {
			return false;
		}
		
		return username.matches("^[a-zA-Z0-9]+$");
	}
	
	public static boolean isValidPassword(String password) {
		if(password == null || password.isEmpty()) {
			return false;
		}
		
		if(password.length() < 8) {
			return false;
		}
		
		String validPassword = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[@#$%^&*?]).{8,}$";
		
		if (password.matches(validPassword)) {
			return true;
		}
		return false;
	}
	
	public static String loginUser(String username, String password) {
		if(isValidUserName(username) && isValidPassword(password)) {
			return "Logged In successfully";
		}
		return "Invalid Credentials";
	}
	
}
