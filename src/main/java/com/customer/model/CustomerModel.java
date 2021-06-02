package com.customer.model;

import org.springframework.stereotype.Component;

@Component
public class CustomerModel {

	private int id;
	private String UserName;
	private boolean isAdmin;
	private boolean isUser;
	private String phoneNo;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean isUser() {
		return isUser;
	}
	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	public String isPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String isAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
