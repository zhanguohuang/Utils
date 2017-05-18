package org.zhan.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author zgh
 * @description 可实现任何接口
 */
public class CglibFactory implements MethodInterceptor {

	/**
	 * 创建代理对象->实现类
	 * @return
	 */
	public Object generatorImpl(Class<?> clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		//设置这个的目的是到时会有机会来回调this.intercept(...)
		enhancer.setCallback(this); 
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("hello cglib!");
		return null;
	}

}
