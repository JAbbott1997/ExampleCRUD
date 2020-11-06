package com.qa.crudApp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
	
	private static JDBCConnection DBInstance;
	
	public CustomerDAO() {
		DBInstance = JDBCConnection.connect("root", "root");
	}
	
	public void create(Customer cust) {
		String query;
		int localID = cust.getID();
		String localName = cust.getName();
		String localEmail = cust.getEmail();
		String localAddress = cust.getAddress();
		query = "INSERT INTO customers VALUES("+
				localID + ", '" + localName +"', '" + localEmail +"', '" + localAddress + "')";
		try {
			DBInstance.exUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet read(int id) {
		String query = "SELECT * FROM customers WHERE customer_id = " + id + ";";
		ResultSet result = null;
		
		try {
			result = DBInstance.exQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void update(int id, Customer cust) {
		String query;
		String localName = cust.getName();
		String localEmail = cust.getEmail();
		String localAddress = cust.getAddress();
		query = "UPDATE customers SET cust_name = '" 
				+ localName + "', email = '" + localEmail 
				+ "', address = '" + localAddress + "' WHERE customer_id = " + id;
		
		try {
			DBInstance.exUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int id) {
		String query;
		query = "DELETE FROM customers WHERE customer_id = " + id;
	}
}
