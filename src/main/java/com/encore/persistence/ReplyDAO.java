package com.encore.persistence;

import java.util.List;

import com.encore.domain.ReplyVO;
//날짜	 : 180905
//작성자	 : rys
//제목	 : 댓글
//파일명	 : ReplyDAO.java
public interface ReplyDAO {
	public List<ReplyVO> list(int bno) throws Exception;
	public void create(ReplyVO reply) throws Exception;
	public void update(ReplyVO reply) throws Exception;
	public void delete(int rno) throws Exception;
}
