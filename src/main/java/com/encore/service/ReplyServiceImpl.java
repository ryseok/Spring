package com.encore.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.encore.domain.ReplyVO;
import com.encore.persistence.ReplyDAO;
//날짜	 : 180905
//작성자	 : rys
//제목	 : 댓글
//파일명	 : ReplyServiceImpl.java
@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Inject
	private ReplyDAO dao; 
	
	@Override
	public List<ReplyVO> listReply(int bno) throws Exception {
		return dao.list(bno);
	}

	@Override
	public void addReply(ReplyVO reply) throws Exception {
		dao.create(reply);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		dao.update(reply);
	}

	@Override
	public void removeReply(int rno) throws Exception {
		dao.delete(rno);
	}

}
