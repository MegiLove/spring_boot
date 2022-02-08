package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.DeptDao;
import com.example.demo.vo.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptDao dao;
	
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listDept.do")
	public ModelAndView list(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		
		//인증된(로그인한) 회원의 정보를 갖고 오기 위하여 
		//먼저 시큐리티의 인증객체가 필요합니다.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		//이 인증객체를 통하여 인증된(로그인한) User객체를 받아옵니다.
		User user = (User)authentication.getPrincipal();
		
		//이 인증된 User를 통해서 아이디와 암호를 얻을 수 있어요.
		//우리는 이 객체를 통해서 id를 갖고 옵니다.
		String id = user.getUsername();
		
		//만약, 인증된(로그인한) 회원의 아이디만 필요하면 이것만 세션에 상태유지하고
		//만약, 회원의 다른모든 정보도 필요하다면 MemberDAO를 회원의 정보를 꺼집어 내어와서 세션에 상태유지 합니다.
		session.setAttribute("id", id);
		return mav;
	}
	
	@RequestMapping(value = "/insertDept.do", method = RequestMethod.GET)
	public void insertForm() {		
	}
	
	@RequestMapping(value = "/insertDept.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(DeptVO d) {
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");
		int re= dao.insert(d);
		if(re != 1) {
			mav.setViewName("error");
			mav.addObject("msg", "부서등록에 실패파였습니다.");
		}
		return mav;
	}
}































