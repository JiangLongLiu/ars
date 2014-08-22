package com.liujl.cglibproxy;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import com.liujl.service.PersonServiceBean;

public class CglibProxy implements MethodInterceptor{
	private Object targetObject;
	//���ɴ������
	public Object createProxyObject(Object targetObject){
		this.targetObject=targetObject;
		Enhancer enhancer=new Enhancer();
		//���������Ŀ���������
		enhancer.setSuperclass(this.targetObject.getClass());
		//���ûص�����,������ MethodInterceptor �ӿ�
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
