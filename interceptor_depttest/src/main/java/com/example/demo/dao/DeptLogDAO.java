package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.DeptLog;

@Repository
public class DeptLogDAO {
	public int insert(DeptLog log) {
		return DBManager.insertLog(log);
	}
}
