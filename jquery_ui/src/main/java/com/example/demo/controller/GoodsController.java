package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

import lombok.Setter;

@RestController
@Setter
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	@RequestMapping("/listGoods")
	public List<GoodsVO> listGoods(){
		return dao.findAll();
	}
}














