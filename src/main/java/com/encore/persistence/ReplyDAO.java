package com.encore.persistence;

import java.util.List;

import com.encore.domain.Criteria;
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
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception;
	public int count(int bno) throws Exception;
	public int getBno(int rno) throws Exception; //게시물 얻기
}
