package com.example.demo;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class SpringConfig {
	
	@Bean
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl r= new JavaMailSenderImpl();
		r.setHost("smtp.gmail.com");
		r.setPort(587);
		r.setUsername(""); // gmail의 id를 설정합니다.
		r.setPassword("");//암호를 설정합니다.
		r.setDefaultEncoding("UTF-8");
		
		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.checkserveridentity", true);
		prop.put("mail.smtp.ssl.trust", "*");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		r.setJavaMailProperties(prop);
		return r;
	}
}















