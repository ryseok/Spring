package com.encore.persistence;

import java.util.List;

import com.encore.domain.BoardVO;

public interface BoardDAO {
	//create, read, update, delete, listAll
	
	public void create(BoardVO board) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	BoardVO read(Integer bno) throws Exception;

	void update(BoardVO board) throws Exception;

	void delete(Integer bno) throws Exception;
}
