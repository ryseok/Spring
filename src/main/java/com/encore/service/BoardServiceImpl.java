package com.encore.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.encore.domain.BoardVO;
import com.encore.persistence.BoardDAO;

//작성일 		: 180904
//수업내용 	: 페이징처리 복습
//작성자		: rys
//파일명 		: BoardServiceImpl.java

@Service
public class BoardServiceImpl implements BoardService{
	//컨트롤러와 DAO사이에 위치하는 완충제 역활
	//Sub컨트롤러 ===> 기능단위의 정의 ===> Transaction정의가 편하다
	//@Transcation(전체취소) {dao.insert(); dao.update()}
	
	@Inject
	private BoardDAO dao;
	
	@Override
	public boolean create(BoardVO board) {
		return dao.insert(board);
	}

	@Override
	public List<BoardVO> listAll(int start, int max) {
		return dao.selectAll(start, max);
	}

	@Override
	public BoardVO read(int bno) {
		return dao.select(bno);
	}

	@Override
	public boolean update(BoardVO board) {
		return dao.update(board);
	}

	@Override
	public boolean delete(int bno) {
		return dao.delete(bno);
	}
	
	@Override
	public int listCount() {
		return dao.totalCount();
	}
}
