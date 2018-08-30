package com.encore.dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.encore.domain.BoardVO;
import com.encore.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testInsertBoard() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(0);
		vo.setTitle("게시판등록 Test");
		vo.setContent("아메리카노 할인");
		vo.setWriter("인공지능");
		vo.setRegdate(null);
		dao.insert(vo);
		System.out.println("DB 입력성공");
	}
}
