package com.encore.persistence;

import com.encore.domain.MsgVO;

public interface MsgDAO {
   
	public int create(MsgVO msg)throws Exception;
	public MsgVO readMsg(int mno)throws Exception;
	public int updateState(int mno)throws Exception;
}