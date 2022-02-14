package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.ScheduleVO;

@Repository
public class ScheduleDAO {
	
	public int insert(ScheduleVO s) {
		return DBManager.insertSchedule(s);
	}
	
	public List<ScheduleVO> listSchedule(){
		return DBManager.listSchedule();
	}
}
