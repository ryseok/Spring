package com.encore.persistence;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.encore.domain.Re_BoardVO;

@Repository
public class Re_BoardDAOIpml implements Re_BoardDAO{
	@Inject
	private SqlSession sqlSession;

	@Override
	public void create(Re_BoardVO reBoard) throws Exception {
		sqlSession.insert("re_board.create",reBoard);
		
	}

	@Override
	public void update(Re_BoardVO reBoard) throws Exception {
		sqlSession.update("re_board.update",reBoard);
		
	}

	@Override
	public Re_BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne("re_board.read",bno);
	}

	@Override
	public List<Re_BoardVO> readAll() throws Exception {
		return sqlSession.selectList("re_board.readAll");
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("re_board.delete",bno);
		
	}

	
	
	
}
