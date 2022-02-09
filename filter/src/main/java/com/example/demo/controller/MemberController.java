package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public void login_form() {		
	}
	
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public ModelAndView login_submit(HttpSession session,    String id, String pwd) {	
		ModelAndView mav = new ModelAndView("loginOK");
		
		int re = dao.isMember(id, pwd);
		
		session.setAttribute("re", re);
		//re의 값이 1이면 로그인의 상태입니다.
		
		if(re != 1) {
			mav.setViewName("redirect:/login");
		}
		
		return mav;
	}
}















