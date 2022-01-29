package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardVO;

@Repository
public class BoardDAO {
	
	public List<BoardVO> list(){
		return DBManager.listBoard();
	}
	
	public int insert(BoardVO b) {
		return DBManager.insertBoard(b);
	}
	
	public int getNextNo() {
		return DBManager.getNextNo();
	}
	
	public BoardVO findByNo(int no) {
		return DBManager.findByNo(no);
	}
	
	public void updateStep(int b_ref, int b_step) {
		DBManager.upateStep(b_ref, b_step);
	}
}











