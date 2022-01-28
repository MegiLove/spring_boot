package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.commons.ControllerLogging;
import com.example.demo.dao.BoardDAO;

import lombok.Setter;

@Controller
@Setter
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	
	@RequestMapping("/list")
	@ResponseBody
	public String list() {	
		dao.list();
		return "list";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert() {	
		dao.insert();
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "insert";
	}
}








