package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployeeData {
	
public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/teca6061?user=root&password=12345";
		String delete = "delete from employee_details where Employee_ID = 103";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate(delete);
			
			if(result != 0)
			{
				System.out.println("Data Deleted");
			}
			else
			{
				System.out.println("No Data Deleted...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
