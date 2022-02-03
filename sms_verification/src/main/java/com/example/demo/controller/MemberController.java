package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void join_form() {		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public void join_submit(MemberVO m) {
		int re = dao.insert(m);
		if(re == 1) {
			System.out.println("회원을 등록하였습니다.");
		}
	}
	
	
	@RequestMapping("/sendNumber")
	@ResponseBody
	public String sendNumber(String phone) {
		String num = "1234"; 
		Random r = new Random();
		int a = r.nextInt(10);
		int b = r.nextInt(10);
		int c = r.nextInt(10);
		int d = r.nextInt(10);
		num = a + ""+b+""+c+""+d;
		BitSms sms = new BitSms();
		sms.sendMsg("01063859080", phone, num);
		return num;
	}
	
	@RequestMapping("/sendTotal")
	@ResponseBody
	public String sendTotalMsg() {
		List<MemberVO> list = dao.findAll();
		String from = "01025598279";
		BitSms sms = new BitSms();
		for(MemberVO m:list) {
			String to = m.getPhone();
			String name = m.getName();
			int total = m.getTotal();
			String msg = name + "님, 이번달 요금은 "+ total + "원입니다.";
			sms.sendMsg(from, to, msg);
			System.out.println(name+"님에게 메세지를 전송하였습니다.");
		}
		return "메세지를 모두 전송하였습니다.";
	}
}






















