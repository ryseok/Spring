package com.encore.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return sqlSession.selectOne("user.login",dto);
	}

}
