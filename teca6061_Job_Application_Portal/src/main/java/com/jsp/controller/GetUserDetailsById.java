package com.jsp.controller;

import java.io.IOException;

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

@WebServlet("/getuserid")
public class GetUserDetailsById extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempId = request.getParameter("userId");
		int userId = Integer.parseInt(tempId);
		UserDAO userDAO = new UserDAOImp();
		
		UserInformation userInformation = userDAO.getUserDetailsByUsingId(userId);
		HttpSession session = request.getSession();
		session.setAttribute("userbyid", userInformation);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateUserDetails.jsp");
		dispatcher.forward(request, response);
		
	}
}
