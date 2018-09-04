package com.encore.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.BoardVO;

//작성일 		: 180904
//수업내용 	: 페이징처리 복습
//작성자		: rys
//파일명 		: BoardDAOImpl.java

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlsession;
	
	@Override
	public boolean insert(BoardVO board) {
		int t = sqlsession.insert("mboard.insert",board);
		if(t == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<BoardVO> selectAll(int start, int max) {
		//RowBounds rb = new RowBounds(skip,max);
		//===>rb를 통해 조회할 행의 범위설정이 가능 : start=스킵할 행의수, max=조회할 최대 행의수
		
		RowBounds rb = new RowBounds(start,max);
		return sqlsession.selectList("mboard.selectAll",null ,rb);
		//								호출 id			
	}

	@Override
	public BoardVO select(int bno) {
		return sqlsession.selectOne("mboard.select",bno);
	}

	@Override
	public boolean update(BoardVO board) {
		int t = sqlsession.update("mboard.update",board);
		if(t==1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int bno) {
		int t = sqlsession.delete("mboard.delete",bno);
		if(t==1) {
			return true;
		}
		return false;
	}
	
	@Override
	public int totalCount() {
		return sqlsession.selectOne("mboard.totalCount");
	}

}
