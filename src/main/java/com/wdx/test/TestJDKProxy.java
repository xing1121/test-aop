package com.wdx.test;

import com.wdx.biz.Biz;
import com.wdx.biz.impl.BizImplOne;
import com.wdx.proxy.JDKDynProxy;

/**
 * 描述：测试JDK动态代理
 * @author 80002888
 */
public class TestJDKProxy {

	public static void main(String[] args) {
		Biz bizProxy = (Biz) new JDKDynProxy().getJDKProxyInstance(new BizImplOne());
		bizProxy.sayHello("p1", "p2", "p3");
	}
	
}
