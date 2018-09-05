package com.encore.persistence;

import java.util.List;

import com.encore.domain.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> list(int bno) throws Exception;
	public void create(ReplyVO reply) throws Exception;
	public void update(ReplyVO reply) throws Exception;
	public void delete(int rno) throws Exception;
}
