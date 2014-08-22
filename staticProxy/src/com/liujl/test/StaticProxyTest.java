package com.liujl.test;
import org.junit.Test;
import com.liujl.Hello;
import com.liujl.impl.HelloSpecker;
import com.liujl.static_proxy.StaticProxy;

public class StaticProxyTest {

	@Test
	public void test() {
		Hello hello=new StaticProxy(new HelloSpecker());
		hello.hello("hello123");
	}
}
