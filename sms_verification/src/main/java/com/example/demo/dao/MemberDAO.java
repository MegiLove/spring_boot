package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberVO;

@Repository
public class MemberDAO {

	public int insert(MemberVO b) {
		return DBManager.insertMember(b);
	}
	
	public List<MemberVO> findAll(){
		return DBManager.findAll();
	}
}
