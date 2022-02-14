package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import javax.security.sasl.SaslServerFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVO;
import com.example.demo.vo.ScheduleVO;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static int insertSchedule(ScheduleVO s) {
		SqlSession session = factory.openSession();
		int re = session.insert("schedule.insert", s);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<ScheduleVO> listSchedule(){
		SqlSession session = factory.openSession();
		List<ScheduleVO> list= session.selectList("schedule.findAll");
		session.close();
		return list;
	}
	
	public static List<GoodsVO> listGoods(){
		SqlSession session = factory.openSession();
		List<GoodsVO> list= session.selectList("goods.findAll");
		session.close();
		return list;
	}
}












