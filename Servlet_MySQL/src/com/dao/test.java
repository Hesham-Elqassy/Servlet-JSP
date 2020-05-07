package com.dao;

import com.entity.Order;
import com.entity.OrderDetails;
import com.entity.User;

public class test {

	public static void main(String[] args) {
		User user = new User();
		user.setId(4);
//		OrdersDAO o = new OrdersDAOImpl();
//		System.out.println(o.creatOrder(user));	
//		OrderDetails od = new OrderDetails();
//		od.setOrder_id(10);
//		od.setProduct_id(4);
//		od.setQuantity(3);
//		od.setPrice(45000);

//		OrderDetailsDAO dao =new OrderDetailsDAO();
//		System.out.println(dao.creatOrderDetails(od));
		
		Order order = new Order();
		order.setCustomer_id(6);
		
		ShoppingCartDAO dao = new ShippngCartDAOImpl();
		
//		order =	dao.creatOrder(user);
//		System.out.println(order.getId());
		
		
	}

}
