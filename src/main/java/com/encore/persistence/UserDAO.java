package com.encore.persistence;

import java.util.Date;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	public UserVO keepLogin(String userid, String sessionId, Date next) throws Exception;
	public UserVO checkUserWithSessionKey(String value)throws Exception;
}
