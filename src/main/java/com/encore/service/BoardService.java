package com.encore.service;

import java.util.List;

import com.encore.domain.BoardVO;

public interface BoardService {

	public void regist(BoardVO board) throws Exception;

	List<BoardVO> listAll() throws Exception;

	BoardVO read(Integer bno) throws Exception;

	void modify(BoardVO board) throws Exception;

	void delete(Integer bno) throws Exception;
}
