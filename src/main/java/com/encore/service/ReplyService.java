package com.encore.service;

import java.util.List;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyVO;
//날짜	 : 180905
//작성자	 : rys
//제목	 : 댓글
//파일명	 : ReplyService.java
public interface ReplyService {
	public List<ReplyVO> listReply(int bno) throws Exception;
	public void addReply(ReplyVO reply) throws Exception;
	public void modifyReply(ReplyVO reply) throws Exception;
	public void removeReply(int rno) throws Exception;
	public List<ReplyVO> listReplyPage(int bno, Criteria cri) throws Exception;
	public int count(int bno) throws Exception;
}
