package com.mall.domain;

import java.util.Date;

public class MemberVO {
	/*
 	userId		varchar(50)	not null,	
	userPw		varchar(100)not null,	
	userName	varchar(30)	not null,	
	userTell	varchar(20)	not null,	
	userAddr1	varchar(20)	not null,	
	userAddr2	varchar(50)	not null,	
	userAddr3	varchar(50)	not null,	
	regidate	datetime	default now(),	
	verify		int			default 0,
	*/
	private String userId;
	private String userPw;
	private String userName;
	private String userTell;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private Date regdate;
	private int verify;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTell() {
		return userTell;
	}
	public void setUserTell(String userTell) {
		this.userTell = userTell;
	}
	public String getUserAddr1() {
		return userAddr1;
	}
	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}
	public String getUserAddr2() {
		return userAddr2;
	}
	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	public String getUserAddr3() {
		return userAddr3;
	}
	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
}
