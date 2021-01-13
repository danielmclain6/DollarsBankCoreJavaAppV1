package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class Controller {
	
	ConsolePrinterUtility cpu = new ConsolePrinterUtility();
	
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
	
	public Customer login(Scanner in, ArrayList<Customer> custArray) {
		boolean userNotLoggedIn = true;
		while (userNotLoggedIn) {
		System.out.println("Enter ID:");
		int id = in.nextInt();
		System.out.println("Please enter password");
		String password = in.next();
		for(Customer c : custArray) {
			if (id == c.getCustomerId()) {
				if(password.equals(c.getPassword())) {
					System.out.println("Correct");
					return c;
					
				} else {
					System.out.println("Incorrect user or password");					
				}
			}
		}
		}
		return null;
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
	
	public void deposit(Scanner in, Customer c) {
		cpu.printAccounts(c);
		System.out.println("Enter the ID of the account you would like to depsoit money into?");
		int id = in.nextInt();
		boolean isValidAccountNum = false;
		if(c.getAccountList().containsKey(id)) {
			System.out.println("How much would you like to deposit?");
			double deposit = in.nextDouble();
			if(deposit < 0) {
				while(deposit <= 0) {
					System.out.println("Deposits must be a positive, non-negative number, please type your deposit amount again");
					deposit = in.nextDouble();
				}
			} 
				System.out.println("Depositt successful!");
				c.getAccountList().get(id).makeDeposit(deposit);
		}
		
	}
		public void withdraw(Scanner in, Customer c) {
			cpu.printAccounts(c);
			System.out.println("Enter the ID of the account you want to withdraw money from:");
			int id = in.nextInt();
			if(!c.getAccountList().containsKey(id)) {
				while(!c.getAccountList().containsKey(id)) {
					System.out.println("Incorrect ID number, pleae try again");
					id = in.nextInt();
			} 
			}
				System.out.println("How much would you like to withdraw?");
				double withdrawal = in.nextDouble();
				while(withdrawal <= 0 || withdrawal > c.getAccountList().get(id).getBalance()) {
					if(withdrawal <= 0) {
					System.out.println("Withdrawals must be a positive amount, please try again");
					withdrawal= in.nextDouble();
					}
					if(withdrawal > c.getAccountList().get(id).getBalance()) {
						System.out.println("You can't withdraw more money than is in the account, please try again");
						withdrawal = in.nextDouble();
					}
				}
				System.out.println("You have withdrawn " + withdrawal + " from account " + id);
				c.getAccountList().get(id).withdraw(withdrawal);
				
		}
			
		
	
	
	
	

}
