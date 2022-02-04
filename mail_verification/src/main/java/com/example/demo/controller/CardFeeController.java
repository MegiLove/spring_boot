package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.CardDAO;
import com.example.demo.vo.MemberCardFee;

import lombok.Setter;

@Controller
@Setter
public class CardFeeController {

	@Autowired
	private CardDAO dao;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@RequestMapping("/sendCardFee")
	@ResponseBody
	public String send() {
		List<MemberCardFee> list = dao.selectCardFee();
		for(MemberCardFee m:list) {
			String name = m.getName();
			String to = m.getEmail();
			int amount = m.getAmount();
			String subject = name + "님 이번달 명세서입니다.[담당자:김은영]";
			String content = name + "님 이번달 요금은 "+ amount + "원입니다.";
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setSubject(subject);
			mailMessage.setText(content);
			mailMessage.setFrom("");
			mailMessage.setTo(to);
			
			try {
				javaMailSender.send(mailMessage);
				System.out.println(to+"에게 메일을 발송하였습니다.");
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		return "카드명세서를 모두 발송하였습니다.";
	}
}









