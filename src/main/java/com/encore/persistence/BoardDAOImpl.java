package com.encore.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.BoardVO;

@Repository //저장 객체
public class BoardDAOImpl implements BoardDAO{
	//제목 		: 게시판 만들기 미션
	//작성자 		: rys
	//날짜 		: 2018.08.30
	
	//Impl 클래스의 주된 업무는 (XML내의)sql문 호출
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insert(BoardVO boardVo) throws Exception {
		//session.insert("네임스페이스명.아이디명",전달데이터);
		//System.out.println("입력VO: "+ boardVo);
		sqlSession.insert("board.insert",boardVo);
		
	}

	@Override
	public void update(BoardVO boardVo) {
		sqlSession.update("board.modify",boardVo);
	}

	@Override
	public BoardVO read(int bno) {
		return sqlSession.selectOne("board.read", bno);
	}

	@Override
	public List<BoardVO> selectAll() {
		return sqlSession.selectList("board.selectAll");
	}

	@Override
	public void delete(int bno) {
		sqlSession.delete("board.delete", bno);
	}


}
