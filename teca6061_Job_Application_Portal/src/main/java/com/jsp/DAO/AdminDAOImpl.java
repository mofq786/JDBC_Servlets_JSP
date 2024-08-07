package com.jsp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
	
	private static final String url = 
			"jdbc:mysql://localhost:3306/teca6061?user=root&password=12345";
	private final static String admin_login =
			"select * from admin where EMAILID = ? and PASSWORD=?";

	@Override
	public String adminLogin(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement ps = connection.prepareStatement(admin_login);
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet resultSet = ps.executeQuery();
				if(resultSet.next())
				{
					return resultSet.getString("NAME");
				}
				else
				{
					return null;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
