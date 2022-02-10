package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDAO;

import lombok.Setter;

@Controller
@Setter
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login_form() {		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login_submit(String id, String pwd, HttpSession session) {
		ModelAndView mav = new ModelAndView("loginOK");
		int re = dao.isMember(id, pwd);
		
		String msg = "";
		if(re == 1) {
			msg = id + "님, 로그인 하였습니다.";
			session.setAttribute("userID", id);
			session.setAttribute("role", dao.getRole(id));
		}else if(re == 0) {
			msg = "암호가 틀립니다.";
		}else {
			msg = "아이디가 존재하지 않습니다.";
		}
		mav.addObject("msg", msg);
		return mav;
	}
	
	@RequestMapping("/member/menu1")
	@ResponseBody
	public String menu1() {
		return "메뉴1입니다";
	}
	
	@RequestMapping("/member/menu2")
	@ResponseBody
	public String menu2() {
		return "메뉴2입니다";
	}
	
	@RequestMapping("/logOut")
	public ModelAndView logOut(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/login");
		session.invalidate();
		return mav;
	}
}

























