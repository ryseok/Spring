package com.encore.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.encore.domain.UserVO;
import com.encore.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	//사용자 인증 인터셉터 : 인증하지 않은 사용자는 로그인 폼으로.....이동!!
	
	@Inject
	private UserService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {//로그인 하지 않은 사용자를 '로그인폼'으로 이동
	    
		HttpSession session = request.getSession();
		
		//세션영역에 로그인 정보가 있는지?
		//로그인 성공을 했다면 '세션영역'에  key "login"에 사용자 정보 UserVO가 저장되어있음.
		if(session.getAttribute("login") == null) {
		//로그인 인증되지 않은 사용자라면!!(예전)   -----> 로그인 폼으로 이동!!
		//로그인 인증되지 않은 사용자라면!!(변경)   -----> 만약 저장된 세션정보가 있다면 ----> 진행(쓰기,수정,삭제)	
			
		   System.out.println(">>>현재 로그인 거치지 않음!!");
		   
		   //페이지이동 전  현재페이지를 저장
		   saveDest(request);
		   
		   Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		   //사용자 로컬PC의 쿠키값 얻어오기
		   
		   System.out.println(">>>이전에 PC에 쿠키저장을 한적이 있는가? "+ loginCookie);
		   if(loginCookie != null) {
		  //이전에 로그인 성공을 한 적이 있고 'remember me 쿠키'를 저장한 적이 있다면
			  UserVO userVO =  service.checkLoginBefore(loginCookie.getValue());
			   System.out.println(">>>쿠키에 매핑된 사용자 정보가 있는가? "+ userVO);
			  if(userVO != null) {//만료날짜 이전을 만족하는 세션이 있다면
				  session.setAttribute("login", userVO);
				  return true;//RequestMapping("path")을 진행
			  }
		   }
		   
	       response.sendRedirect("/user/login");//로그인 폼으로 .... 이동!!	
		   return false;	
		}
		
		return true;//RequestMapping("path")을 진행
	}//preHandle
	
	private void saveDest(HttpServletRequest req) {
    //인증 실패하면 로그인폼으로 이동!!
    //로그인폼 이동전  [현재페이지에 대한 경로를 'dest'키에 저장]!!
    //왜? 로그인 성공후  진행했던 페이지로 다시 되돌아 오기 위해!!
      String uri = req.getRequestURI();//   /sboard/modifyPage
      String query = req.getQueryString();//    bno=120
      if(query == null || query.equals("null")) {
    	  query="";  
      }else {
    	  query = "?"+query;  //   ?bno=120
      }
      if(req.getMethod().equals("GET")) {
    	  req.getSession().setAttribute("dest", uri+query);
    	 //.setAttribute("dest","/sboard/modifyPage?bno=120")
      }
		
	}
	
	
	
	

}