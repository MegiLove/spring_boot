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
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static int insertMember(MemberVO m) {
		SqlSession session = factory.openSession();
		int re =session.insert("member.insert", m);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<MemberCardFee> selectCardFee(){
		SqlSession session = factory.openSession();
		List<MemberCardFee> list = session.selectList("card.selectCardFee");
		session.close();
		return list;
	}
}














