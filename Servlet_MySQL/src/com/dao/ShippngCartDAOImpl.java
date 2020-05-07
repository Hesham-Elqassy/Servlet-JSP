package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.Order;
import com.entity.Product;
import com.entity.User;
import com.mysql.jdbc.PreparedStatement;
import com.util.MyConnectionProvider;

public class ShippngCartDAOImpl implements ShoppingCartDAO {
	// static SimpleDateFormat smdf=new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");

	@Override
	public void addToShoppingCart(int userID, int productID) {
		String sql = "INSERT INTO shoppingcart (customer_id,product_id,quantity) values(?,?,?)";
		PreparedStatement ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
		try {
			// assign parameters values instead of (?) in query
			int quantity = 1;
			ps.setInt(1, userID);
			ps.setInt(2, productID);
			ps.setInt(3, quantity);
			// execute update query
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.getConnection().close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Product> getByUserId(int id) {
		List<Product> productsList = new ArrayList<Product>();
		String sql = "Select * from  products  p inner join shoppingcart sh on sh.product_id=p.id where sh.customer_id = ?";
		PreparedStatement ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
		try {
			// assign parameters values instead of (?) in query
			ps.setInt(1, id);
			// execute update query
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Product p = new Product();
				p.setProductId(rs.getInt("id"));
				p.setProductName(rs.getString("productName"));
				p.setProductDescription(rs.getString("productDescription"));
			    p.setProductPrice(rs.getInt("productPrice"));
			  //p.setProductQuantity(rs.getInt("	productQuantity"));
				productsList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.getConnection().close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return productsList;
	}

	@Override
	public int deleteProductFromShoppingCart(int id) {
		
		
		int flag = 0;
		PreparedStatement ps = null;
		try {
			// sql query will be executed
			String sql = "delete from shoppingcart where id= ?";

			// execute query and get result of query
			ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
			// assign parameters values instead of (?) in query
			ps.setInt(1, id);

			// execute update query
			ps.executeUpdate();

			flag = 1;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not Exist");
		} finally {

			try {
				if (ps != null) {
					ps.getConnection().close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;

		
		
		
		
	}

	@Override
	public boolean updateProductQuantityInShoppingCart(int newProductId, int newProductQuantity) {
		
		
		if (newProductId !=0) {
			PreparedStatement ps = null;
			try {
				// sql query will be executed
				String sql = "UPDATE shoppingcart SET quantity = ? WHERE id = ?";

				// execute query and get result of query
				ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
				// assign parameters values instead of (?) in query
				
				ps.setInt(1, newProductQuantity);
				
				ps.setInt(2, newProductId);

				// execute update query
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (ps != null) {
						ps.getConnection().close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			return false;
		}

		return true;

		
		
		
	}

}
