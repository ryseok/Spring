package com.encore.myapp.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.myapp.s0823.Person;

@Controller
public class Test02 {
	
	@RequestMapping("personTest")
	public @ResponseBody Person personTest() {
		Person person = new Person("나영석", 40, "피디");
		return person;
	}
}
