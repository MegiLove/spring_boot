package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PaymentDAO;
import com.example.demo.vo.PaymentVO;

import lombok.Setter;

@RestController
@Setter
public class PaymentController {
	@Autowired
	private PaymentDAO dao;
	
	@RequestMapping("/insertPayment")
	public String insertPayment(PaymentVO p) {
		return dao.insert(p)+"";
	}
}















