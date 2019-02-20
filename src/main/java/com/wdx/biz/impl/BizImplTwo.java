package com.wdx.biz.impl;

import com.wdx.biz.Biz;

//@Service
public class BizImplTwo implements Biz{
	
	@Override
	public String sayHello(String param1,String param2,String param3){
		
		System.out.println("BizImplTwo...sayHello 方法运行中--"+param1+"--"+param2+"--"+param3);
		
		return "这是BizImplTwo返回值！";
	}
	
}
