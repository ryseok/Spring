package com.encore.persistence;

import java.util.List;

import com.encore.domain.Re_BoardVO;

public interface Re_BoardDAO {
	public void create(Re_BoardVO reBoard) throws Exception;
	public void update(Re_BoardVO reBoard) throws Exception;
	public Re_BoardVO read(int bno) throws Exception;
	public List<Re_BoardVO>  readAll() throws Exception;
	public void delete(int bno) throws Exception;
}
