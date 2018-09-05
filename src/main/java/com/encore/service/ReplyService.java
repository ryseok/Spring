package com.encore.service;

import java.util.List;

import com.encore.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> listReply(int bno) throws Exception;
	public void addReply(ReplyVO reply) throws Exception;
	public void modifyReply(ReplyVO reply) throws Exception;
	public void removeReply(int rno) throws Exception;
}
