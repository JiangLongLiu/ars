package com.liujl.impl;
import com.liujl.Hello;
public class HelloSpecker implements Hello {
	@Override
	public void hello(String say) {
		System.out.println("subClass----targetClass say : "+say);
	}
}
