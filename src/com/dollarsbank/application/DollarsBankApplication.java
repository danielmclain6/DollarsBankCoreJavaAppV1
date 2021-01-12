package com.dollarsbank.application;

import java.util.ArrayList;
import java.util.Scanner;

import com.dollarsbank.controller.Controller;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {

	public static void main(String[] args) {
		ArrayList customerList = new ArrayList<Customer>();
		Scanner input = new Scanner(System.in);
		ConsolePrinterUtility cpu = new ConsolePrinterUtility();
		Controller controller = new Controller();
		boolean isLoggedIn = false;
		int loggedInId;
		
		
		
		while(!isLoggedIn) {
			cpu.initialMenu();
			int choice = input.nextInt();
			switch(choice) {
			case 1:
				Customer customer = controller.addNewCustomer(input);
				System.out.println(customer);
				break;
			case 2:
				
				break;
			case 3:
				System.exit(0);;
			}
		}		

	}

}
