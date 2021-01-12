package com.dollarsbank.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class Controller {
	
	
	
	public Customer addNewCustomer(Scanner in) {
		System.out.println("Please enter your name");
		in.next();
		String name = in.nextLine();
		System.out.println("Please enter your address");
		String address = in.nextLine();
		System.out.println("Please enter your phone number");
		String phone = in.nextLine();
		System.out.println("Create a secure password. Passwords must be at least 6 characters "
				+ "long, have an uppercase and lowercase letters,"
				+ "and a digit and special character(!@#$%^&*()-+");
		String password = in.nextLine();
		boolean goodPassword = passwordChecker(password);
		while(!goodPassword) {
			System.out.println("Please create a secure password. ");
			password = in.next();
			goodPassword = passwordChecker(password);
		}
		System.out.println("Please enter the initial deposit");
		double deposit = in.nextInt();
		Account account = new Account("Checking", deposit);
		return new Customer(name, address, phone, password, account);
		
		
	}
	
	//Checks to see if password has one uppercae letter, one lowercase letter,
	//one digit and special char and is at least 6 chars long
	public static boolean passwordChecker(String pw) {
		String lowercaseRegex = "[a-z]";
		String uppercaseRegex = "[A-Z]";
		String digitRegex = "[0-9]";
		String specialCharRegex = "[!|@|#|$|%|^|&|*|(|)|-|+]";
		
		if(pw.length() < 6) {
			System.out.println("Passwords must be at least 6 characters long");
			return false;
		}
		//Check for lowercase letter
		Pattern pattern = Pattern.compile(lowercaseRegex);
		Matcher password = pattern.matcher(pw);
		boolean hasLowercase = password.find();
		if( !hasLowercase) {
			System.out.println("Password must contain at least 1 lowercase letter");
		}
		
		//Check for uppercase Letter
		pattern = Pattern.compile(uppercaseRegex);
		password = pattern.matcher(pw);
		boolean hasUpperCase = password.find();
		if(!hasUpperCase) {
			System.out.println("Password must contain at leat 1 uppercase letter");
		}
		
		//Check for digit
		//Checking for a digit
		pattern = Pattern.compile(digitRegex);
		password = pattern.matcher(pw);
		boolean hasDigit = password.find();
		if(!hasDigit) {
			System.out.println("Password must contain at least 1 digit");
		}
		
		//check for special char
		pattern = Pattern.compile(specialCharRegex);
		password = pattern.matcher(pw);
		boolean hasSpecial = password.find();
		if(!hasSpecial) {
			System.out.println("Password must contain at least 1 special character");
		}
		if(hasLowercase && hasUpperCase && hasDigit && hasSpecial) {
			return true;
		} else {
		return false;
		}
	}

}
