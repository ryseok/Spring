package com.encore.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.ReplyVO;
//날짜	 : 180905
//작성자	 : rys
//제목	 : 댓글
//파일명	 : ReplyDAOIpml.java
@Repository
public class ReplyDAOIpml implements ReplyDAO{
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<ReplyVO> list(int bno) throws Exception {
		return sqlSession.selectList("reply.list",bno);
	}

	@Override
	public void create(ReplyVO reply) throws Exception {
		sqlSession.insert("reply.create",reply);
	}

	@Override
	public void update(ReplyVO reply) throws Exception {
		sqlSession.update("reply.update",reply);
	}

	@Override
	public void delete(int rno) throws Exception {
		sqlSession.delete("reply.delete",rno);
	}

}
