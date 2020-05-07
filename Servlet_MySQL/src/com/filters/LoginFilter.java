package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/LoginController")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
//		System.out.println("Login FIlter"+req.getSession().getAttribute("userName")+req.getSession().getAttribute("adminName"));
		if (req.getSession().getAttribute("userName") != null || req.getSession().getAttribute("adminName") != null) {
			res.sendRedirect("home");
		}else{
			chain.doFilter(request, response);
		}
	}

}
