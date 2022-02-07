package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CardDAO;
import com.example.demo.vo.MemberCardFee;

import lombok.Setter;

@Service
@Setter
public class SendEmailService {
	
	@Autowired
	private CardDAO dao;
	
	@Autowired
	private MailSender javaMailSender;
	
	
	public void sendEmail() {
		List<MemberCardFee> list= dao.selectMemberCardFee();
		for(MemberCardFee m:list) {
			String name= m.getName();
			String to = m.getEmail();
			int total = m.getTotal();
			
			String subject = name+"님, 이번달 요금안내입니다.[담당:김은영]";
			String content = "이번달 요금은 " + total + "원입니다.";
			
			SimpleMailMessage mailMessage= new SimpleMailMessage();
			mailMessage.setFrom("");//gmail주소
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(content);
			
			try {
				javaMailSender.send(mailMessage);		
				System.out.println(to+"님에게 메일을 발송하였습니다.");
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		System.out.println("메일발송을 모두 완료하였습니다.");
	}
}
















