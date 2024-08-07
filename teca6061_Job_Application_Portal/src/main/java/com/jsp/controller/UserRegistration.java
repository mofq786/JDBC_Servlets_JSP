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
@WebServlet("/registration")
public class UserRegistration extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email =  req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		session.setAttribute("emailId", email);
		session.setAttribute("pass", password);
		
		UserDAO obj = new UserDAOImp();
		int val = obj.insertUserDetails(email, password);
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		if(val !=0) {
			
			session.setMaxInactiveInterval(20);
			
			System.out.println("Registration successful");
			RequestDispatcher dispatcher = req.getRequestDispatcher("UserDetails.html");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Registration.html");
			dispatcher.include(req, resp);
			writer.println("<center><h1>Server 400</h1></center>");
		}
	}
}