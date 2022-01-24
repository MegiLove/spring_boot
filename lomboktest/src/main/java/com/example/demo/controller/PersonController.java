package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.Person;

@Controller
public class PersonController {
	
	@RequestMapping("/person.do")	
	@ResponseBody
	public String person() {
		Person p = new Person("홍길동", 20);
		String r = p.getName() + ","+  p.getAge();
		return r;
	}
}
