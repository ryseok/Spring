package com.encore.control;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.encore.domain.UserVO;
import com.encore.dto.LoginDTO;
import com.encore.service.UserService;

@Controller
@RequestMapping("/user")
public class UserContoller {
    
	@Inject
	private UserService service;
	
	@RequestMapping("/login")
	public String loginGET() {
		return "/user/login";
	}
	
	@RequestMapping("/loginPost") //로그인 처리
	public String loginPOST(LoginDTO dto,Model model, HttpSession session) throws Exception {//<form>안의 데이터들을 dto로 묶어 전달
	    UserVO vo =service.login(dto);//DB에서 id,pass확인해서 결과값을 vo리턴	
		
	    if(vo!=null) {//로그인성공시 [사용자 정보를 저장하고] 페이지이동	    
	       model.addAttribute("userVO",vo);	
	       
	       if(dto.isUseCookie()) {//만약 로그인 폼에 'v'체크되었다면
	    	   int amount = 60*60*24*7;//7일에 대한 second정보
	    	   Date sessionLimit = new Date(System.currentTimeMillis()+(1000*amount));
	    	                            //현재시간 기준+7일
	    	   
	    	   service.keepLogin(vo.getUserid(), session.getId(), sessionLimit);
	    	   //DB 일치하는'사용자아이디'에 '세션번호','만료날짜'  저장(업데이트)!!
	       }
	       
	    }//로그인실패시 단순 페이지이동
	    
		return "/user/loginPost";
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpServletRequest request,
			             HttpServletResponse response,
			             HttpSession session)throws Exception{
	   Object ob = session.getAttribute("login");
	   if(ob!=null) {//로그인 정보가 있다면
		   UserVO vo = (UserVO) ob;
		   
		   session.invalidate();//서버와의 세션정보 삭제
		   
		   Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		   //브라우저 사용자PC로 부터 'loginCookie'를 key로 해서 저장된 데이터 얻기
		   
		   if(loginCookie!=null) {//저장된 'loginCookie'가 있다면
			   loginCookie.setPath("/");
			   loginCookie.setMaxAge(0);//쿠키 만료기간 없앰.
			   
			   response.addCookie(loginCookie);
			   //사용자 PC에 위에 설정된 값으로 다시 Write!!
			   
			   service.keepLogin(vo.getUserid(), session.getId(),
					             new Date());
			   //DB에  해당User의 sessionId변경
			   //해당User의  sessionLimit를 현재 날짜로 변경함으로써
			   //자동 로그인 되지 않게 함.
			   //----> where sessionlimit > sysdate
		   }
	   }
		
	   return "/user/login";
	}
}




