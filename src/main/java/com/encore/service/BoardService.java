package com.encore.service;

import java.util.List;

import com.encore.domain.BoardVO;

//작성일 		: 180904
//수업내용 	: 페이징처리 복습
//작성자 		: rys
//파일명 		: BoardService.java

public interface BoardService {
	//DB입력
	public boolean create(BoardVO board);
	
	//DB전체조회(page조희) ===> list.jsp위한
	public List<BoardVO> listAll(int start, int max);
	
	//DB조회(특정한값) ===> read.jsp,modify.jsp 위한
	public BoardVO read(int bno);
	
	//DB수정
	public boolean update(BoardVO board);
	
	//DB삭제
	public boolean delete(int bno);

	//전체 행 수 조회
	public int listCount();
}
