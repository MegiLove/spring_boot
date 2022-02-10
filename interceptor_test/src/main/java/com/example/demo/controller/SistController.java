package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SistController {
	
	@RequestMapping("/hello")
	public void hello() {
		System.out.println("hello 요청입니다.");
	}
	
	@RequestMapping("/list")
	public void list() {
		System.out.println("list 요청입니다.");
	}
	
	@RequestMapping("/menu1")
	public void menu1() {		
	}
	
	@RequestMapping("/menu2")
	public void menu2() {		
	}
}
