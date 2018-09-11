package com.encore.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

	@Override
	public UserVO keepLogin(String userid, String sessionId, Date next) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("sessionId", sessionId);
		map.put("next", next);
		
		sqlSession.update("user.keepLogin",map);
		return null;
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) throws Exception {
		
		return sqlSession.selectOne("user.checkUserWithSessionKey", value);
	}

}
