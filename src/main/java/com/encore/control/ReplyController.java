package com.encore.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.Criteria;
import com.encore.domain.PageMaker;
import com.encore.domain.ReplyVO;
import com.encore.service.ReplyService;
//날짜	 : 180905
//작성자	 : rys
//제목	 : 댓글
//파일명	 : ReplyController.java



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
	
	/*
	      <<JSP>>                               <<Controller>>
	     data:{
	       replytext:'안녕'                    method(VO vo)
	       replyer:'길동'                    
	     }  
	     ----------------------------------------------------
	     data:JSON.stringify({
	       replytext:'안녕'                     method(@RequestBody VO vo)
	       replyer:'길동'                    
	     }),  
	     headers:{  
       'Content-Type':'application/json'
         }
	 */
	
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO reply) {
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
	
	//특정 게시물에 대한 전체 댓글 조회
	@RequestMapping(value="all/{bno}",method=RequestMethod.GET)
	//===>{bno} 파라미터 역할
	
	public List<ReplyVO> list (@PathVariable("bno") Integer bno) throws Exception {
		List<ReplyVO>  list = service.listReply(bno);
		return list;
	}
	
	//댓글 수정
	//실제 요청 : /replies/0
	@RequestMapping(value="/{rno}",method= {RequestMethod.PUT,RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rno") int rno,
			@RequestBody ReplyVO reply) {
		//System.out.println("수정요청!!!");
		//데이터와 함께 서버에 상태를 전달
		ResponseEntity<String> entity = null;
		try {
			//URL 경로를 통해 전달받은 rno값을 VO에 설정
			reply.setRno(rno);
			
			service.modifyReply(reply);
			//return "SUCCESS";
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			//return "FAIL";
			e.printStackTrace();
			entity = new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
		try {
			service.removeReply(rno);
			return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);
		}
	}
	
	//페이징된 댓글
	//실제 요청은 : /replies/120/1
	@RequestMapping(value="{bno}/{page}", method=RequestMethod.GET)
	public Map<String, Object> listPage(@PathVariable("bno") int bno,@PathVariable("page") int page) {
		List<ReplyVO> list = null;
		Map<String, Object> map = new HashMap<>();
		try {
			Criteria cri = new Criteria();			//기본 페이지 : 1페이지,10개의 레코드
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker(); 	//번호 출력
			pageMaker.setCri(cri);					//현재페이지에 대한 정보
			int totalCount = service.count(bno);
			pageMaker.setTotalCount(totalCount);	//마지막 페이지 Number
			
			list = service.listReplyPage(bno, cri);	//페이징된(범위 : cri) 댓글 조회
			
			map.put("list", list);					//pageMaker와 list정보를 한개의 변수에 저장
			map.put("pageMaker", pageMaker);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return list;
		return map;
	}
}
