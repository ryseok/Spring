package com.encore.myapp.review;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.myapp.s0823.Person;

@Controller
public class Test01 {

/*	@RequestMapping("hello")
	public void hello() {

	}*/
	
	@RequestMapping("personInput")
	public String personInput() {
		return"0823/input2";
	}
	
	@RequestMapping("personResult")
	public String personResult(Person person) {
		return "0823/result2";
	}
}
