package com.encore.service;

import com.encore.domain.MsgVO;

public interface MsgService {
	//액션 : "길동" ===> "라임" 메시지 보내기
	public void addMsg(MsgVO msg) throws Exception;
	
	//액션 : "라임"이 메시지 읽기
	public MsgVO readMsg(String userid, int mno) throws Exception;
}
