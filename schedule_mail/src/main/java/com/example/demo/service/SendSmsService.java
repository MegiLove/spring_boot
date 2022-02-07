package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import kr.co.youiwe.webservice.BitSms;
import lombok.Setter;


@Service
@Setter
public class SendSmsService {
	
	@Autowired
	private MemberDAO dao;
	
	public void sendSms() {
		List<MemberVO> list = dao.listMember();
		BitSms sms = new BitSms();
		//sms.sendMsg(from, to, msg);
		String from = "01025598279";
		String to = "";
		String msg = "";
		String ampm = "오전";
		Date today = new Date();
		int hours = today.getHours();
		if(hours >= 12) {
			ampm = "오후";
		}
		for(MemberVO m:list) {
			to = m.getPhone();
			msg = m.getName()+"님," + ampm + "에 코로나 자가진단을 해 주십시요";
			sms.sendMsg(from, to, msg);
			System.out.println(m.getName()+"님에게 메세지를 전송하였습니다.");
		}
		System.out.println("메세지를 모두 전송하였습니다.");
	}
}












