package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KaKaoLoginOKController {

	@RequestMapping("/KakaLoginOK/{email}")
	public ModelAndView loginOK(@PathVariable String email, Model model, HttpSession session) {
		session.setAttribute("member", email);
		ModelAndView mav = new ModelAndView("loginOK");
		return mav;
	}
}
