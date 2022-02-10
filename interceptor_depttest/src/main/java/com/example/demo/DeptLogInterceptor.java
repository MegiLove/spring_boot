package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.dao.DeptLogDAO;
import com.example.demo.vo.DeptLog;

import lombok.Setter;

@Component
//@Setter
public class DeptLogInterceptor extends HandlerInterceptorAdapter{
	
//	@Autowired
//	private DeptLogDAO dao;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		DeptLog log = new DeptLog();
		log.setUri(uri);
		log.setIp(ip);
		DeptLogDAO dao = new DeptLogDAO();
		dao.insert(log);
		super.afterCompletion(request, response, handler, ex);
	}
	
}













