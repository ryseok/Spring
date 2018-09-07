package com.encore.control;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.MsgVO;
import com.encore.service.MsgService;

@RestController
public class MsgController {
	@Inject
	private MsgService service;
	
	@RequestMapping(value="/msg",method=RequestMethod.POST)
	public String addMessage(MsgVO msg) {
		try {
			service.addMsg(msg);
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "FAIL";
	}
}//class
