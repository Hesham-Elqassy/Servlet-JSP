package com.entity;

public class OrderDetails {

	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	int product_id;
	int order_id;
	int quantity;
	float price;
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", product_id=" + product_id + ", order_id=" + order_id + ", quantity="
				+ quantity + ", price=" + price + "]";
	}

}
