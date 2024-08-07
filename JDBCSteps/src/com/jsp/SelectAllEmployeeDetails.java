package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllEmployeeDetails {

	public static void main(int[] args) {
		
		String select = "select * from employee_details";
		String url = "jdbc:mysql://localhost:3306/teca6061?user=root&password=12345";
		
		try {
			Connection connection = DriverManager.getConnection(url);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(select);
			
			if(resultSet.isBeforeFirst())
			{
				while(resultSet.next())
				{
					System.out.println("Record is Present");
				}
			}
			else
			{
				System.out.println("No Records is Present");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Woman");
		
	}

}
