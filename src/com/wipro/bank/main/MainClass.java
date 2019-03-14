package com.wipro.bank.main;

import java.util.ArrayList;
import java.util.List;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.dao.AccountDao;
import com.wipro.bank.service.AccountService;
import com.wipro.bank.service.AccountServiceImpl;

public class MainClass {
	
	public static void defineDB() {
		List<Account> accounts=new ArrayList<Account>();
		Account acc1=new Account(1,new Customer(1,"cust1"),100.0);
		Account acc2=new Account(2,new Customer(2,"cust2"),0.0);
		Account acc4=new Account(4,new Customer(4,"cust4"),123.0);
		Account acc5=new Account(5,new Customer(5,"cust5"),984.0);
		
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc4);
		accounts.add(acc5);
		
		AccountDao.defineDB(accounts);
	}
	
	
	
	
	
	
	public static void main(String[] args){
		
//		defineDB();
		
		
		AccountService process = new AccountServiceImpl();
		
		System.out.println("************** Get All Accounts *****************");
		System.out.println(process.getAllAccounts());
		System.out.println("\n************** Get All Customers *****************");
		System.out.println(process.getAllCustomers());
		
		Account acc1=new Account(1,new Customer(1,"cust1"),100.0);
		
		Account userTest1=process.getBalanceOf(acc1.getAccountID());
		
		System.out.println("\n@ Account details of account number:"+acc1.getAccountID()+" is :"+"\n## "+userTest1);
		Account acc4=new Account(4,new Customer(4,"cust4"),123.0);
		userTest1=process.getBalanceOf(acc4.getAccountID());
		
		System.out.println("\n@ Account details of account number:"+acc4.getAccountID()+" is as follows"+"\n## "+userTest1);
		System.out.println("\n########## Account Balance for given account number ##########");
		Account userTest2=process.getBalanceOf(3);
		System.out.println("@ Account details of account number:3 .."+"## "+userTest2+" sorry user doesn't exist\n");
		System.out.println("############ All Customer Details ############");
		System.out.println(process.getAllCustomers());
		System.out.println("\n ############ Transfer of Funds from account number 4 to 5 ############");
		
		String transferStatus=process.transferFunds(4,5,100);
		System.out.println("@ Fund Transfer from account 4 to account 5 is: "+transferStatus);
		transferStatus=process.transferFunds(4,5,100);
		System.out.println("@ Response of fund transfer when funds are in sufficient : "+transferStatus);
		userTest1=process.getBalanceOf(4);
		System.out.println("@ Available balance for account number: 4 is"+"\n## "+userTest1);
		userTest1=process.getBalanceOf(5);
		System.out.println("@ Account details of account number: 5 is"+"\n## "+userTest1);
		System.out.println("*******************************************************\n");
		Customer cust3=new Customer(3,"cust3");
		Account acc3=new Account(9,cust3,0.0);
		System.out.println("New Customer & Account created: "+process.addAccount(acc3));
		System.out.println("\n************** Get All Customers *****************");
		System.out.println(process.getAllCustomers());
		
		
		
	}
}
