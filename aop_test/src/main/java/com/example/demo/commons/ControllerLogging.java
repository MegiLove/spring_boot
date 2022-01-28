package com.example.demo.commons;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerLogging {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void mypoint() {		
	}
	
	@Around("mypoint()")
	public Object around(ProceedingJoinPoint joinPoint) {
//		String methodName =joinPoint.getSignature().toLongString();
		String methodName =joinPoint.getSignature().toShortString();
		System.out.println(methodName + "동작하기 전입니다.");
		long start = System.currentTimeMillis();
		Object re=null;
		try {
			re= joinPoint.proceed();
			//타깃이 되는 메소드를 호출합니다.
			//이명령어를 기준으로 위쪽에 작성하면 타깃이 동작하기 전에 수행하고 
			//이명령어 아래쪽에 작성하면 타깃이 동작한 후에 수행합니다.
		}catch (Throwable e) {
			// TODO: handle exception
		}
		
		long end = System.currentTimeMillis();
		System.out.println(methodName + "동작한 후입니다.");
		System.out.println("걸린시간:"+ (end-start));
		return re;
	}
	
	
//	@Before("mypoint()")
//	public void pro() {
//		System.out.println("로깅입니다.");
//	}
//	
//	@After("mypoint()")
//	public void pro2() {
//		System.out.println("변경된 로깅입니다.");
//	}
}




