package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entity.*;

import com.service.UsersService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	UsersService userService = new UsersService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get form paremeters
		String action = request.getParameter("action");
		String loginUserName = request.getParameter("loginUserName");
		String loginPassword = request.getParameter("loginPassword");

		System.out.println("head of login controller");
		// handle login forn btn
		if ("Login".equals(action)) {

			// call loginCheck method in service layer
			User user = new User();
			user = userService.loginCheck(loginUserName, loginPassword);
			System.out.println("in login controler---------------------------"+user);
			if (user != null) {
				HttpSession session = request.getSession();

				session.setAttribute("User", user);
				if (user.getAdminstatus().equals("yes")) {
					session.setAttribute("adminName", user.getUsername());
					response.sendRedirect("AdminUsersController");
					System.out.println(" login controller if true to users controller");

					// request.getRequestDispatcher("/CC").forward(request,
					// response);
				}
				else if (user.getAdminstatus().equals("no")) {
					response.sendRedirect("ProductController");
					session.setAttribute("userName", user.getUsername());

					System.out.println(" login controller if true to product controller");
				} else {

					request.setAttribute("message", "You Are Not Allowed ");
					// request.getRequestDispatcher("/LoginController").forward(request,
					// response);

					// response.sendRedirect("LoginController");

					System.out.println(user.getAdminstatus());
					System.out.println(" login controller if false");
					request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
					// response.sendRedirect("LoginForm.jsp");
				}

			}
		} else {
			throw new RuntimeException("Not supported");
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		// get form paremeters
//		String action = request.getParameter("action");
//		String loginUserName = request.getParameter("loginUserName");
//		String loginPassword = request.getParameter("loginPassword");
//		int rs = userService.loginCheck(loginUserName, loginPassword);
//
//		HttpSession session = request.getSession();
//		if (session.getAttribute("adminName") == null && session.getAttribute("userName") == null) {
//
//			request.setAttribute("message", "You must Login First");
//			// response.sendRedirect("LoginController");
			request.getRequestDispatcher("/LoginForm.jsp").forward(request, response);
//
//		} else if (rs == 1 && session.getAttribute("adminName") != null) {
//
//			response.sendRedirect("AdminUsersController");
//
//		} else if (rs == 2 && session.getAttribute("userName") != null) {
//
//			response.sendRedirect("ProductController");
//		}

	}
}
