package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class SmsController {
	
	@RequestMapping(value = "/send" ,method = RequestMethod.GET)
	public void send_form() {		
	}
	
	@RequestMapping(value = "/send" ,method = RequestMethod.POST)
	public void send_submit(String from , String to, String msg) {		
		BitSms sms = new BitSms();
		sms.sendMsg(from, to, msg);
		System.out.println("메세지를 전송하였습니다.");
	}
}	
