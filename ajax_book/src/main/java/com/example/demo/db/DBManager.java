package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVO;
import com.example.demo.vo.CustomerVO;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader=
					Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static List<BookVO> findAll(){
		SqlSession session = factory.openSession();
		List<BookVO> list = session.selectList("book.findAll");
		session.close();
		return list;
	}
	
	public static List<CustomerVO> findByBookID(int bookid){
		SqlSession session = factory.openSession();
		List<CustomerVO> list = session.selectList("customer.findByBookID", bookid);
		session.close();
		return list;
	}
	
	
	public static List<String> listPublisher(){
		SqlSession session = factory.openSession();
		List<String> list = session.selectList("book.listPublisher");
		session.close();
		return list;
	}
	
	public static List<BookVO> findByPublisher(String publisher){
		SqlSession session = factory.openSession();
		List<BookVO> list = session.selectList("book.findByPublisher",publisher);
		session.close();
		return list;
	}
}










