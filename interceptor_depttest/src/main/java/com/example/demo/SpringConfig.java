package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer{   //인터셉터를 등록하기 위하여 WebMvcConfigurer클래스를 확장합니다.

	@Override
	public void addInterceptors(InterceptorRegistry registry) { //addInterceptors메소드르 오버라이딩하여 
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addInterceptors(registry);
		
		registry.addInterceptor(new LoginInterceptor())		//매개변수 registry인터셉터를 등록합니다.
		.addPathPatterns("/insertDept.do", "/member/**");	//insertDept.do와 member에 모든 요청일때에 인터셉터가 동작하도록 설정합니다.
		
		
		registry.addInterceptor(new AdminInterceptor()) //AdminInterceptor를 등록합니다.
		.addPathPatterns("/admin/**");  				//admin네임스페이스에 모든 요청일때 동작하다록 설정합니다.
		
		registry.addInterceptor(new DeptLogInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/login");
		
//		registry.addInterceptor(new 새로운인터셉터클래스())
//		.addPathPatterns("새로운패턴");
		//admin 롤이 있어야 admin네이스페이스에 있는 서비스가 가능하도록
		//인터셉터를 통하여 "인가"에 대한 기능을 구현 해 봅니다.
		//완성하면 "1"
	}
	
}
