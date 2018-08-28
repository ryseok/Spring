package com.encore.myapp.s0828;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.myapp.s0823.Person;

@Controller
@RequestMapping("0828")
public class WeController {
	
	@RequestMapping("hello")
	public @ResponseBody String doMsg() {
		//return "Hello, Spring"; //요청 브라우저에게 '안녕' 메시지 전달
		//===>리턴"문자열"이 JSP페이지가 아니라 메시지일 경우 @ResponseBody 사용

		return "안녕 스프링"; //요청 브라우저에게 '안녕' 메시지 전달
	}
	
	@RequestMapping("doPerson")
	public @ResponseBody Person doJSON() {
		Person p = new Person("나영석",40,"피디");
		return p;
	}
}
