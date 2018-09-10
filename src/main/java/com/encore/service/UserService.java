package com.encore.service;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
}
