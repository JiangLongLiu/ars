package com.liujl.cglibproxy;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import com.liujl.service.PersonServiceBean;

public class CglibProxy implements MethodInterceptor{
	private Object targetObject;
	//生成代理对象
	public Object createProxyObject(Object targetObject){
		this.targetObject=targetObject;
		Enhancer enhancer=new Enhancer();
		//代理对象是目标类的子类
		enhancer.setSuperclass(this.targetObject.getClass());
		//设置回调方法,须事先 MethodInterceptor 接口
		enhancer.setCallback(this);
		return enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		Object result=null;
		PersonServiceBean bean=(PersonServiceBean)this.targetObject;
		if(bean.getUser()!=null){
			result=method.invoke(this.targetObject, args);
		}
		return result;
	}
}
