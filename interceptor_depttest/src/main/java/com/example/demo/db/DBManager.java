package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import javax.security.sasl.SaslServerFactory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptLog;
import com.example.demo.vo.DeptVO;

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
	
	public static List<DeptVO> findAll(){
		SqlSession session = factory.openSession();
		List<DeptVO> list = session.selectList("dept.findAll");
		session.close();
		return list;
	}
	
	public static int insert(DeptVO d) {
		SqlSession session = factory.openSession();
		int re= session.insert("dept.insert", d);
		session.commit();
		session.close();
		return re;
	}
	
	public static int isMember(String id, String userPwd) {
		int re = -1;
		SqlSession session = factory.openSession();
		String dbPwd= session.selectOne("member.isMember", id);
		session.close();
		if(dbPwd !=null) {
			if(dbPwd.equals(userPwd)) {
				re = 1;
			}else {
				re = 0;
			}
		}
		return re;
	}
	
	public static String getRole(String id) {
		SqlSession session = factory.openSession();
		String role = session.selectOne("member.getRole", id);
		session.close();
		return role;
	}
	
	public static int insertLog(DeptLog log) {
		SqlSession session = factory.openSession();
		int re= session.insert("deptLog.insert", log);
		session.commit();
		session.close();
		return re;
	}
}










