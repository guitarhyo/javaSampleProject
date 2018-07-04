package com.wsdl.model;

public class  ResRet {
	private String user;
	private String userName;
	private String user_addr;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	@Override
	public String toString() {
		return "ResRet [user=" + user + ", userName=" + userName + ", user_addr=" + user_addr + "]";
	}

}
