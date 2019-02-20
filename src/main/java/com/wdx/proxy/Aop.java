package com.wdx.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wdx.biz.DanceBizImpl;

@Aspect
@Component
public class Aop {

	@Autowired
	private DanceBizImpl danceBiz;
	
	@Before(value="execution(* com.wdx.biz.Biz.sayHello(..)) and args(p2,p1,p3)")	//**************logBefore参数--222--111!--333		按照参数顺序封装
  //@Before(value="execution(* com.sf.stms.component.Biz.sayHello(..)) and args(p2,p1,p3)",argNames="p2,p3,p1")	//**************logBefore参数--111--333!--222		按照参数名字封装
	public void logBefore(String p1,String p2,String p3) {
		System.out.println("**************logBefore参数--"+p1+"--"+p2+"--"+p3);	//1 3 2 
	}
	
	@AfterReturning(value="execution(* com.wdx.biz.Biz.sayHello(..))",returning="result")
	public void logReturn(String result) {
		System.out.println("**************logReturn返回值--"+result);
	}
	
	@AfterThrowing(value="execution(* com.wdx.biz.Biz.sayHello(..))",throwing="exception")
	public void logException(JoinPoint joinPoint,Exception exception){
		System.out.println("**************logException【"+joinPoint.getSignature().getName()+"】方法抛异常了，异常信息："+exception.getMessage());
	}
	
	@After(value="execution(* com.wdx.biz.Biz.sayHello(..))")
	public void logEnd(JoinPoint joinPoint){
		System.out.println("**************logEnd【"+joinPoint.getSignature().getName()+"】方法最终结束了");
		danceBiz.dance();
	}
	
}