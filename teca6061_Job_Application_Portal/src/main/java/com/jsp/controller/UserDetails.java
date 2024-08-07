package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.DAO.UserDAO;
import com.jsp.DAO.UserDAOImp;
import com.jsp.Model.UserInformation;

@WebServlet("/userdetails")

public class UserDetails extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("userfirstname");
		String lastname = request.getParameter("userlastname");
		String mobilenumber = request.getParameter("usermobilenumber");
		String gender = request.getParameter("usergender");
		
		HttpSession session = request.getSession();
		String emailId = (String) session.getAttribute("emailId");
		String password = (String) session.getAttribute("pass");
		
		UserInformation userInformation =  new UserInformation();
		userInformation.setEmailId(emailId);
		userInformation.setFirstName(firstname);
		userInformation.setLastName(lastname);
		userInformation.setGender(gender);
		userInformation.setMobileNumber(Long.parseLong(mobilenumber));
		userInformation.setPassword(password);
		
		PrintWriter writer = response.getWriter();
		UserDAO userDAO = new UserDAOImp();
		
		if(emailId != null)
		{
			int details = userDAO.updateUserDetails(userInformation);
			
			if(details != 0)
			{
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("EducationDetails.html");
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("UserDetails.html");
				dispatcher.include(request, response);
				writer.println("<h1><center> Invalid Details </center></h1>");
			}
		}
		else
		{
			userDAO.deleteUserDetails();
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Registration.html");
			dispatcher.include(request, response);
			writer.println("<h1><center> Session TimeOut </center></h1>");
			
		}
		
		
	
	}
	
}
