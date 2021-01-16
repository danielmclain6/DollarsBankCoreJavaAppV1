package com.dollarsbank.utility;

import java.util.Scanner;
import java.util.Set;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class ConsolePrinterUtility implements Colors{

	
	public void initialMenu() {
		System.out.println(Colors.ANSI_BLUE + "+--------------------------+");
		System.out.println("|         Welcome          |");
		System.out.println("+--------------------------+" + Colors.ANSI_RESET);
		System.out.println();
		System.out.println("Please make a selection");
		System.out.println("1. New Customer");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.println("4. Log in to DB" + Colors.ANSI_RESET);
	}
	
	public void loggedInMenu(Customer c) {
		
		System.out.println("Welcome, " + c.getName());
		System.out.println();
		System.out.println("Please make a selection");
		System.out.println("1. View your Accounts");
		System.out.println("2. Deposit Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Transfer Money");
		System.out.println("5. View Transaction History");
		System.out.println("6. View Customer Account");
		System.out.println("7. Log out");
	}
	
	public void printAccounts(Customer c) {
		Set<Integer> keyList = c.getAccountList().keySet();
		for(Integer accountNum : keyList) {
			System.out.println(c.getAccountList().get(accountNum));
		}
	}
	
	public void viewTransactionHistory(Scanner in, Customer c) {
		printAccounts(c);
		System.out.println("Enter account number to view history");
		Integer accountNum = in.nextInt();
		while(!c.getAccountList().containsKey(accountNum)) {
			System.out.println("Account Number not found, please try again");
			accountNum = in.nextInt();
		}
		Account acc = c.getAccountList().get(accountNum);
		for(String s : acc.getTransactionHistory()) {
			System.out.println(s);
		}
		
	}
	
	public void printCustomer(Customer c) {
		System.out.println(c);
	}
	  public static <E> E checkInput(E input, E inputCheck, Scanner in) {
	        if(input.getClass().equals(inputCheck.getClass())) {
	            return input;
	        }
	        return null;
	    }
		
	
}
