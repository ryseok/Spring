package com.encore.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyVO;
import com.encore.persistence.BoardDAO;
import com.encore.persistence.ReplyDAO;

@Service 
public class ReplyServiceImpl implements ReplyService{

    @Inject
	private ReplyDAO replyDao;
    
    @Inject
    private BoardDAO boardDao;
	
	@Override
	public List<ReplyVO> listReply(int bno) throws Exception {		
		return replyDao.list(bno);
	}

	//댓글추가
	@Transactional
	@Override
	public void addReply(ReplyVO reply) throws Exception {
		replyDao.create(reply);//댓글추가		
        boardDao.updateReplyCnt(reply.getBno(), 1);//게시물 댓글수 증가
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		replyDao.update(reply);
	}

	@Transactional
	@Override
	public void removeReply(int rno) throws Exception {
		int bno = replyDao.getBno(rno);//댓글삭제전 댓글에 대한 게시물번호 
		replyDao.delete(rno);//댓글삭제
		boardDao.updateReplyCnt(bno, -1);
		//게시물의 댓글수 감소
	}

	@Override
	public List<ReplyVO> listReplyPage(int bno, Criteria cri) throws Exception {
		return replyDao.listPage(bno, cri);
	}

	@Override
	public int count(int bno) throws Exception {		
		return replyDao.count(bno);
	}

}