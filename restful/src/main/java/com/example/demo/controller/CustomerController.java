package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.vo.CustomerVO;

import lombok.Setter;

@RestController
@Setter
public class CustomerController {
	@Autowired
	private CustomerDAO dao;
	
	@RequestMapping("/listCustomer")
	public List<CustomerVO> listCustomer(){
		return dao.findAll();
	}
	
	@RequestMapping("/detailCustomer/{custid}")
	public CustomerVO findByCustID(@PathVariable  int custid) {
		return dao.findByCustID(custid);
	}
}
