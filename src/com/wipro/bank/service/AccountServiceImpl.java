package com.wipro.bank.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.ConnectionUtil;
import com.wipro.bank.bean.Customer;

public class AccountServiceImpl implements AccountService {
	
	Connection conn = null;

	@Override
	public String addAccount(Account acc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		
		conn = ConnectionUtil.getConnection();
		Statement stmt = null;
		
		List<Account> list = new ArrayList<Account>();
		try {
		String str = "select * from account a, customerprofile b where a.accountId = b.id";//"SELECT accountId,customerid,balance FROM account";
		
		stmt =  conn.createStatement();
		
		ResultSet  rs = stmt.executeQuery(str);
		
		while(rs.next()) {
			int accountId = Integer.parseInt(rs.getString("accountId"));
			Float balance = Float.parseFloat(rs.getString("balance"));
			int id = Integer.parseInt(rs.getString("id"));	
			String name = rs.getString("name");
			Customer cust = new Customer(id,name);
			Account account = new Account(accountId,cust,balance);
			
			list.add(account);
		}
		
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<Account> getAllCustomers() {
		
		return this.getAllAccounts();
	}

	@Override
	public String transferFunds(int from, int to, double amount) {
		
		String updte1 = "update account set balance=balance-'"+amount+"' where accountId = "+from+" and balance>= '"+amount+"'";
		String updte2 = "update account set balance=balance+'"+amount+"' where accountId = "+to+" and balance>= '"+amount+"'";
		
		conn = ConnectionUtil.getConnection();
		
		Statement stmt = null;
		String status = "";
		try
		{
			conn.setAutoCommit(false);
			stmt =  conn.createStatement();
			
			stmt.addBatch(updte1);
			stmt.addBatch(updte2);
			stmt.executeBatch();
			
			conn.commit();
			
			status = "success";
		
		}
		catch(Exception ex) {
			status = "founds not available";
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("exception occured " +  ex.getMessage());
		}
		finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
				
		
		
		return status;
	}

	@Override
	public Account getBalanceOf(int accountNumber) {
		conn = ConnectionUtil.getConnection();
		Statement stmt = null;
		
		Account ac = null;
		try {
		String str = "select * from account a, customerprofile b where a.accountId = b.id and accountId='"+accountNumber+"' ";
		System.out.println(str+"=============");
		stmt =  conn.createStatement();
		
		ResultSet  rs = stmt.executeQuery(str);
		
		while(rs.next()) {
			int accountId = Integer.parseInt(rs.getString("accountId"));
			Float balance = Float.parseFloat(rs.getString("balance"));
			int id = Integer.parseInt(rs.getString("id"));	
			String name = rs.getString("name");
			Customer cust = new Customer(id,name);
			Account account = new Account(accountId,cust,balance);
			
			ac = account;
		}
		
		}
		catch(Exception ex) {
			System.out.println("exception occured " +  ex.getMessage());
		}
		finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return ac;
	}

}
