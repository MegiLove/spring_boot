package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.SendSmsService;

import lombok.Setter;

@Component
@EnableScheduling
@Setter
public class SmsSchedule {
	
	@Autowired
	private SendSmsService sendSmsService;
	
	//@Scheduled(cron=“초 분 시간 일 월 요일 연도")
	//@Scheduled(cron = "0 0 9,14 * * ?")
	@Scheduled(cron = "0 30 9,14,15 * * ?")	
	public void send() {
		sendSmsService.sendSms();
	}
}
