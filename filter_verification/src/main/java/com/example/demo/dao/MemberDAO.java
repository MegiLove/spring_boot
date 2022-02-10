package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;

@Repository
public class MemberDAO {
	//id존재 하지 않는 경우		: -1
	//암호가 일치하지 않는 경우	: 0
	//암호가 일치하는 경우		: 1
	public int  isMember(String id, String usrPwd) {
		
		String dbPwd = DBManager.isMember(id);
		int re = -1;
		if(dbPwd == null) {
			re = -1;
		}else {
			if(usrPwd.equals(dbPwd)) {
				re = 1;
			}else {
				re = 0;
			}
		}
		return re;
		
	}
	
	public String getRole(String id) {
		return DBManager.getRole(id);
	}
}













