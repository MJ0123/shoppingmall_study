package com.mall.domain;

public class CartListVO {
/*
    cartNum     int          not null,
    userId      varchar(50)  not null,
    gdsNum      int          not null,
    cartStock   int          not null,
    addDate     datetime     default current_timestamp,
    primary key(cartNum, userId) 

 */
	
	private String cartNum;
	private String userId;
	private String gdsNum;
	private String cartStock;
	private String addDate;
	
	private int num;
	private String gdsName;
	private int gdsPrice;
	private String gdsThumbImg;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getGdsName() {
		return gdsName;
	}
	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public String getGdsThumbImg() {
		return gdsThumbImg;
	}
	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}
	public String getCartNum() {
		return cartNum;
	}
	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(String gdsNum) {
		this.gdsNum = gdsNum;
	}
	public String getCartStock() {
		return cartStock;
	}
	public void setCartStock(String cartStock) {
		this.cartStock = cartStock;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	
}
