package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filter.AdminFilter;
import com.example.demo.filter.InsertFilter;

@Configuration
public class SpringConfig {
	
	@Bean
	public FilterRegistrationBean setFilterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new InsertFilter());
		filterRegistrationBean.addUrlPatterns("/insertDept.do");
		return filterRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean setFilterRegistrationBean2() {
		//  admin네이스페이스의 모든 요청일 때에 AdminFilter가 동작하도록 
		FilterRegistrationBean filterRegistrationBean= new FilterRegistrationBean(new AdminFilter());
		filterRegistrationBean.addUrlPatterns("/admin/*");
		return filterRegistrationBean;
	}
}
