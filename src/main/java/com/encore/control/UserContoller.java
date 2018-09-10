package com.encore.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;
import com.encore.service.UserService;

@Controller
@RequestMapping("user")
public class UserContoller {
	@Inject
	private UserService service;
	
	@RequestMapping("login")
	public String loginGET() {
		return "user/login";
	}
	
	@RequestMapping("loginPost")
	public String loginPOST(LoginDTO dto,Model model) throws Exception { //<form>안에 데이터들을 dto로 묶어 준다
		UserVO vo = service.login(dto); //DB에서 id,pass확인해서 결과 값을 VO 리턴
		
		if(vo != null) { //로그인 성공시 사용자 정보를 저장하고 페이지 이동
			model.addAttribute("userVO",vo);		
		}//===>로그인 실패시 단순 페이지 이동
		
		return "user/loginPost";
	}
}
