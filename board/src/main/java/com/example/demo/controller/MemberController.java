package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberDAO dao;	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void insert_form() {		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView insert_sumbit(MemberVO m) {
		int re = dao.insert(m);
		ModelAndView mav = new ModelAndView("joinOK");
		if(re == 1) {
			mav.addObject("msg", "회원가입에 성공하였습니다.");
		}else {
			mav.addObject("msg", "회원가입에 실패하였습니다.");
		}
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login_form() {		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login_submit(HttpSession session,   String id, String pwd) {
		ModelAndView mav = new ModelAndView("loginOK");
		MemberVO m= dao.isMember(id, pwd);
		if(m != null) {
			mav.addObject("msg", "로그인 하였습니다.");
			session.setAttribute("member", m);
			MemberVO m2= (MemberVO)session.getAttribute("member");
			System.out.println("로그인한 회원의 이름 : " +m2.getName());
		}else {
			mav.addObject("msg", "로그에 실패하였습니다.");
		}
		return mav;
	}
}











