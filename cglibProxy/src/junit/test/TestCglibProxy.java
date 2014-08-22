package junit.test;

import org.junit.Test;

import com.liujl.cglibproxy.CglibProxy;
import com.liujl.service.PersonServiceBean;

public class TestCglibProxy {

	@Test
	public void testCglibProxy() {
		CglibProxy proxy=new CglibProxy();
		PersonServiceBean bean=(PersonServiceBean)proxy.createProxyObject(new PersonServiceBean("cglib动态代理，不需要实现接口"));
		bean.save();
	}

}
