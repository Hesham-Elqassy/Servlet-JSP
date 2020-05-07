package com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.dao.ProductsDAO;
import com.dao.ProductsDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.entity.Product;
import com.service.UsersService;

@WebServlet("/AdminProductsController")
@MultipartConfig(maxFileSize =20000000)


public class AdminProductsController extends HttpServlet {
	List<Product> productsList;
	private static final long serialVersionUID = 1L;

	ProductsDAO productsDAO = null;
	UsersService userService = new UsersService();

	Product product = new Product();

	public AdminProductsController() {

		productsDAO = new ProductsDAOImpl();

	}
	
	PrintWriter out ;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType( "image/png" );
		
		
//		response.setContentType("text/html;charset=UTF-8");
//		out= response.getWriter();
		
		
		System.out.println("head of Admin products controller");
		

		String action = request.getParameter("action");
		
		System.out.println("top of admin product controller"+action);

		String newProductName = request.getParameter("newProductName");
		String newProductPrice = request.getParameter("newProductPrice");
		String newProductQuantaty = request.getParameter("newProductQuantaty");
		String newProductDescription = request.getParameter("newProductDescription");
		

		// Delte Action Handler in main form
		if ("DeleteProduct".equals(action)) {
			// get id of selected row
			int newProductId = Integer.parseInt(request.getParameter("pid"));

			// call delete method with passing the deleteid
			productsDAO.deleteProduct(newProductId);

			request.setAttribute("message", "Row Is Successfully Deleted ");
			
			System.out.println("iside delete BTN if true in admin products controller");
			System.out.println("inside delte"+action);

		}
		
		
		// Handle Review Button Action In Main Form
		if ("ReviewOfProduct".equals(action)) {
			// get id of selected row
			int pID = Integer.parseInt(request.getParameter("pid"));

			// call Get Product Review By Product ID method 
			productsDAO.getProductReviewbyProductId(pID);

			
			
			System.out.println("iside Review BTN if true in admin products controller");
			System.out.println("inside Review"+action);

		}
		
		
		

		// handle save button in second form
		if ("Save-Product".equals(action)) {

			// get all data from reuest scope in edite form , that passed
			// from
			// main form
			int newProductId = Integer.parseInt(request.getParameter("newProductId"));
			int NProductQuantity =Integer.parseInt(newProductQuantaty);
			int NProductPrice = Integer.parseInt(newProductPrice);

			
			System.out.println(action);
			if (true) {
				// call update method using DAO instance
				productsDAO.updateProduct(newProductId, newProductName,NProductQuantity ,NProductPrice ,
						newProductDescription);
				request.setAttribute("message", "Row IS Updated Succssesfully ");
				
				System.out.println("iside update BTN if true in admin products controller");
				
				
				System.out.println("inside save product"+action);
			} else {

				request.setAttribute("message", "you must fill all data ");

				papulateProductsList(request, response);
			}
		}

		
		// handel add btn
		if ("Add-Product".equals(action)) {

			Part image = request.getPart("newProductImage");
			
			InputStream is = image.getInputStream();
			System.out.println("done*******************************");
			// call addUsers Method in Servive
			boolean rs = productsDAO.addProduct(newProductName, Integer.parseInt(newProductPrice), Integer.parseInt(newProductQuantaty),
					newProductDescription, is);

			if (rs == true) {
				request.setAttribute("message", " data is added successfully ");
				// papulateUsersList(request, response);
				
				System.out.println("inside add product"+action);
				
				
				System.out.println("if add BTn true in admin producst controller");

			} else {
				request.setAttribute("message", "You must fill all data");
				// papulateUserssList(request, response);

			}

		}
		
		papulateProductsList(request, response);

		System.out.println("bottom of Admin products controller");
		
		System.out.println("end of admin product controller"+action);
	}

	protected void papulateProductsList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Product> productsListForAdmin = productsDAO.getProductsForUser();
		

		request.setAttribute("productsListForAdmin", productsListForAdmin);

		request.getRequestDispatcher("/AdminProductsDashBord.jsp").forward(request, response);

	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

}
}