package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/ACdminUsersController")
public class LoginFilterAdmin implements Filter {

	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println(" in login filter");
		
		HttpSession session = req.getSession();
		if (session.getAttribute("adminName") == null) {

			req.setAttribute("message", "You must Login First");
			res.sendRedirect("LoginController");
			
			System.out.println(" after filter if inside false");
		} else {
			System.out.println(" inside filter else true to users controller  ");
			
			chain.doFilter(request, response);
		
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
