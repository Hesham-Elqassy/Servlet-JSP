package com.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.Part;

import com.entity.Product;
import com.mysql.jdbc.PreparedStatement;
import com.util.MyConnectionProvider;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
 

public class ProductsDAOImpl implements ProductsDAO {

	Product product = null;

	@Override
	public int deleteProduct(int id) {

		int flag = 0;
		PreparedStatement ps = null;
		try {
			// sql query will be executed
			String sql = "delete from products where id= ?";

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
	public boolean updateProduct(int newProductId, String newProductName, int newProductQuantity, int newProductPrice,
			String newProductDescription) {

		if (newProductName != "" && newProductDescription != "") {
			PreparedStatement ps = null;
			try {
				// sql query will be executed
				String sql = "UPDATE products SET productName = ?, productQuantity = ?, productPrice = ?, productDescription = ? WHERE id = ?";

				// execute query and get result of query
				ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
				// assign parameters values instead of (?) in query
				ps.setString(1, newProductName);
				ps.setInt(2, newProductQuantity);
				ps.setInt(3, newProductPrice);
				ps.setString(4, newProductDescription);
				ps.setInt(5, newProductId);

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

	@Override
	public boolean addProduct(String newProductName, int newProductPrice, int newProductQuantaty,
			String newProductDescription, InputStream is) {

		if (newProductName != "" && newProductDescription != "") {
			// MyConnectionProvider ob=new MyConnectionProvider();
			String sql = "INSERT INTO products (productName, productQuantity, productPrice,productDescription,image) values(?,?,?,?,?)";
			PreparedStatement ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
			try {

				//InputStream is = image.getInputStream();
				
				// assign parameters values instead of (?) in query
				ps.setString(1, newProductName);
				ps.setInt(2, newProductPrice);
				ps.setInt(3, newProductQuantaty);
				ps.setString(4, newProductDescription);
				ps.setBlob(5, is);

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

			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<Product> getProductsForUser() {

		List<Product> list = null;
		PreparedStatement ps = null;
		try {
			// ob=new MyConnectionProvider();
			list = new ArrayList<Product>();

			String sql ="select * from products";
			
					//"select p.id, p.productName, p.productPrice, pv.rate, pv.comment from products p, product_review pv INNER JOIN product_review  ON pv.pid=p.id GROUP BY p.id       
					
					ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);

			ResultSet rs = ps.executeQuery();

			
			
			
			
			while (rs.next()) {
				product = new Product();
				
				
			
//				 Blob blob = rs.getBlob("image");
//                 
//	                InputStream inputStream = blob.getBinaryStream();
//	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	                byte[] buffer = new byte[4096];
//	                int bytesRead = -1;
//	                 
//	                while ((bytesRead = inputStream.read(buffer)) != -1) {
//	                    outputStream.write(buffer, 0, bytesRead);                  
//	                }
//	                 
//	                byte[] imageBytes = outputStream.toByteArray();
//	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//	                 
//	                 
//	                inputStream.close();
//	                outputStream.close();
//				
				
				
			    product.setProductId(rs.getInt(1));
			//	product.setImage(base64Image);
				//product.setImage(rs.getBlob("image"));
				//product.setImage(rs.getBlob(2));
				product.setProductName(rs.getString(3));
				product.setProductQuantity(rs.getInt(4));
				product.setProductPrice(rs.getInt(5));
				product.setProductDescription(rs.getString(6));
				//product.setRate(rs.getString(4));
			   //	product.setComment(rs.getString(5));
				
				
				
				
				
				
				list.add(product);
			}

		}

		catch (Exception e) {
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

		return list;

	}

	@Override
	public List<Product> getProductsForUserShoppingCartByID(List<Integer> selectedProductsIDs) {

		List<Product> list = null;
		PreparedStatement ps = null;
		try {
			// ob=new MyConnectionProvider();
			list = new ArrayList<Product>();

			// String sql = "select * from products where id IN";
			// PreparedStatement ps = (PreparedStatement)
			// MyConnectionProvider.getPreparedStatement(sql);

			StringBuilder sql = new StringBuilder("select * from products where id IN(");
			Object[] data = selectedProductsIDs.toArray();

			for (int i = 0; i < data.length; i++) {
				sql.append("?,");
			}
			// Delete the last comma
			sql.delete(sql.length() - 1, sql.length());
			sql.append(")");

			// Assign prepared statement parameters
			ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql.toString());

			for (int i = 0; i < data.length; i++) {
				ps.setInt(i + 1, (int) data[i]);
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				product = new Product();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductQuantity(rs.getInt(3));
				product.setProductPrice(rs.getInt(4));
				product.setProductDescription(rs.getString(5));

				list.add(product);
			}

		}

		catch (Exception e) {
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

		return list;

	}

	@Override
	public boolean addProductRate(int productID, int productRate, String productComment) {
		boolean f= false;
		
        
		PreparedStatement ps = null;
		try {
			// sql query will be executed
			String sql = "insert into product_review (pid, rate, comment) values (?,?,?)";

			// execute query and get result of query
			ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
			// assign parameters values instead of (?) in query
			ps.setInt(1, productID);
			ps.setInt(2, productRate);
			ps.setString(3, productComment);
			
			

			// execute update query
			ps.executeUpdate();
			f=true;
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
	
		return f;
	

		
	}

	@Override
	public List<Review> getProductReviewbyProductId(int pID) {
		// TODO Auto-generated method stub
		return null;
	}

	
		
		
		
		
		
	

}
