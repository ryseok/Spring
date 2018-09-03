package com.encore.persistence;

import java.util.List;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;

public interface BoardDAO {
	//create, read, update, delete, listAll
	
	public void create(BoardVO board) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO board) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<BoardVO> listPage() throws Exception;

	public List<BoardVO> listPage2() throws Exception;

	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	public int selectTotalCount() throws Exception;
}
