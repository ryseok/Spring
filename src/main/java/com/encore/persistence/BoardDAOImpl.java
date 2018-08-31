package com.encore.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession session;
	
	@Override
	public void create(BoardVO board) throws Exception {
		session.insert("board.create",board);
		
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception{
		return session.selectList("board.listAll");
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception{
		return session.selectOne("board.read",bno);
	}
	
	@Override
	public void update(BoardVO board) throws Exception{
		session.update("board.update",board);
	}
	
	@Override
	public void delete(Integer bno) throws Exception{
		session.delete("board.delete",bno);
	}
}
