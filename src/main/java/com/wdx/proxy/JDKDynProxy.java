package com.wdx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 描述：JDK动态代理
 * 		使用内置的Proxy实现动态代理有一个问题：被代理的类必须实现接口，未实现接口则没办法完成动态代理。
 * 		JDK动态代理生成的代理类，是目标类所实现的接口的实现类，并重写方法。
 * @author 80002888
 */
public class JDKDynProxy implements InvocationHandler{

	// 目标对象
	private Object target;
	
	/**
	 * 获取代理对象
	 *	@ReturnType	Object 
	 *	@Date	2018年4月10日	上午10:07:58
	 *  @Param  @param target
	 *  @Param  @return
	 */
	public Object getJDKProxyInstance(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	/**
	 * @param	proxy:代理对象
	 * @param	method:目标对象目标方法
	 * @param	args:目标对象目标方法的参数
	 * @return	目标方法返回值	
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 目标对象的目标方法执行，传入参数args
		System.out.println("-----代理开始-----"+this.getClass());
		Object res = method.invoke(target, args);
		System.out.println("-----代理结束-----"+this.getClass());
		// 目标方法返回值
		return res;
	}
}
