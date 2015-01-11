package junit.test;

import org.junit.Test;

import com.liujl.cglibproxy.CglibProxy;
import com.liujl.service.PersonServiceBean;

public class TestCglibProxy {

	@Test
	public void testCglibProxy() {
		CglibProxy proxy=new CglibProxy();
		PersonServiceBean bean=(PersonServiceBean)proxy.createProxyObject(new PersonServiceBean("zhangsan"));
		bean.save();
		
		PersonServiceBean bean2=(PersonServiceBean)proxy.createProxyObject(new PersonServiceBean("lisi"));
		bean2.save();
	}

}
