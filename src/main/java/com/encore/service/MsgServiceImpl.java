package com.encore.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.domain.MsgVO;
import com.encore.persistence.MsgDAO;
import com.encore.persistence.PointDAO;

@Service
public class MsgServiceImpl implements MsgService{
	/*
	<<MsgDAO>>
	public int create(MsgVO msg);
	public MsgVO readMsg(int mno);
	public int updateState(int mno);
	
	<<PointDAO>>
	public boolean updatePoint(String userid,int point);
	*/

	@Inject
	private MsgDAO msgDao;
	@Inject
	private PointDAO pointDao;
	
	//액션: '길동' ----> '라임' 메시지 보내기	   
	@Transactional
	@Override
	public void addMsg(MsgVO msg) throws Exception {
		System.out.println(">>>addMsg():"+msg);
		msgDao.create(msg);//Msg테이블 행추가
		pointDao.updatePoint(msg.getSenderid(), 10);//보낸사람 포인트 10상승
	}

	//액션: '라임'이 메시지 읽기
	@Override
	public MsgVO readMsg(String userid, int mno) throws Exception {
		System.out.println(">>>readMsg():"+userid+","+mno);
        msgDao.updateState(mno);//읽은날짜변경
        pointDao.updatePoint(userid, 5);//읽은사람 포인트 5상승
        
		return msgDao.readMsg(mno);//메시지읽기
	}

}