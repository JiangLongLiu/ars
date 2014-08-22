package com.liujl.service;
public class PersonServiceBean {
	private String user;
	
	public PersonServiceBean() {
	}
	public PersonServiceBean(String user) {
		this.user = user;
	}
	public void save() {
		System.out.println("user= "+user);
	}
	public String getUser() {
		return user;
	}
}
