package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDao;
import com.example.demo.vo.BookVO;

@RestController   // @Controller + @ResponseBody
public class BookController {
	@Autowired
	private BookDao dao;
	
	
	@RequestMapping("/listBook")
	public List<BookVO> list(){
		return dao.findAll();
	}
	
	@RequestMapping("/listPublisher")
	public List<String> listPublisher(){
		return dao.listPublisher();
	}
	
	@RequestMapping("/findByPublisher")
	public List<BookVO> findByPublisher(String publisher){
		return dao.findByPublisher(publisher);
	}
}













