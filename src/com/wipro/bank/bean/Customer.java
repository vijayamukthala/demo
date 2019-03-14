package com.wipro.bank.bean;

public class Customer {

	private int customerID;
	private String name;

	public Customer(int id, String name) {
		this.customerID = id;
		this.name = name;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	private double balance;

	public Customer() {// No args constructor

	}

	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", balance=" + balance + "]";
	}

}
