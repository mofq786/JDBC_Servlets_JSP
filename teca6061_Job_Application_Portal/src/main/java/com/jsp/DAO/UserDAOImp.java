package com.jsp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.Model.UserInformation;

public class UserDAOImp implements UserDAO {

	private final static String url="jdbc:mysql://localhost:3306/teca6061?user=root&password=12345";
	private final static String insert_email_password = "insert into user_details(Email_Id,Password) values (?,?)";
	private final static String update_user_details = "update user_details set FirstName=?, LastName=?, MobileNumber=?, Gender=? where Email_Id=? and Password=?";
	private final static String update_user_education_details = 
			"update user_details set Qualification=?, Percentage=? where Email_Id=? and Password=?";
	private final static String delete_user_details = 
			"delete from user_details where Percentage is NULL";
	private final static String select_All_Users = 
			"select * from user_details";
	private final static String select_user_details_byId =
			"select * from user_details where Id=?";
	private final static String update_user_details_based_on_id=
			"update user_details set FirstName=?, LastName=?, Email_Id=?, MobileNumber=?, Qualification=?, Percentage=? where Id=?";
	private final static String delete_user_details_based_on_id=
			"delete from user_details where Id=?";
	
	@Override
	public int insertUserDetails(String email, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(insert_email_password);
			ps.setString(1, email);
			ps.setString(2, password);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public int updateUserDetails(UserInformation userInformation) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update_user_details);
			ps.setString(1, userInformation.getFirstName());
			ps.setString(2, userInformation.getLastName());
			ps.setLong(3, userInformation.getMobileNumber());
			ps.setString(4, userInformation.getGender());
			ps.setString(5, userInformation.getEmailId());
			ps.setString(6,userInformation.getPassword());
			
			return ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int updateUserEducationDetails(UserInformation userInformation) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update_user_education_details);
			ps.setString(1, userInformation.getQualification());
			ps.setDouble(2, userInformation.getPercentage());
			ps.setString(3, userInformation.getEmailId());
			ps.setString(4, userInformation.getPassword());
			
			return ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int deleteUserDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection(url);
				Statement statement = connection.createStatement();
				return statement.executeUpdate(delete_user_details);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<UserInformation> getAllUserDetails() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select_All_Users);
			ResultSet resultSet = ps.executeQuery();
			
			if(resultSet.isBeforeFirst())
			{
				List<UserInformation> list = new ArrayList<>();
				while(resultSet.next())
				{
					UserInformation userInformation  = new UserInformation();
					userInformation.setId(resultSet.getInt("Id"));
					userInformation.setEmailId(resultSet.getString("Email_Id"));
					userInformation.setPassword(resultSet.getString("Password"));
					userInformation.setQualification(resultSet.getString("Qualification"));
					userInformation.setPercentage(resultSet.getDouble("Percentage"));
					userInformation.setMobileNumber(resultSet.getLong("MobileNumber"));
					userInformation.setFirstName(resultSet.getString("FirstName"));
					userInformation.setLastName(resultSet.getString("LastName"));
					userInformation.setGender(resultSet.getString("Gender"));
					list.add(userInformation);
				}
				return list;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return null;
		
	}
	@Override
	public UserInformation getUserDetailsByUsingId(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select_user_details_byId);
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next())
			{
				UserInformation userInformation  = new UserInformation();
				userInformation.setId(resultSet.getInt("Id"));
				userInformation.setEmailId(resultSet.getString("Email_Id"));
				userInformation.setPassword(resultSet.getString("Password"));
				userInformation.setQualification(resultSet.getString("Qualification"));
				userInformation.setPercentage(resultSet.getDouble("Percentage"));
				userInformation.setMobileNumber(resultSet.getLong("MobileNumber"));
				userInformation.setFirstName(resultSet.getString("FirstName"));
				userInformation.setLastName(resultSet.getString("LastName"));
				userInformation.setGender(resultSet.getString("Gender"));
				
				return userInformation;
			}
			else
			{
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public int updateUserInformation(UserInformation userInformation) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update_user_details_based_on_id);
			
			ps.setString(1, userInformation.getFirstName());
			ps.setString(2, userInformation.getLastName());
			ps.setString(3, userInformation.getEmailId());
			ps.setLong(4, userInformation.getMobileNumber());
			ps.setString(5, userInformation.getQualification());
			ps.setDouble(6, userInformation.getPercentage());
			ps.setInt(7, userInformation.getId());
			
			return ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	@Override
	public int deleteuserInformation(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(delete_user_details_based_on_id);
			ps.setInt(1, id);
			
			return ps.executeUpdate();
			
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}