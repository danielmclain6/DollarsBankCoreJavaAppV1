package com.dollarsbank.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
	private String name;
	private String address;
	private static int customers = 1;
	private String phone;
	private String password;
	private HashMap<Integer, Account> accountList;
	private int customerId;
	
	public Customer(String name, String address, String phone, String password, Account account) {
		super();
		this.accountList = new HashMap<Integer, Account>();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.password = password;
		this.accountList.put(account.getAccountNumber(), account);
		this.customerId = customers;
		customers++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<Integer, Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(HashMap<Integer, Account> accountList) {
		this.accountList = accountList;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return name + "\n" + "ID: " + customerId;
				}
	
	
	
	
	
}
