package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.CustomerVO;
import com.example.demo.vo.PaymentVO;

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
	
	public static List<CustomerVO> findAll(){
		SqlSession session = factory.openSession();
		List<CustomerVO> list = session.selectList("customer.findAll");
		session.close();
		return list;
	}
	
	public static CustomerVO findByCustID(int custid) {
		SqlSession session = factory.openSession();
		CustomerVO c = session.selectOne("customer.findByCustID", custid);
		session.close();
		return c;
	}
	
	public static int insertPayment(PaymentVO p) {
		SqlSession session = factory.openSession();
		int re = session.insert("payment.insert", p);
		session.commit();
		session.close();
		return re;
	}
}
















