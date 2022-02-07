package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberCardFee;
import com.example.demo.vo.MemberVO;



public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static List<MemberCardFee> selectMemberCardFee(){
		SqlSession session = factory.openSession();
		List<MemberCardFee> list= session.selectList("card.selectMemberCardFee");
		session.close();
		return list;
	}
	
	public static List<MemberVO> listMember(){
		SqlSession session = factory.openSession();
		List<MemberVO> list = session.selectList("member.findAll");
		session.close();
		return list;
	}
}


















