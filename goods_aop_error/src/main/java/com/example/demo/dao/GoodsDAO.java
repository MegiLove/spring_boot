package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVO;

@Repository
public class GoodsDAO {
	
	public static int pageSIZE = 5;
	public static int totalRecord;
	public static int totalPage;
	
	
	public List<GoodsVO> findAll(HashMap map){
		totalRecord = DBManager.getTotalRecord(map);
		totalPage = (int)Math.ceil( totalRecord / (double)pageSIZE);		
		return DBManager.findAll(map);
	}
	
	public int insert(GoodsVO g) {
		return DBManager.insert(g);
	}

	public GoodsVO findByNo(int no) {
		// TODO Auto-generated method stub
		return DBManager.findByNo(no);
	}

	public int update(GoodsVO g) {
		// TODO Auto-generated method stub
		return DBManager.update(g);
	}
	
	public int delete(int no) {
		return DBManager.delete(no);
	}
}






