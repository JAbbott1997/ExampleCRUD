package com.qa.crudApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
	
	Scanner scanner = new Scanner(System.in);
	
	CustomerDAO custDAO = new CustomerDAO();
	
	public void start() {
		while(true) {
			System.out.println("CREATE (1) READ (2) UPDATE (3) DELETE (4) EXIT (5)");
			int select = scanner.nextInt();
			scanner.nextLine();
			switch(select) {
			case 1:
				create();
				break;
			case 2:
				read();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.exit(0);
			}
		}
	}
	
	public void create() {
		System.out.println("Name?");
		String name = scanner.nextLine();
		System.out.println("Email?");
		String email = scanner.nextLine();
		System.out.println("Adress?");
		String address = scanner.nextLine();
		
		custDAO.create(new Customer(name, email, address));
	}
	
	public void read() {
		System.out.println("ID?");
		int id = scanner.nextInt();
		Customer cust = null;
		ResultSet result;
		result = custDAO.read(id);
		
		try {
			while(result.next()) {
				System.out.println(result.getString("cust_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
}
