package com.qa.crudApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/game";
	private static String DB_USER;
	private static String DB_PASS;
	private static JDBCConnection instance = null;
	
	private JDBCConnection(String DB_USER, String DB_PASS) {
		this.DB_USER = DB_USER;
		this.DB_PASS = DB_PASS;
		try {
			getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	
	public static JDBCConnection connect(String DB_USER, String DB_PASS) {
		if (instance == null) {
			instance = new JDBCConnection(DB_USER, DB_PASS);
		} 
		return instance;
	}
	
	public void exUpdate(String query) throws SQLException {
		Connection con = getConnection();
		Statement state = con.createStatement();

		state.executeUpdate(query);
	}
	
	public ResultSet exQuery(String query) throws SQLException {
		ResultSet result = null;
		Connection con = getConnection();
		Statement state = con.createStatement();
		result = state.executeQuery(query);
		return result;
	}
	
}
