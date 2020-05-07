package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductsDAO;
import com.dao.ProductsDAOImpl;
import com.dao.ShippngCartDAOImpl;
import com.dao.ShoppingCartDAO;
import com.entity.Product;
import com.entity.User;

@WebServlet("/UserShoppingCartController")
public class UserShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Product> productsList = null;
	ShoppingCartDAO cartDAOImpl = null;

	Product product = new Product();

	public UserShoppingCartController() {

		cartDAOImpl = new ShippngCartDAOImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("head of Shopping Cart controller");
		

		

		String action = request.getParameter("action");
		

		String newProductName = request.getParameter("newProductName");
		String newProductPrice = request.getParameter("newProductPrice");
		String newProductQuantaty = request.getParameter("newProductQuantaty");
		
		
		
		// Delte Action Handler in main form
				if ("DeleteProduct".equals(action)) {
					// get id of selected row
					int newProductId = Integer.parseInt(request.getParameter("pid"));

					// call delete method with passing the deleteid
					cartDAOImpl.deleteProductFromShoppingCart(newProductId);

					request.setAttribute("message", "Row Is Successfully Deleted ");
					
					System.out.println("iside delete BTN if true in admin products controller");
					System.out.println("inside delte"+action);

				}
				
				
				
				
				
				if ("Save-Product".equals(action) && ! newProductQuantaty.equals("") ) {

					// get all data from reuest scope in edite form , that passed
					// from
					// main form
					int newProductId = Integer.parseInt(request.getParameter("newProductId"));
					int NProductQuantity =Integer.parseInt(newProductQuantaty);
					

					
					System.out.println(action);
					if (true) {
						
						
						// call update method using DAO instance
						cartDAOImpl.updateProductQuantityInShoppingCart(newProductId, NProductQuantity);
						request.setAttribute("message", "Row IS Updated Succssesfully ");
						
						System.out.println("iside update BTN if true in admin products controller");
						
						
						System.out.println("inside save product"+action);
					} else {

						request.setAttribute("message", "you must fill all data ");

					
					}
				}

		
		
		
		
		
		
		
		

		HttpSession session = request.getSession();
		User user= (User) session.getAttribute("User");
		System.out.println(user);
		
		if (user != null) {
			
			ShoppingCartDAO dao=new ShippngCartDAOImpl();
			List<Product> byUserId = dao.getByUserId(user.getId());
			System.out.println(byUserId);
			request.setAttribute("userCartList", byUserId);
			request.getRequestDispatcher("/UserShoppingCartDashBord.jsp").forward(request, response);
			
			System.out.println("btom of Shopping Cart controller");

		}else {
			request.getRequestDispatcher("/UserShoppingCartDashBord.jsp").forward(request, response);
			request.setAttribute("message", "Cart Is Empty");
		}


//		System.out.println(userName);
//		List<OrderDetails> selectedProductsIDs = (List<OrderDetails>) session
//				.getAttribute("shoppingCartIDs" + userName);
//
//		// List<Integer> selectedProductsIDs = (List<Integer>)
//		// session.getAttribute("shoppingCartIDs" + userName);
//
//		if (selectedProductsIDs.size() != 0) {
//			// List<Product> productsList =
//			// productsDAO.getProductsForUserShoppingCartByID(selectedProductsIDs);
//			System.out.println(selectedProductsIDs);
//
//			request.setAttribute("productsList", selectedProductsIDs);
//			HttpSession httpSession = request.getSession();
//
//			List<Product> lp = (List<Product>) session.getAttribute("allProducts");
//			request.getRequestDispatcher("/UserShoppingCartDashBord.jsp").forward(request, response);
//			List<Item> ls = new ArrayList<Item>();
//
//			for (int i = 0; i < selectedProductsIDs.size(); i++) {
//				ls.get(i).setOd(selectedProductsIDs.get(i));
//				for (int j = 0; j < lp.size(); j++) {
//					if (ls.get(i).getOd().getProduct_id() == lp.get(j).getProductId())
//						ls.get(i).setPname(lp.get(j).getProductName());
//
//				}
//			}
//			System.out.println("dfghjkjhg" + ls.get(0).getPname());
//
//			System.out.println("bottom of Shopping Cart controller");
//
//		} else {
//			request.getRequestDispatcher("/UserShoppingCartDashBord.jsp").forward(request, response);
//			request.setAttribute("message", "Cart Is Empty");
//		}

	}

}
