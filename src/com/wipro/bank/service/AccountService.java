package com.wipro.bank.service;

import java.util.List;

import com.wipro.bank.bean.Account;

public interface AccountService {

	public String addAccount(Account acc);

	public List<Account> getAllAccounts();

	public List<Account> getAllCustomers();

	public String transferFunds(int from, int to, double amount);

	public Account getBalanceOf(int accountNumber);

}
