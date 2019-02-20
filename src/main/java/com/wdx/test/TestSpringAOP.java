package com.wdx.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wdx.biz.Biz;

public class TestSpringAOP {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
		
		Biz biz = (Biz) ioc.getBean(Biz.class);
		
		biz.sayHello("111!","222","333");
		
		ioc.close();
	}

}
