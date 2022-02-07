package com.example.demo;

import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.SendEmailService;

import lombok.Setter;

@Component
@EnableScheduling
@Setter
public class SisiSchedule {

	@Autowired
	private SendEmailService emailService;
	
	//@Scheduled(cron=“초 분 시간 일 월 요일 연도")
	@Scheduled(cron = "0 21 12 7 * ?")
	public void pro() {
		emailService.sendEmail();
	}
	
	
}









