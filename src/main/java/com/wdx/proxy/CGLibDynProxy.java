package com.wdx.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 描述：CGlib动态代理
 * @author 80002888
 * @date   2018年9月30日
 */
public class CGLibDynProxy implements MethodInterceptor {

	// 目标对象
	private Object target;

	public Object getCGLibProxyInstance(Object target) {
		this.target = target;
		// 增强器，动态代码生成器
		Enhancer enhancer = new Enhancer();
		// 回调方法
		enhancer.setCallback(this);
		// 设置生成类的父类类型
		enhancer.setSuperclass(target.getClass());
		// 动态生成字节码并返回代理对象
		return enhancer.create();
	}

	@SuppressWarnings("all")
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// 目标对象的目标方法执行，传入参数args
		System.out.println("-----代理开始-----"+this.getClass());
		// 三种执行方法实际效果一样，返回值一样
		Object res = methodProxy.invoke(target, args);			// 目标对象执行代理对象的代理方法
			
		Object res2 = methodProxy.invokeSuper(proxy, args);		// 代理对象执行代理对象的父类（目标对象）的方法，这个性能高
		
		Object res3 = method.invoke(target, args);				// 目标对象执行目标方法
		
		System.out.println("-----代理结束-----"+this.getClass());
		// 目标方法返回值
		return res;
	}

}
