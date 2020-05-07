package com.entity;

import java.util.List;

public class Order {
	
	private int id ,customer_id,productid ,quantity ,total;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	String date;
	boolean status;
	//List<Product> products;
	

	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getTotal() {
		return total;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", productid=" + productid + ", quantity=" + quantity + ", total=" + total
				+ ", date=" + date + "]";
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
//	public List<Product> getProducts() {
//		return products;
//	}
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	

}
