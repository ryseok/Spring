package com.encore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override //RequestMapping 전
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login"); //새로운 로그인 정보 저장을 위해 이전 로그인 정보 삭제
			System.out.println("로그인 초기화");
		}
		return true; //RequestMapping("user/loginPost")을 실행해라
	}
	
	@Override//RequestMapping 후
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		
		ModelMap map =  modelAndView.getModelMap();
		Object userVO =  map.get("userVO");
		
		if(userVO != null) { //로그인 성공 했다면
			System.out.println("새로운 로그인 성공");
			session.setAttribute("login", userVO);
			//response.sendRedirect("/"); //로그인 성공하면 홈페이지 이동
			Object dest = session.getAttribute("dest");
			response.sendRedirect((dest != null)? (String) dest:"/");
		}
		//로그인 실패 하면 "loginPost.jsp ===> /sboard/list"
	}
}
