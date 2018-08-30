package com.encore.persistence;

import java.util.List;

import com.encore.domain.BoardVO;

public interface BoardDAO {
	//제목 		: 게시판 만들기 미션
	//작성자 		: rys
	//날짜 		: 2018.08.30
	
	//인터페이스 DAO의 주된업무: Controller와 DAOImpl 연결하기
	public void insert(BoardVO boardVo) throws Exception;
	public void update(BoardVO boardVo) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public List<BoardVO> selectAll() throws Exception;
	public void delete(int bno) throws Exception;
}
