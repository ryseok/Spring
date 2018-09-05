package com.encore.control;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.ReplyVO;
import com.encore.service.ReplyService;

//Ajax 전용 컨트롤러
@RestController
//===>Ajax 요청에 대한 응답데이터를 출력하는 용도로 사용한다.
//===>@RestController 사용하면 각 메소드에 @ResponseBody를 정의하지 않아도 된다.
//===>@RestController와 @ResponseBody 공통점 : JSP페이지를 사용하지 않겠다.
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService service;
	
//	1. public void register() {}
//	2. public ResponseEntity<T> register() {}
//	1번과 2번 공통점은 클라이언트(브라우저)에게 문자열,VO,List 전달
//	1번과 2번 차이점은 2번은 데이터와 함께 서버의 HTTP(조작된)상태코드를 전달할 수 있다
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> register(ReplyVO reply) {
		//ResponseEntity<클라이언트에게 전달할 자료형>
		ResponseEntity<String> entity = null;
		try {
			service.addReply(reply);
			
			entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			//입력 실패
			entity = new ResponseEntity<>("FAIL",HttpStatus.BAD_REQUEST);
			//===>HttpStatus.BAD_REQUEST : BAD_REQUEST은 400
			e.printStackTrace();
		}
		
		return entity;
	}
	
}
