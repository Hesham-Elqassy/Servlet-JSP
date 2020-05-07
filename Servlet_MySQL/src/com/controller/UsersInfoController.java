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
import com.mysql.cj.Session;
import com.service.UsersService;

@WebServlet("/UsersInfoController")
public class UsersInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<User> list;

	UserDAO userDAO = null;
	UsersService userService = new UsersService();
	User user = new User();
	Order order = new Order();

	public UsersInfoController() {

		userDAO = new UserDAOImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		String newusername = request.getParameter("newusername");
		String newpassword = request.getParameter("newpassword");
		

		// handle save button in second form
		if ("Save".equals(action)) {

			// get all data from reuest scope in edite form , that passed
			// from
			// main form
			int editedid = Integer.parseInt(request.getParameter("editedid"));

			if (newusername != "" && newpassword != ""  && newpassword != null
					 && newusername != null) {

				// call update method using DAO instance
				userDAO.updateSingleUserInfo(editedid, newusername, newpassword);
				request.setAttribute("message", "Row IS Updated Succssesfully ");
			} else {

				request.setAttribute("message", "you must fill all data ");

				papulateUserInfoList(request, response);
			}
		}
		
		if("showUserOrders".equals(action))
		{
			String sUID  = request.getParameter("userID");
			
			response.sendRedirect("/UsersOrdesrListController");
		}
          
		papulateUserInfoList(request, response);
		

	}

	protected void papulateUserInfoList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		List<User> userInfoList = userDAO.getUserInfoList(userName);

		request.setAttribute("userInfoList", userInfoList);

		request.getRequestDispatcher("/UserInfoDashBord.jsp").forward(request, response);

	}
	
	
	
	
	
	

}
