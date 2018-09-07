package com.encore.persistence;

import java.util.List;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.domain.SearchCriteria;

public interface BoardDAO {
	//create, read, update, delete, listAll
	
	//생성
	public void create(BoardVO board) throws Exception;

	//전체조회 + 페이징
	public List<BoardVO> listAll() throws Exception;

	//특정한 값 조회
	public BoardVO read(Integer bno) throws Exception;

	//업데이트
	public void update(BoardVO board) throws Exception;

	//삭제
	public void delete(Integer bno) throws Exception;

	//Test 페이징
	public List<BoardVO> listPage() throws Exception;

	//Test 페이징
	public List<BoardVO> listPage2() throws Exception;

	//하단의 페이지
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	//페이징 전체조회
	public int selectTotalCount() throws Exception;
	
	//검색어 관련 조회
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public void updateReplyCnt(int bno, int amount)throws Exception;
	
	public void updateViewCnt(int bno)throws Exception;
}
