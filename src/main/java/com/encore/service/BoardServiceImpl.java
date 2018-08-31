package com.encore.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.encore.domain.BoardVO;
import com.encore.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
    //DAO호출
	//regist, read, modify, remove, listAll
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public void regist(BoardVO board) throws Exception {
	    dao.create(board);
	}
	
	@Override
	public List<BoardVO> listAll()throws Exception{
		return dao.listAll();
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception{
		return dao.read(bno);
	}
	
	@Override
	public void modify(BoardVO board) throws Exception{
		dao.update(board);
	}
	
	@Override
	public void delete(Integer bno) throws Exception{
		dao.delete(bno);
	}
}