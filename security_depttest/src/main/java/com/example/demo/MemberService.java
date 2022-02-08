package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

import lombok.Setter;

@Service
@Setter
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//UserDetail를 만들려면
		//아이디,암호,롤 이 필요합니다.
		MemberVO m = dao.findById(username);
		UserDetails userDetails = null;
		
		if(m == null) {
			throw new UsernameNotFoundException(username);
		}
		
		/*
		//UserDetails를 생성하기 위해서 UserBuilder가 필요합니다.
		UserBuilder builder = User.builder();
		
		builder.username(username);//아이디를 설정
		builder.password(m.getPwd());//암호를 설정
		builder.roles(m.getRole());//롤을 설정
		
		userDetails = builder.build(); //아이디,암호,롤이 설정된 UserBuilder를 갖고 UserDetails를 생성합니다.
		
		return userDetails;*/
		
		return User.builder()
				.username(username)
				.password(m.getPwd())
				.roles(m.getRole())
				.build();		
	}

}











