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
 * Servlet Filter implementation class UserLoginFilter
 */
//@WebFilter("/ProductController")
public class UserLoginFilter implements Filter {

  
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println(" in user login filter");
		
		HttpSession session = req.getSession();
		if (session.getAttribute("userName") == null) {

			req.setAttribute("message", "You must Login First");
			res.sendRedirect("LoginController");
			
			System.out.println(" after filter if inside user login");
		} else {
			System.out.println("  else true inside user login filter ");
			
			chain.doFilter(request, response);
		
		}
		
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
