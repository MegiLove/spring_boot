package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;

@Repository
public class MemberDAO {
	
	public int isMember(String id, String pwd) {
		return DBManager.isMember(id, pwd);
	}
	
	public String getRole(String id) {
		return DBManager.getRole(id);
	}
}
