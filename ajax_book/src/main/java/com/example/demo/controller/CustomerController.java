package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/findByBookID")
	public List<CustomerVO> findByBookID(int bookid){
		return dao.findByBookID(bookid);
	}
}

















