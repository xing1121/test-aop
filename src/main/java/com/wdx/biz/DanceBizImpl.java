package com.wdx.biz;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 描述：DanceBizImpl
 * @author 80002888
 * @date   2018年10月8日
 */
@Component
public class DanceBizImpl {

	@Async
	public void dance(){
		System.out.println(Thread.currentThread().getName() + "____***********************dance**************************");
	}
	
}
