package com.wdx.test;

import com.wdx.biz.Biz;
import com.wdx.biz.impl.BizImplOne;
import com.wdx.proxy.CGLibDynProxy;

public class TestCGLibProxy {

	public static void main(String[] args) {
		Biz proxy = (Biz) new CGLibDynProxy().getCGLibProxyInstance(new BizImplOne());
		proxy.sayHello("111", "222", "333");
	}
	
}
