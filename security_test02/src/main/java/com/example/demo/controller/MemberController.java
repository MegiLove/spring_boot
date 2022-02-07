package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {

	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public void join_form() {
		
	}
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public void join_submit(MemberVO m) {
		int re  = dao.insert(m);
		if(re ==1 ) {
			System.out.println("등록성공");
		}else {
			System.out.println("등록실패");
		}
	}
}
