package com.encore.s0827;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YouController {
	
	@RequestMapping("you/hello")
	public String hello() {
		return "0827/hello";
	}
	
	@RequestMapping("you/input")
	public String input(HttpServletRequest request) {
		String username = request.getParameter("username");
		System.out.println(username);
		return "0827/name_input";
	}
	
	@RequestMapping("you/calc")
	public String calc() {
		return "0827/calc_form";
	}
}
