package com.encore.control.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CntTestController {

	//follow 증가 또는 감소 TEST
	@RequestMapping("cnt")
	public String cnt() {
		return"test/cntTest/cnt";
	}
	
	
}
