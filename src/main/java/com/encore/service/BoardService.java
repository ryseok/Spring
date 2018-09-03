package com.encore.service;

import java.util.List;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;

public interface BoardService {

	public void regist(BoardVO board) throws Exception;

	public List<BoardVO> listAll() throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void modify(BoardVO board) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	public int listCount() throws Exception;
}
