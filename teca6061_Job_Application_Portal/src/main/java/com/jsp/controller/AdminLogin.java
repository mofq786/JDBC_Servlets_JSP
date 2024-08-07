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

import com.jsp.DAO.AdminDAO;
import com.jsp.DAO.AdminDAOImpl;
import com.jsp.DAO.UserDAO;
import com.jsp.DAO.UserDAOImp;
import com.jsp.Model.UserInformation;

@WebServlet("/adminlogin")

public class AdminLogin extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		
		AdminDAO adminDAO = new AdminDAOImpl();
		UserDAO userDAO = new UserDAOImp();
		HttpSession session = request.getSession();
		
		String name = adminDAO.adminLogin(emailId, password);
		
		if(name != null)
		{
			List<UserInformation> listUserInformation = userDAO.getAllUserDetails();
			session.setAttribute("listOfUsers", listUserInformation);
			for(UserInformation ui: listUserInformation)
			{
				System.out.println(ui);
			}
			session.setAttribute("name", name);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("AllUserDetails.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			session.setAttribute("msg", "Invalid Details");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Admin.jsp");
			dispatcher.forward(request, response);
		}
	}

}
