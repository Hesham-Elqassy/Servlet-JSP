package com.filters;

import java.io.IOException;
import java.util.HashSet;

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
 * Servlet Filter implementation class AdminProductsFilter
 */
@WebFilter("*")
public class AdminProductsFilter implements Filter {

	HashSet<String> adminPages;
	HashSet<String> userPages;

	public void init(FilterConfig fConfig) throws ServletException {
		adminPages = new HashSet<>();
		userPages = new HashSet<>();
		adminPages.add("/AdminProductsController");
		adminPages.add("/AdminUsersController");
		userPages.add("/UsersInfoController");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		System.out.println(" in main filter" + req.getServletPath());

		HttpSession session = req.getSession();
		if (adminPages.contains(req.getServletPath())) {
			// if admin page
			if (session.getAttribute("adminName") != null) {
				// admin
				System.out.println(" inside filter else true to Admin Products controller  ");

				chain.doFilter(request, response);
			} else if (session.getAttribute("userName") != null) {
				res.getWriter().write("403 NOT ALLOWED");
			} else {
				res.sendRedirect("LoginController");
			}
		} else if (userPages.contains(req.getServletPath())) {
			if (session.getAttribute("userName") != null) {
				chain.doFilter(request, response);
			} else {
				res.getWriter().write("403 NOT ALLOWED");
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {

	}

}
