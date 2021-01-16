package com.dollarsbank.application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.dollarsbank.controller.Controller;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.Colors;
import com.dollarsbank.utility.ConsolePrinterUtility;
import java.sql.Connection;
import java.sql.SQLException;

import com.dollarsbank.connection.ConnectionManager;

public class DollarsBankApplication implements Colors {

	public static void main(String[] args) {
	
		
		ArrayList<Customer> customerList = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		ConsolePrinterUtility cpu = new ConsolePrinterUtility();
		Controller controller = new Controller();
		boolean isLoggedIn = false;
		Account testAccount = new Account("Checking", 5000);
		Account testAccount2 = new Account("Savings", 10000);
		Customer testCus = new Customer("Daniel", "address", "Phone", "password", testAccount);
		testCus.addAccount(testAccount2);
		customerList.add(testCus);

		Customer loggedInUser = null;
		boolean invalidChoice = true;
		int menuChoice = 0;
		
		
		//Prints menu
//		"+--------------------------+"
//		"|         Welcome          |"
//		"+--------------------------+" 
//		
//		"Please make a selection"
//		"1. New Customer"
//		"2. Login"
//		"3. Exit"
//		"4. Log in to DB"
		while(true) {
		while (!isLoggedIn) {
			cpu.initialMenu();
			while (invalidChoice) {
				if (input.hasNextInt()) {
					menuChoice = input.nextInt();
					invalidChoice = false;
				} else {
					System.out.println("Please enter a valid menu option");
					cpu.initialMenu();
					input.next();
				}
			}
			switch (menuChoice) {
			case 1:
				Customer customer = controller.addNewCustomer(input);
				customerList.add(customer);
				System.out.println(customer);
				break;
			case 2:
				loggedInUser = controller.login(input, customerList);
				if (loggedInUser != null) {
					isLoggedIn = true;
				}
				break;
			case 3:
				System.exit(0);
				break;
			case 4:
				loggedInUser = controller.loginDB(input);
				if(loggedInUser != null) {
					isLoggedIn = true;
				}
				break;
			default:
				System.out.println("Please enter a valid menu option");
				invalidChoice = true;

			}
			// Logged in Menu:
//			1. View your Accounts
//			2. Deposit Money
//			3. Withdraw Money
//			4. Transfer money
//			5. View Transaction History"
//			6. View Customer Account
			
			while (isLoggedIn) {
				cpu.loggedInMenu(loggedInUser);
				invalidChoice = true;
				while (invalidChoice) {
					if (input.hasNextInt()) {
						menuChoice = input.nextInt();
						invalidChoice = false;
					} else {
						System.out.println("Please enter a valid menu option");
						input.next();
					}
				}

				switch (menuChoice) {
				case 1:
					cpu.printAccounts(loggedInUser);
					break;
				case 2:
					controller.deposit(input, loggedInUser);
					break;

				case 3:
					controller.withdraw(input, loggedInUser);
					break;
				case 4:
					controller.transfer(input, loggedInUser);
					break;
				case 5:
					cpu.viewTransactionHistory(input, loggedInUser);
					break;
				case 6:
					cpu.printCustomer(loggedInUser);
					break;
				case 7:
					isLoggedIn = false;
					invalidChoice = true;
					break;
				default:
					System.out.println("Please enter a valid menu option2");
					invalidChoice = true;
				}
			}
		}
		input.close();
	}
	}
}
