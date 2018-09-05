package com.encore.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession session;
	
	@Override
	public void create(BoardVO board) throws Exception {
		session.insert("board.create",board);
		
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception{
		return session.selectList("board.listAll");
	}
	
	//Test Page
	@Override
	public List<BoardVO> listPage() throws Exception{
		return session.selectList("board.listPage");
	}
	
	//Test Page
	@Override
	public List<BoardVO> listPage2()throws Exception{
		//sqlSession.selectList("네임스페이스명.아이디명");
		//sqlSession.selectList(String id, Object param, RowBounds bound);
		//RowBounds bound = new RowBounds(int offset,int limit);
		//offset:스킵할 행수,  limit:조회할 최대행수
		RowBounds bound = new RowBounds(0,10);
		return session.selectList("board.listPage2",null,bound);
	}
	
	//Page처리
	@Override
	public List<BoardVO> listCriteria(Criteria cri)throws Exception{
		RowBounds bound = new RowBounds(cri.getPageStart(),cri.getPerPageNum());
		return session.selectList("board.listAll",null,bound);
	}

	
	
	@Override
	public BoardVO read(Integer bno) throws Exception{
		return session.selectOne("board.read",bno);
	}
	
	@Override
	public void update(BoardVO board) throws Exception{
		session.update("board.update",board);
	}
	
	@Override
	public void delete(Integer bno) throws Exception{
		session.delete("board.delete",bno);
	}
	
	@Override
	public int selectTotalCount() throws Exception{
		return session.selectOne("board.selectTotalCount");
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		RowBounds bounds = new RowBounds(cri.getPageStart(),cri.getPerPageNum());
		return session.selectList("board.listSearch",cri,bounds);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne("board.listSearchCount",cri);
	}
}
