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

@WebServlet("/otpvalidation")

public class OTPValidation extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp = request.getParameter("otp");
		int userOTP;
		if(otp == null || otp.length()==0)
		{
			userOTP = 0;
		}
		else
		{
			userOTP = Integer.parseInt(otp);
		}
		
		HttpSession session = request.getSession();
		Object sessionOTP = session.getAttribute("otp");
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		if(sessionOTP != null)
		{
			int validOTP = (int) sessionOTP;
			
			if(userOTP == validOTP)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("Successful.html");
				dispatcher.include(request, response);
			}
			else
			{
				int number = new Random().nextInt(10000);
				if(number < 1000)
				{
					number += 1000;
				}
				session.setAttribute("otp", number);
				writer.println("<h1>Yours OTP is "+number+"</h1>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("OTP.html");
				dispatcher.include(request, response);
				
			}
		}
		else
		{
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("Registration.html");
			dispatcher.include(request, response);
			writer.println("<h1><center> Session TimeOut </center></h1>");		
		} 
		
		
	}
}
