package com.dollarsbank.model;

import java.util.ArrayList;

public class Account {
	private static int accounts = 1;
	private String type;
	private int accountNumber;
	private double balance;
	private ArrayList<String> transactionHistory;
	public Account(String type, double balance) {
		super();
		this.type = type;
		this.accountNumber = accounts;
		this.balance = balance;
		transactionHistory = new ArrayList<String>();
		transactionHistory.add("Initial Deposit of " + balance);
		accounts++;
		System.out.println(transactionHistory);
	}
	public static int getAccounts() {
		return accounts;
	}
	public static void setAccounts(int accounts) {
		Account.accounts = accounts;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public ArrayList<String> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(String transaction) {
		this.transactionHistory.add(transaction);
	}
	public void makeDeposit(double deposit) {
		this.balance += deposit;
		recordDeposit(deposit);
	}
	
	
	
	public void withdraw(double amount) {
		this.balance -= amount;
		recordWithdrawal(amount);
	}
	public void recordDeposit(double amount) {
		String transaction = "Deposited $" + amount;
		setTransactionHistory(transaction);
	}
	
	public void recordWithdrawal(double amount) {
		String transaction = "Withdrew $" + amount;
		setTransactionHistory(transaction);
	}
	@Override
	public String toString() {
		return type + " Account Number: "+ accountNumber + "\n Balance: " + balance;
	}
	
	
	
	
	
}
