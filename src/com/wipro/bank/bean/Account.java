package com.wipro.bank.bean;

public class Account {

	private int accountID;
	private Customer customer;
	private double balance;

	public Account() {

	}

	public Account(int accountID, Customer customer, double balance) {
		this.accountID = accountID;
		this.customer = customer;
		this.balance = balance;
	}


	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		return "Account [accountID=" + accountID + ", customer=" + customer + ", balance=" + balance + "]";
	}

}
