package com.encore.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.MsgVO;

@Repository
public class MsgDAOImpl implements MsgDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public int create(MsgVO msg) throws Exception {
		return sqlSession.insert("msg.create",msg);
	}

	@Override
	public MsgVO readMsg(int mno) throws Exception {
		return sqlSession.selectOne("msg.readMsg",mno);
	}

	@Override
	public int updateState(int mno) throws Exception {
		return sqlSession.update("msg.updateState",mno);
	}

}