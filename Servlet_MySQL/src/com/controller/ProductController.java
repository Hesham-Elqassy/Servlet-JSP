package com.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ShoppingCartDAO;
import com.dao.ShippngCartDAOImpl;
import com.dao.ProductsDAO;
import com.dao.ProductsDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.entity.Order;
import com.entity.OrderDetails;
import com.entity.Product;
import com.entity.User;
import com.service.UsersService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	List<Product> productsList = null;
	ProductsDAO productsDAO = null;
	UsersService userService = new UsersService();
	HttpSession session;

	Product product = new Product();

	List<OrderDetails> selectedProductsIDsList;
	OrderDetails od;

	public ProductController() {

		productsDAO = new ProductsDAOImpl();
		od = new OrderDetails();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession();

		String action = request.getParameter("action");
		
		if ("Add".equals(action))
		{
			String productID = request.getParameter("productID");
			String productRate = request.getParameter("productRate");
			String productComment= request.getParameter("productComment");
			
			System.out.println(productID+productRate+productComment);
			
			productsDAO.addProductRate(Integer.parseInt(productID), Integer.parseInt(productRate), productComment);
			
			
			
		}
		
		

		if ("AddtoCart".equals(action)) {
			String pid = request.getParameter("pid");
			User user = (User) session.getAttribute("User");
			int userID = user.getId();
			System.out.println("hiiiiiiiiiiiiiiiiiiiiii"+userID);
			ShoppingCartDAO dao = new ShippngCartDAOImpl();
			dao.addToShoppingCart(userID, Integer.parseInt(pid));
			// request.setAttribute("selectedProductsIDsList",
			// selectedProductsIDsList);
			response.sendRedirect("ProductController");
		} else {

			System.out.println("selectedProductsIDsList" + selectedProductsIDsList);

			System.out.println("head of product controller");
			List<Product> productsList = productsDAO.getProductsForUser();
			System.out.println(productsList);

			request.setAttribute("productsList", productsList);
			session.setAttribute("allProducts", productsList);
           
			
			
			request.getRequestDispatcher("/ProductsForUsers.jsp").forward(request, response);
			System.out.println("bottom of product controller");
			System.out.println(product.getProductName());

		}
	}

}
