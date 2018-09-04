package com.encore.persistence;

import java.util.List;

import com.encore.domain.BoardVO;

//작성일 		: 180904
//수업내용 	: 페이징처리 복습
//작성자		: rys
//파일명 		: BoardDAO.java

public interface BoardDAO {
	//DB입력
	public boolean insert(BoardVO board);
	
	//DB전체조회
	public List<BoardVO> selectAll(int start, int max);
	
	//DB조회
	public BoardVO select(int bno);
	
	//DB수정
	public boolean update(BoardVO board);
	
	//DB삭제
	public boolean delete(int bno);

	//전체 행 수 조회
	public int totalCount();
}
