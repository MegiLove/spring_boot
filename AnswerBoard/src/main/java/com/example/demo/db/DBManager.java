package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVO;

public class DBManager {
	private static SqlSessionFactory factory ;
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
	
	
	public static List<BoardVO> listBoard(){
		SqlSession session = factory.openSession();
		List<BoardVO> list = session.selectList("board.findAll");
		session.close();
		return list;
	}
	
	
	public static int insertBoard(BoardVO b) {
		SqlSession session = factory.openSession();
		int re = session.insert("board.insert", b);
		session.commit();
		session.close();
		return re;
	}
	
	public static int getNextNo() {
		SqlSession session = factory.openSession();
		int re = session.selectOne("board.getNextNo");		
		session.close();
		return re;
	}
	
	public static BoardVO findByNo(int no) {
		SqlSession session = factory.openSession();
		BoardVO b= session.selectOne("board.findByNo", no);
		session.close();
		return b;
		
	}
	
	public static void upateStep(int b_ref, int b_step) {
		HashMap map = new HashMap();
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);
		
		SqlSession session = factory.openSession();
		session.update("board.updateStep", map);
		session.commit();
		session.close();
	}
}














