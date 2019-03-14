package com.wipro.bank.bean;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://192.168.199.18:3306/fsd";

	// Database credentials
	static final String USER = "sqluser";
	static final String PASS = "wipro@123";

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}