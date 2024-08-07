package com.jsp.DAO;

import java.util.List;

import com.jsp.Model.UserInformation;

public interface UserDAO {
	int insertUserDetails(String email,String password);
	int updateUserDetails(UserInformation userInformation);
	int updateUserEducationDetails(UserInformation userInformation);
	int deleteUserDetails();
	List<UserInformation> getAllUserDetails();
	UserInformation getUserDetailsByUsingId(int id);
	int updateUserInformation(UserInformation userInformation);
	int deleteuserInformation(int id);
}