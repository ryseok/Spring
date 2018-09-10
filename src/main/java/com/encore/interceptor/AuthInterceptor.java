package com.encore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	//사용자 인증 인터셉터 : 인증하지 않은 사용자는 로그인 폼으로 이동
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		//세션영역에 로그은 정보가 있는지?
		//로그인 성공을 했다면 '세션영역'에 key 'login'에 사용자 정보 UserVO가 저장되었음
		if(session.getAttribute("login") == null) {
			System.out.println("인증실패");
			
			//페이지이동 전 현재페이지를 저장
			saveDest(request);
			
			response.sendRedirect("/user/login");
			return false;
		}
		return true;
	}
	
	private void saveDest(HttpServletRequest req) { 
		//인증 실패로 인한 로그인폼으로 가기전 현재페이지에 대한 경로를 'dest'키에 저장
		//===>왜? : 로그인 성공후 진행했던 페이지로 다시 되돌아 오기 위해
		String uri = req.getRequestURI(); // sboard/modifyPage
		String query = req.getQueryString(); //bno=120
		if(query==null || query.equals("null")) {
			query = "";
		}else {
			query = "?"+query;
		}
		
		if(req.getMethod().equals("GET")) {
			req.getSession().setAttribute("dest", uri+query);
		}
	}
}
