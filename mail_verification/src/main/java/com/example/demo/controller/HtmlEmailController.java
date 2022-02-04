package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Setter;

@Controller
@Setter
public class HtmlEmailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping("/htmlSend")
	@ResponseBody
	public String htmlSend() {
		
		javaMailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			     message.setFrom("");  //자신의 gmail 계정
			     message.setTo("");		//자신의 다른 이메일 계정
			     message.setSubject("html 메일 보내기 연습");
			     String str = "<h2>회원가입 성공!</h2><hr>";
			     str += "<img src='cid:ball'>";
			     message.setText(str, true);
			     
			     message.addInline("ball", new ClassPathResource("img/ball1.jpg"));
			     message.addAttachment("hello.txt", new ClassPathResource("sist/hello.txt"));
			   }
			 });
		
		return "html형식에 이메일을 전송하였습니다.";
	}
	
}
