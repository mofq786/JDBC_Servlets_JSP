package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

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

@WebServlet("/educationdetails")

public class UserEducationDetails extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qualification = req.getParameter("Qualification");
		String percentage = req.getParameter("percentage");
		
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("emailId");
		String password = (String) session.getAttribute("pass");
		
		UserInformation userInformation = new UserInformation();
		userInformation.setEmailId(email);
		userInformation.setPassword(password);
		userInformation.setQualification(qualification);
		userInformation.setPercentage(Double.parseDouble(percentage));
		
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		
		UserDAO userDAO = new UserDAOImp();
		
		if(email != null)
		{
			int status = userDAO.updateUserEducationDetails(userInformation);
			if(status != 0)
			{
				Random random = new Random();
				int otp = random.nextInt(9999);
				if(otp < 1000)
				{
					otp += 1000;
				}
				session.setAttribute("otp", otp);
				
				writer.println("<h1><center>Yours OTP is "+otp+"</center></h1>");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("OTP.html");
				dispatcher.include(req, resp);
			}
			else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("EducationDetails.html");
				dispatcher.include(req, resp);
				writer.println("<h1><center> Invalid Data </center></h1>");
			}
		}
		else
		{
			userDAO.deleteUserDetails();
			RequestDispatcher dispatcher = 
					req.getRequestDispatcher("Registration.html");
			dispatcher.include(req, resp);
			writer.println("<h1><center> Session TimeOut </center></h1>");
			
		}
		
	}
	
}
