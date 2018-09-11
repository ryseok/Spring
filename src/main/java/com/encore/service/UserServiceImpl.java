package com.encore.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;
import com.encore.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}

	@Override
	public void keepLogin(String userid, String sessionId, Date next) throws Exception {
        dao.keepLogin(userid, sessionId, next);
	}

	@Override
	public UserVO checkLoginBefore(String value) throws Exception {
		return dao.checkUserWithSessionKey(value);
	}

}