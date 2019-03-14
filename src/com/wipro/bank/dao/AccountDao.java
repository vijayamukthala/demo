package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.ConnectionUtil;
import com.wipro.bank.bean.Customer;

public class AccountDao {

	public  List<Account> accounts;
	public  List<Customer> customers;

	public int saveAccount(Account account) {
		Connection conn = ConnectionUtil.getConnection();

		try {
			conn.setAutoCommit(false);

			PreparedStatement ps1 = null;

			String accStr = "INSERT INTO account (accountId, customerid, balance) VALUES (?,?,?)";

			ps1 = conn.prepareStatement(accStr);

			Customer cust = account.getCustomer();
			System.out.println("custcustcust" + cust);

			ps1.setInt(1, account.getAccountID());
			ps1.setInt(2, account.getCustomer().getCustomerID());
			ps1.setDouble(3, account.getBalance());
			ps1.executeUpdate();

			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public List<Account> findAllAccounts() {
		return null;

	}

	public int saveCustomer(Customer customer) {

		Connection conn = ConnectionUtil.getConnection();
		int result = -1;
		try {
			conn.setAutoCommit(false);

			PreparedStatement ps = null;

			String query = "INSERT INTO customerprofile (id, name) VALUES (?,?)";

			ps = conn.prepareStatement(query);
			ps.setInt(1, customer.getCustomerID());
			ps.setString(2, customer.getName());
			result = ps.executeUpdate();

			conn.commit();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;

	}

	public List<Account> findAllCustomers() {
		return null;

	}

	public  List<Account> getAccounts() {
		return accounts;
	}

	public  void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public  List<Customer> getCustomers() {
		return customers;
	}

	public  void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public static void defineDB(List<Account> accounts) {

		Connection conn = ConnectionUtil.getConnection();

		try {
			conn.setAutoCommit(false);

			PreparedStatement ps = null;
			PreparedStatement ps1 = null;

			String query = "INSERT INTO customerprofile (id, name) VALUES (?,?)";

			ps = conn.prepareStatement(query);

			String accStr = "INSERT INTO account (accountId, customerid, balance) VALUES (?,?,?)";

			ps1 = conn.prepareStatement(accStr);

			for (Account account : accounts) {

				Customer cust = account.getCustomer();
				System.out.println("custcustcust" + cust);

				ps.setInt(1, cust.getCustomerID());
				ps.setString(2, cust.getName());

				ps.executeUpdate();
				ps1.setInt(1, account.getAccountID());
				ps1.setInt(2, account.getCustomer().getCustomerID());
				ps1.setDouble(3, account.getBalance());
				ps1.executeUpdate();

			}

			conn.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
