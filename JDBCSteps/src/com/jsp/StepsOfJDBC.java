package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepsOfJDBC {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		//String insert = "CREATE TABLE teca6061.farooq_table (Name VARCHAR(45) NOT NULL, Mob_No BIGINT NOT NULL,PRIMARY KEY (Mob_No));";
		String insert = "UPDATE teca6061.employee_details SET Employee_Name = 'dingi' WHERE (Employee_ID = 100)";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			System.out.println("Connection Established...");
			Statement statement = connection.createStatement();
			System.out.println("Platform Created...");
			
			int result = statement.executeUpdate(insert);
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
