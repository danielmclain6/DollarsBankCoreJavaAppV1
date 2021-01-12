package com.dollarsbank.model;

public class Account {
	private static int accounts = 1;
	String type;
	int accountNumber;
	double balance;
	public Account(String type, double balance) {
		super();
		this.type = type;
		this.accountNumber = accounts;
		this.balance = balance;
		accounts++;
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
	
	
	
	
	
}
