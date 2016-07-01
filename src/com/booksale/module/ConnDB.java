package com.booksale.module;

import java.sql.*;


public class ConnDB {
	public static final String url = "jdbc:oracle:thin:@localhost:1521:BookSale";
	public static final String user="BOOKSALE";
	public static final String password="localhost";
	
	private Connection ct = null;
	
	public Connection getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ct;
	}
}
