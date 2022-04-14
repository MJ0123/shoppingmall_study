package com.mall.domain;

public class CategoryVO {
/*
 	`cateName` 		varchar(20) NOT NULL,
  	`cateCode` 		varchar(30) NOT NULL,
  	`cateCodeRef` 	varchar(30) NULL,
 */
	
	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private int level;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateCodeRef() {
		return cateCodeRef;
	}
	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}
}
