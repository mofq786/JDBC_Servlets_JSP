package com.jsp.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/deleteuserdetails")
public class DeleteUserDetails extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempId = request.getParameter("userId");
		int userId = Integer.parseInt(tempId);
		UserDAO userDAO = new UserDAOImp();
		HttpSession session = request.getSession();

		int result = userDAO.deleteuserInformation(userId);
				
		if(result != 0)
		{
			
			session.setAttribute("listOfUsers", userDAO.getAllUserDetails());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("AllUserDetails.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("AllUserDetails.jsp");
			dispatcher.include(request, response);
		}
		
	}

}
