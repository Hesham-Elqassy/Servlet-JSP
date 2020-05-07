package com.dao;

import java.sql.SQLException;
import com.entity.OrderDetails;
import com.mysql.jdbc.PreparedStatement;
import com.util.MyConnectionProvider;

public class OrderDetailsDAO {

	public boolean creatOrderDetails(OrderDetails od) {
		boolean rs = false;
		String sql = "INSERT INTO order_details (order_id,product_id,quantity,price) values(?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) MyConnectionProvider.getPreparedStatement(sql);
		try {
			
			ps.setInt(1, od.getOrder_id());
			ps.setInt(2, od.getProduct_id());
			ps.setInt(3, od.getQuantity());
			ps.setFloat(4, od.getPrice());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (ps != null) {
					ps.getConnection().close();
				}			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
}
