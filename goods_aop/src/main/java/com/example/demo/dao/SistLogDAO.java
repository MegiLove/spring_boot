package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.SistLog;

@Repository
public class SistLogDAO {
	
	public int insert(SistLog log) {
		return DBManager.insertLog(log);
	}
}









