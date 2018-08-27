package com.encore.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.myapp.s0823.Person;

@Controller
public class ReviwController {

	@RequestMapping("re_input")
	public String input() {
		return "review/re_input";
	}
	@RequestMapping("re_result")
	public String result(Person p, HttpServletRequest request) {
		request.setAttribute("person", p);
		return "review/re_result";
	}
	
}