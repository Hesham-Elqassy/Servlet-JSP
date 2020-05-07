package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.entity.User;
import com.service.UsersService;

@WebServlet("/AdminUsersController")
public class AdminUsersController extends HttpServlet {

	List<User> list;
	private static final long serialVersionUID = 1L;

	UserDAO userDAO = null;
	UsersService userService = new UsersService();
	User user = new User();

	public AdminUsersController() {

		userDAO = new UserDAOImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		System.out.println(" head of Admin users controller");
		
			String action = request.getParameter("action");

			String newusername = request.getParameter("newusername");
			String newpassword = request.getParameter("newpassword");
			String newadminstatus = request.getParameter("newadminstatus");

			// Delte Action Handler in main form
			if ("delete".equals(action)) {
				// get id of selected row
				int deleteid = Integer.parseInt(request.getParameter("id"));

				// call delete method with passing the deleteid
				userDAO.deleteUser(deleteid);

				request.setAttribute("message", "Row Is Successfully Deleted ");

			}

			// handle save button in second form
			if ("Save".equals(action)) {

				// get all data from reuest scope in edite form , that passed
				// from
				// main form
				int editedid = Integer.parseInt(request.getParameter("editedid"));

				if (newusername != "" && newpassword != "" && newadminstatus != "" && newpassword != null
						&& newadminstatus != null && newusername != null) {
					
					// call update method using DAO instance
					userDAO.updateUser(editedid, newusername, newpassword, newadminstatus);
					request.setAttribute("message", "Row IS Updated Succssesfully ");
				} else {

					request.setAttribute("message", "you must fill all data ");

					papulateUsersList(request, response);
				}
			}

			// handel add btn
			if ("Add".equals(action)) {

				// call addUsers Method in Servive
				boolean rs = userService.addUserCheck(newusername, newpassword, newadminstatus);

				if (rs == true) {
					request.setAttribute("message", " data is added successfully ");
					// papulateUsersList(request, response);

				} else {
					request.setAttribute("message", "You must fill all data");
					// papulateUserssList(request, response);

				}

			}
			
			

			papulateUsersList(request, response);

		}



	// method for getting users List from database and pass it to
	// UsersDashBord.jsp
	protected void papulateUsersList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> list = userDAO.getUsers();

		request.setAttribute("list", list);

		request.getRequestDispatcher("/AdminDashBord.jsp").forward(request, response);
	}

}
