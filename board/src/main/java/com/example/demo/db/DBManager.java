package com.example.demo.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVO;
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
	
	public static List<BoardVO> findAll(HashMap map){
		SqlSession session = factory.openSession();
		System.out.println("map"+map);
		List<BoardVO> list= session.selectList("board.findAll", map);
		session.close();
		return list;
	}
	
	
	
	public static int getTotalRecord(HashMap map) {
		SqlSession session = factory.openSession();
		int no = session.selectOne("board.totalRecord", map);
		session.close();
		return no;
	}
	
	public static int getNextNo() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("board.getNextNo");
		session.close();
		return no;
	}
	
	public static int insert(BoardVO b) {
		//b.setNo(getNextNo());
		SqlSession session  = factory.openSession();
		int re = session.insert("board.insert", b);
		session.commit();
		session.close();
		return re;
	}
	
	public static BoardVO findByNo(int no) {
		SqlSession session = factory.openSession();
		BoardVO b = session.selectOne("board.findByNo", no);
		session.close();
		return b;		
	}
	
	public static int update(BoardVO b) {
		SqlSession session = factory.openSession(true);
		int re = session.update("board.update", b);
		session.close();
		return re;
				
	}

	public static int delete(HashMap map) {
		SqlSession session  = factory.openSession();
		int re=session.delete("board.delete", map);
		session.commit();
		session.close();
		return re;
	}
	
	public static void updateHit(int no) {
		SqlSession session = factory.openSession();
		session.update("board.updateHit", no);
		session.commit();
		session.close();
	}
	
	public static int insertMember(MemberVO m) {
		SqlSession session = factory.openSession();
		int re = session.insert("member.insert", m);
		session.commit();
		session.close();
		return re;
	}
	
	public static MemberVO isMember(String id, String pwd) {
		HashMap map = new HashMap();
		map.put("id", id);
		map.put("pwd", pwd);
		SqlSession session = factory.openSession();
		MemberVO m = session.selectOne("member.isMember", map);
		session.close();
		return m;
	}
	
}











