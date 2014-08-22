package com.liujl.static_proxy;
import com.liujl.Hello;
import com.liujl.impl.HelloSpecker;

public class StaticProxy implements Hello{
	private HelloSpecker helloSpecker;
	
	public StaticProxy() {
	}
	public StaticProxy(HelloSpecker helloSpecker) {
		super();
		this.helloSpecker = helloSpecker;
	}

	@Override
	public void hello(String say) {
		System.out.println("执行前");
		helloSpecker.hello(say);
		System.out.println("执行后");
	}
}
