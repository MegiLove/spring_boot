package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class MailController {
	
	@Autowired
	private MailSender javaMailSender;
	
	
	@RequestMapping("/sendMail")
	@ResponseBody
	public String mail() {
		
		SimpleMailMessage mailMessage= new SimpleMailMessage();
		mailMessage.setSubject("회원가입안내");
		mailMessage.setFrom("shb04437@gmail.com");
		mailMessage.setTo("ibisevic@naver.com");
		mailMessage.setText("회원가입을 환영합니다");
		try {
			javaMailSender.send(mailMessage);
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return "메일을 발송하였습니다";
	}
}
