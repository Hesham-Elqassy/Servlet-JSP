package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.entity.Order;
import com.entity.Product;
import com.entity.User;
import com.mysql.jdbc.PreparedStatement;
import com.util.MyConnectionProvider;
import com.dao.UserDAO;
import java.sql.*;

public class UserDAOImpl implements UserDAO {
	// MyConnectionProvider ob=null;
	User user = null;
	Product product = null;
	Order order = null;

	@Override
	public List<User> getUsers() {

		List<User> list = null;
		PreparedStatement ps=null;
		try {
			// ob=new MyConnectionProvider();
			list = new ArrayList<User>();

			String sql = "select * from users";
			 ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAdminstatus(rs.getString(4));

				list.add(user);
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
	public int deleteUser(int id) {
		int flag = 0;
		PreparedStatement ps=null;
		try {
			// sql query will be executed
			String sql = "delete from users where id= ?";

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
	public boolean updateUser(int editeid, String newusername, String newpassword, String newadminstatus) {

		if (newusername != "" && newpassword != "" && newadminstatus != "") {
			PreparedStatement ps=null;
			try {
				// sql query will be executed
				String sql = "UPDATE users SET username = ?, password = ?, ADMINS = ? WHERE id = ?";

				// execute query and get result of query
				 ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
				// assign parameters values instead of (?) in query
				ps.setString(1, newusername);
				ps.setString(2, newpassword);
				ps.setString(3, newadminstatus);
				ps.setInt(4, editeid);

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
	public User loginUser(String loginUserName, String loginPassword) {
		User user = null;

		// MyConnectionProvider ob2=new MyConnectionProvider();
		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
		// open connection and get PreparedStatement object
		PreparedStatement stmt = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);

		try {

			// assign parameters values instead of (?) in query
			stmt.setString(1, loginUserName);
			stmt.setString(2, loginPassword);
			// execute query and get result of query
			ResultSet result = stmt.executeQuery();
			// if result not empty then user exists

			if (!result.next()) {
				return user;

			} else {
				user = new User(result.getInt(1), result.getString(2), null, result.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null) {
					stmt.getConnection().close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("in daooooooooooooooooooooooo "+ user);
		return user;

	}

	@Override
	public boolean addUser(String username, String password, String adminstatus) {
		if (username != "" && password != "" && adminstatus != "") {
			// MyConnectionProvider ob=new MyConnectionProvider();
			String sql = "INSERT INTO users (username, password, ADMINS) values(?,?,?)";
			PreparedStatement ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
			try {

				// assign parameters values instead of (?) in query
				ps.setString(1, username);
				ps.setString(2, password);
				ps.setString(3, adminstatus);

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
	public List<User> getUserInfoList(String userName) {

		List<User> userList = null;
		PreparedStatement ps=null;
		try {
			userList = new ArrayList<User>();

			String sql = "select * from users where username = ? ";
			 ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);

			ps.setString(1, userName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));

				userList.add(user);
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

		return userList;
	}

	@Override
	public boolean updateSingleUserInfo(int editedid, String newusername, String newpassword) {

		if (newusername != "" && newpassword != "") {
			PreparedStatement ps=null;
			try {
				// sql query will be executed
				String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";

				// execute query and get result of query
				 ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
				// assign parameters values instead of (?) in query
				ps.setString(1, newusername);
				ps.setString(2, newpassword);
				ps.setInt(3, editedid);

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
	public List<Order> getUserOrdersInfoList(int uid) {

		List<Integer> ordersIDsList = getOrdersIdsByUserID(uid);
		System.out.println("ordersIDsList/////" + ordersIDsList);

		List<Order> listOfOrders = null;
		PreparedStatement ps=null;
		try {

			listOfOrders = new ArrayList<Order>();

			StringBuilder sql = new StringBuilder(
					"SELECT oi.order_id, oi.product_id ,o.date,oi.quantity,oi.price FROM orders o JOIN order_details oi ON o.id = oi.order_id where o.customer_id = ?");

			// Object[] data = ordersIDsList.toArray();
			//
			// for (int i = 0; i < data.length; i++) {
			// sql.append("?,");
			// }
			// // Delete the last comma
			// sql.delete(sql.length()-1, sql.length());
			// sql.append(")");

			// Assign prepared statement parameters
			 ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql.toString());

			// for (int i = 0; i < data.length; i++) {
			// ps.setInt(i+1, (int) data[i]);
			// }

			ps.setInt(1, uid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				order = new Order();
				order.setId(rs.getInt(1));
				order.setProductid(rs.getInt(2));
				order.setDate(rs.getString(3));
				order.setQuantity(rs.getInt(4));
				order.setTotal(rs.getInt(5));

				listOfOrders.add(order);
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

		return listOfOrders;

	}

	@Override
	public List<Integer> getOrdersIdsByUserID(int UserID) {

		List<Integer> ordersIDsList = new ArrayList<>();
		PreparedStatement ps=null;
		try {

			String sql = "select id from orders where customer_id = ?";
			 ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);

			ps.setInt(1, UserID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ordersIDsList.add(rs.getInt(1));
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

		return ordersIDsList;

	}

	@Override
	public List<Integer> getProductsIDsByOrdersIDs(List<Integer> ordersIDsList) {

		// int orderId = getOrderIdByUserID(orderID);

		List<Integer> list = new ArrayList<>();
		PreparedStatement ps=null;
		try {

			StringBuilder sql = new StringBuilder("select product_id from order_details where order_id IN(");
			Object[] data = ordersIDsList.toArray();

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

			// String sql="select product_id from order_details where order_id =
			// ?";

			// PreparedStatement ps = (PreparedStatement)
			// MyConnectionProvider.getPreparedStatement(sql);

			// ps.setInt(1, orderID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ArrayList<Integer> productsIDsList = new ArrayList<>();
				productsIDsList.add(rs.getInt(1));

				list.addAll(productsIDsList);
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

		return list;
	}

	@Override
	public List<Product> getUserOrderProductsList(int userID) {

		System.out.println("-----------------userid inside getuserorderproductslist in DAO" + userID);
		List<Integer> ordersIDsList = getOrdersIdsByUserID(userID);
		System.out.println("-----------------orderid inside getuserorderproductslist in DAO" + ordersIDsList);

		ArrayList<Integer> productsIDsList = (ArrayList<Integer>) getProductsIDsByOrdersIDs(ordersIDsList);
		System.out.println("*************products ids list form UserDAOImpl" + productsIDsList);

		List<Product> userOrderProductsList = null;
		userOrderProductsList = new ArrayList<Product>();
		PreparedStatement ps=null;
		try {

			StringBuilder sql = new StringBuilder("select * from products where id IN (");
			Object[] data = productsIDsList.toArray();

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

			// String sql = "select * from products where id IN (?)";
			// PreparedStatement ps = (PreparedStatement)
			// MyConnectionProvider.getPreparedStatement(sql);
			//
			//
			// Object[] data =productsIDsList.toArray();
			// java.sql.Array tagIdsInArray =
			// MyConnectionProvider.connection.createArrayOf("integer", data);
			// ps.setArray(1, tagIdsInArray);
			//

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				product = new Product();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(3));
				product.setProductQuantity(rs.getInt(4));
				product.setProductPrice(rs.getInt(5));
				product.setProductDescription(rs.getString(6));

				userOrderProductsList.add(product);
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

		return userOrderProductsList;
	}

}
