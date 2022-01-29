package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	private void mypoint() {}
	
	@Before("mypoint()")
	public void before(JoinPoint joinPoint ) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println(methodName+"가(이) 동작하기 전입니다.");
		
		HttpServletRequest request= (HttpServletRequest)joinPoint.getArgs()[0];
		//타깃이 되는 메소드의 첫번째 매개변수를 갖고 옵니다.
		
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		System.out.println("uri:"+uri);
		System.out.println("ip:"+ip);
		System.out.println("------------------------------");
	}
}













