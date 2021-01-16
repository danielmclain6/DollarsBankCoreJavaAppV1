package com.dollarsbank.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/dollarsbank";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection connection; //Will be null until it's initialized
	
	
	private static void makeConnection() {
		try {
			System.out.println("Beginning of makeconnect()");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registered Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("class notfoundexception");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		if (connection == null) {
			makeConnection();
		}
		
		return connection;
	}
	
//	public static void main(String[] args)   {
//		Connection conn = BetterConnectionManager.getConnection();
//		
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
}
