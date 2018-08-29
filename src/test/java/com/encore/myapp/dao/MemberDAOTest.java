package com.encore.myapp.dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.encore.domain.MemberVO;
import com.encore.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime() throws Exception{
		System.out.println("현재시간 : " + dao.getTime());
	}
	
	@Test
	public void testInsertMember() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUserid("na");
		vo.setUserpw("1q2w3e");
		vo.setUsername("나영석");
		vo.setEmail("na@gmail.com");
		
		dao.insertMember(vo);
		System.out.println("DB 입력 성공");
	}
}
