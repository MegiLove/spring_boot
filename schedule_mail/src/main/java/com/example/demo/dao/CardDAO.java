package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.MemberCardFee;

@Repository
public class CardDAO {
	
	public List<MemberCardFee> selectMemberCardFee(){
		return DBManager.selectMemberCardFee();
	}
}
