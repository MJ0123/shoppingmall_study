package com.mall.domain;

public class CartVO {
/*
    cartNum     int          not null,
    userId      varchar(50)  not null,
    gdsNum      int          not null,
    cartStock   int          not null,
    addDate     datetime     default current_timestamp,
    primary key(cartNum, userId) 

 */
	
	private int cartNum;
	private String userId;
	private int gdsNum;
	private int cartStock;
	private String addDate;
	
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
}
