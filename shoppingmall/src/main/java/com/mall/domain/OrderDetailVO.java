package com.mall.domain;

public class OrderDetailVO {
/*
   orderDetailsNum 	int 		NOT NULL AUTO_INCREMENT,
   orderId 			varchar(50) NOT NULL,
   gdsNum 			int 		NOT NULL,
   cartStock 		int 		NOT NULL, 

 */
	
	private int orderDetailsNum;
	private String orderId;
	private int gdsNum;
	private int cartStock;
	
	
	public int getOrderDetailsNum() {
		return orderDetailsNum;
	}
	public void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
}
