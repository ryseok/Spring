package com.encore.service;

import java.util.Date;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;

public interface UserService {
   public UserVO login(LoginDTO dto)throws Exception;
   
   public void keepLogin(String userid, String sessionId,Date next)throws Exception;
   public UserVO checkLoginBefore(String value)throws Exception;
}