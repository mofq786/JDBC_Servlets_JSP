package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployeeSalary {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/teca6061?user=root&password=12345";
		String update = "update employee_details set Employee_Salary = 50000 where Employee_Dept_No = 20";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(update);
			
			if(result != 0)
			{
				System.out.println("Salary Updated...");
			}
			else
			{
				System.out.println("No Salary Updated...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
