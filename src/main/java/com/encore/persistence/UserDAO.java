package com.encore.persistence;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
}
