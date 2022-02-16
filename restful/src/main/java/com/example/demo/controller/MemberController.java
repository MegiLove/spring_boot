package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	@RequestMapping("/info")
	public String info(String name, int age) {
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		return "OK";
	}
	
	@RequestMapping("/member/{name}/{age}")
	public String member(@PathVariable String name, @PathVariable int age) {
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
		return "OK";
	}
	
	
}
