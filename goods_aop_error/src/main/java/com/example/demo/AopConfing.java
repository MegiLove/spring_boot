package com.example.demo;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ExceptionLogDAO;
import com.example.demo.vo.ExceptionLog;


import lombok.Setter;

@Component
@Aspect
@Setter
public class AopConfing {
	
	@Autowired
	private ExceptionLogDAO dao;
	
	
	@AfterThrowing(pointcut =
			"execution(public * com.example.demo.controller..*(..))", 
			throwing = "ex")
	public void errorAdvice(JoinPoint joinPoint, Exception ex) {
		System.out.println("어드바이스 동작함");
		String msg = ex.getMessage().trim();
		System.out.println(msg.length()*3);
		String uri = ((HttpServletRequest)joinPoint.getArgs()[0]).getRequestURI();
		
		ExceptionLog log = new ExceptionLog();
		log.setMsg(msg);
		log.setUri(uri);
		
		dao.insert(log);
	}
}










