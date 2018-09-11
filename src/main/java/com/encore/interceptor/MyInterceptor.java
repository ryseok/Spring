package com.encore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter{

//	@Override
//	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
//			throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView mav)
			throws Exception {
		System.out.println("===후 처리===");
//		mav.addObject("저장ksy",Object 저장데이터); //모델저장
//		mav.setViewName("이동path");				//뷰설정
		Object result = mav.getModel().get("result");
		System.out.println("result===>" + result);
		if(result != null) {
			request.getSession().setAttribute("msg", result);
			response.sendRedirect("hello");
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object handler) throws Exception {
		System.out.println("===전 처리===");
		
		//요청 URL에 대한 호출 메서드(클래스) 정보
		HandlerMethod method = (HandlerMethod) handler;
		
		System.out.println("method===>" + method.getMethod());
		System.out.println("메서드를 포함한 클래스 정보 : " + method.getBean());
		return true;
	}
	
}
