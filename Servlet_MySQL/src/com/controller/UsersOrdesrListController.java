package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.entity.Order;
import com.entity.Product;
import com.entity.User;
import com.service.UsersService;

/**
 * Servlet implementation class UsersOrdesrListController
 */
@WebServlet("/UsersOrdesrListController")
public class UsersOrdesrListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	UserDAO userDAO = null;
	UsersService userService = new UsersService();
	User user = new User();
	Order order = new Order();

	public UsersOrdesrListController() {

		userDAO = new UserDAOImpl();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
         String userID = request.getParameter("userID");
		
		
		List<Product> userOrderProductsList =userDAO.getUserOrderProductsList(Integer.parseInt(userID));
		
		System.out.println("==========User Orders Products list "+userOrderProductsList);

		request.setAttribute("userOrderProductsList", userOrderProductsList);

		//request.getRequestDispatcher("/UserOrdersListDashBord.jsp").forward(request, response);
		
		
		
		
	
		List<Order> userOrderInfoList =userDAO.getUserOrdersInfoList(Integer.parseInt(userID));
		
		System.out.println("========== userOrderInfoList  "+userOrderInfoList);

		request.setAttribute("userOrderInfoList", userOrderInfoList);

		request.getRequestDispatcher("/UserOrdersListDashBord.jsp").forward(request, response);
		
		
		
		
//		papulateUserOrdersInfoList(request,response);
//		papulateProductsIDs(request,response);
		
		
		
	}
	
	protected void papulateUserOrdersInfoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		HttpSession session = request.getSession();
//		String userID = (String) session.getAttribute("sUID");
		
		
		

	}
	
	
	

	protected void papulateProductsIDs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	
}
