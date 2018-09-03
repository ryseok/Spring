package com.encore.test.dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.encore.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardDAOTest {

	@Inject
	BoardDAO dao;
	
	@Test
    public void testList()throws Exception{
    	dao.listAll();//십삼만개 조회
    }
	
	@Test
	public void testPage()throws Exception{
		dao.listPage();//10개 조회
	}
	
	@Test
	public void testPage2()throws Exception{
		dao.listPage2();//10개 조회
	}
	
	
}



