package com.qa.crudApp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	
	private int ID = 0;
	private String name;
	private String email;
	private String address;
	
	public Customer(String name, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public Customer(int ID, String name, String email, String address) {
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public static Customer convert(ResultSet result) throws SQLException {
		if(result.next()) {
			int localID = result.getInt("customer_id");
			String localName = result.getString("cust_name");
			String localEmail = result.getString("email");
			String localAddress = result.getString("address");
			return new Customer(localID, localName, localEmail, localAddress);
		} else {
			return null;
		}
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "Customer ID: " + ID 
				+ ", Name: " + name + ", email: " + email;
	}
	
}
