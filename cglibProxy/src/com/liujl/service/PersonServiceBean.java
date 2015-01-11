package com.liujl.service;
public class PersonServiceBean {
	private String user;
	
	public PersonServiceBean() {
	}
	public PersonServiceBean(String user) {
		this.user = user;
	}
	public void save() {
		if("zhangsan".equals(this.user)){
			System.out.println("user= "+user);
		}else{
			System.out.println(this.user+" haven't the enough privilege.");
		}
		
	}
	public String getUser() {
		return user;
	}
}
