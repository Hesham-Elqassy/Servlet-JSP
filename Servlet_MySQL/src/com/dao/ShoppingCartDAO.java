package com.dao;

import java.util.List;

import com.entity.Product;

public interface ShoppingCartDAO {
	
	
	void addToShoppingCart (int userID, int productID);

	List<Product> getByUserId(int id);
	
	int deleteProductFromShoppingCart(int id);

	boolean updateProductQuantityInShoppingCart(int newProductId, int newProductQuantity);

}
