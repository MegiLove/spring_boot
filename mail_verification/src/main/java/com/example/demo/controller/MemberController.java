package com.example.demo.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import kr.co.youiwe.webservice.BitSms;
import lombok.Setter;

@Controller
@Setter
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private MailSender javaMailSender;
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void insert_form() {}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String insert_submit(MemberVO m) {
		int re  = dao.insert(m);
		if(re == 1) {
			return "회원가입에 성공";
		}else {
			return "회원가입 실패";
		}
	}
	
	
	@RequestMapping("/checkVerification")
	@ResponseBody
	public String checkEmail(String type, String to) {
		System.out.println("type:"+type);
		System.out.println("to:"+to);
		
		String code = "";
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		code = a + ""+b+""+c+""+d;
		
		if(type.equals("email")) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setSubject("인증코드 발송");
			mailMessage.setText(code);
			mailMessage.setFrom("");// gmail 주소
			mailMessage.setTo(to);
			
			try {
				javaMailSender.send(mailMessage);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}else {
			BitSms sms = new BitSms();
			sms.sendMsg("01025598279", to, code);
		}
		
		return code;
	}
}















