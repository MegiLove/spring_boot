package com.example.demo;

import java.io.FileWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.SistLogDAO;
import com.example.demo.vo.SistLog;

import lombok.Data;

@Component
@Data
@Aspect
public class AopConfig {
	
	@Autowired
	private SistLogDAO dao;
	
	@Pointcut("execution(public * com.example.demo.controller..*(..))")
	public void myPoint() {}
	
	//요청한 서비스명, ip주소, 요청시간, 걸린시간을 
	//저장하기 위한 데이터베이스 테이블을 생성하고 
	//로그를 테이블에 기록하도록 수정 해 봅니다.
	//완성하면 "3"
	@Around("myPoint()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object re = null;
		long start = System.currentTimeMillis();
		try {
			re =joinPoint.proceed();
		}catch (Throwable e) {
		}
		long end = System.currentTimeMillis();
		long stay = end -  start;
		
		HttpServletRequest request= (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth()+1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		String time = year+"년"+month+"월"+date+"일"+hours+":"+minutes+":"+seconds;
		
		SistLog log = new SistLog(0, uri, ip, time, stay);
		dao.insert(log);
		
		return re;
	}
	
	
	/*
	@Around("myPoint()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object re = null;
		long start = System.currentTimeMillis();
		try {
			re =joinPoint.proceed();
		}catch (Throwable e) {
		}
		long end = System.currentTimeMillis();
		long stay = end -  start;
		
		HttpServletRequest request= (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth()+1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		String time = year+"년"+month+"월"+date+"일"+hours+":"+minutes+":"+seconds;
		
		String msg = time+"/"+uri+"/"+ip+"/"+stay+"\n";
		try {
			FileWriter fw = new FileWriter("c:/data/sistLog.txt", true);
			fw.write(msg);
			fw.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return re;
	}
	*/
	
	/*
	@Around("myPoint()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object re = null;
		long start = System.currentTimeMillis();
		try {
			re =joinPoint.proceed();
		}catch (Throwable e) {
		}
		long end = System.currentTimeMillis();
		long stay = end -  start;
		
		HttpServletRequest request= (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth()+1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		String time = year+"년"+month+"월"+date+"일"+hours+":"+minutes+":"+seconds;
		
		System.out.println("요청시간:"+time);
		System.out.println("uri:"+uri);
		System.out.println("ip:"+ip);
		System.out.println("걸린시간:"+time);
		System.out.println("-----------------------------");
		
		
		return re;
	}
	
	*/
}












