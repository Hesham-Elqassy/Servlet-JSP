package com.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.Part;

import com.entity.Product;

public interface ProductsDAO {

	int deleteProduct(int id);

	boolean updateProduct(int newProductId, String newProductName, int newProductQuantity, int newProductPrice,
			String newProductDescription);

	boolean addProduct(String newProductName, int newProductPrice, int newProductQuantaty,
			String newProductDescription, InputStream is);

	List<Product> getProductsForUser();

	List<Product> getProductsForUserShoppingCartByID(List<Integer> selectedProductsIDs);
	
	boolean addProductRate(int productID, int productRate, String productComment);

	List<Review> getProductReviewbyProductId(int pID);

}
