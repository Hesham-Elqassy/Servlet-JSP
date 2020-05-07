package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 System.out.println("head of logout controller");
		String action = request.getParameter("action");
		HttpSession session =request.getSession();
		if("Logout".equals(action))
		{
			session.removeAttribute("adminName");
			session.invalidate();
			request.setAttribute("message", "You Are Logining Out");
			response.sendRedirect("LoginController"); 
			
			 System.out.println("at bottom of if in logout controller");	
			
		}

		
		
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 System.out.println("head of logout controller");
		String action = request.getParameter("action");
		HttpSession session =request.getSession();
		if("Logout".equals(action))
		{
			session.removeAttribute("adminName");
			session.invalidate();
			request.setAttribute("message", "You Are Logining Out");
			response.sendRedirect("LoginController"); 
			
			 System.out.println("at bottom of if in logout controller");	

		}

	
	
	
	
	
	
	
	}

}
