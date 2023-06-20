package com.zhihei.springAOP.proxy.dynamicproxy.handler;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA. Author: zky Date: 2019-11-07 Time: 21:40:49
 * Description:
 */
public class CglibProxyHandler implements MethodInterceptor {
	/**
	 * 维护目标对象
	 */
	private Object target;

	public Object getProxyInstance(final Object target) {
		this.target = target;
		/**
		 * Enchancer 是CGlib的字节码增强器，可以方便对类进行扩展
		 */
		Enhancer enhancer = new Enhancer();
		/**
		 * 将被代理的对象设置成父类
		 */
		enhancer.setSuperclass(this.target.getClass());
		/**
		 * 设置拦截器
		 */
		enhancer.setCallback(this);
		/**
		 * 动态的创建一个代理类
		 */
		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("整理工作会议以及准备工作任务");
		Object o1 = methodProxy.invokeSuper(o, objects);
		System.out.println("准备衣食住行");
		return o1;
	}
}
