package com.dollarsbank.application;

import java.util.ArrayList;
import java.util.Scanner;

import com.dollarsbank.controller.Controller;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		ConsolePrinterUtility cpu = new ConsolePrinterUtility();
		Controller controller = new Controller();
		boolean isLoggedIn = false;
		int loggedInId;
		Account testAccount = new Account("Checking", 5000);
		Customer testCus = new Customer("Daniel", "address", "Phone", "password", testAccount);
		customerList.add(testCus);

		for (Customer c : customerList) {
			System.out.println(c + "hello");
		}
		Customer loggedInUser = null;

		while (!isLoggedIn) {
			cpu.initialMenu();
			int choice = input.nextInt();
			switch (choice) {
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
				;
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
				int menuChoice = input.nextInt();
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
//					controller.transfer(input, loggedInUser);
					break;
				case 5:
					cpu.viewTransactionHistory(input, loggedInUser);
				}
			}
		}

	}

}
