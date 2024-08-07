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
@WebServlet("/updateuserdetails")
public class UpdateUserDetails extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName= request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String emailId= request.getParameter("emailId");
		String mobileNumber= request.getParameter("mobileNumber");
		String qualification= request.getParameter("qualification");
		String percentage= request.getParameter("percentage");
		
		HttpSession session = request.getSession();
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		UserInformation userInformation = (UserInformation) session.getAttribute("userbyid");
		userInformation.setFirstName(firstName);
		userInformation.setLastName(lastName);
		userInformation.setEmailId(emailId);
		userInformation.setMobileNumber(Long.parseLong(mobileNumber));
		userInformation.setQualification(qualification);
		userInformation.setPercentage(Double.parseDouble(percentage));
		
		UserDAO userDAO = new UserDAOImp();
		
		if(userDAO.updateUserInformation(userInformation) != 0)
		{
			session.setAttribute("userbyid", userInformation);
			session.setAttribute("listOfUsers", userDAO.getAllUserDetails());
			RequestDispatcher dispatcher = request.getRequestDispatcher("AllUserDetails.jsp");
			dispatcher.include(request, response);
			writer.println("<center><h1>Details Updated Successfully</h21></center>");
			
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateUserDetails.jsp");
			dispatcher.include(request, response);
			writer.println("<center><h1>Details Updation Failed</h21></center>");
		}
		
	}
}
