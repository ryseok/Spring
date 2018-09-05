package com.encore.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.domain.SearchCriteria;
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
	public List<BoardVO> listCriteria(Criteria cri)throws Exception{
		return dao.listCriteria(cri);
		//return dao.listPage2();
	}

	@Override
	public List<BoardVO> listAll()throws Exception{
		return dao.listAll();
		//return dao.listPage2();
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
	
	@Override
	public int listCount() throws Exception{
		return dao.selectTotalCount();
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
}