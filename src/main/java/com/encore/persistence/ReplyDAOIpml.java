package com.encore.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.Criteria;
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
	
	@Override
	//특정 글번호 에 대한 페이징된 댓글 
	public List<ReplyVO> listPage(int bno,Criteria cri) throws Exception{
		RowBounds bounds = new RowBounds(cri.getPageStart(),cri.getPerPageNum());
		return sqlSession.selectList("reply.list",bno,bounds);
	}
	
	@Override
	//특정 게시물에 총 댓글 수
	public int count(int bno) throws Exception{
		return sqlSession.selectOne("reply.count",bno);
	}

	//게시물 얻기
	@Override
	public int getBno(int rno) throws Exception {
		
		return sqlSession.selectOne("reply.getBno",rno);
	}
}
