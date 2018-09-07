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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.domain.Criteria;
import com.encore.domain.PageMaker;
import com.encore.domain.ReplyVO;
import com.encore.service.ReplyService;



@RestController//Ajax전용 컨트롤러!!
//Ajax요청에 대한 응답데이터(String,{key:value},[{},{}])를 출력하는 용도로 사용한다.
//           return    "안녕"     VO       List<VO>
//@RestController을 사용하면 각 메소드에 @ResponseBody를 정의하지 않아도 된다!!
//   ---->                            ----->   공통점:  JSP페이지를 사용하지 않겠다.
@RequestMapping("/replies")
public class ReplyController {
   
	@Inject
	private ReplyService service;

	/*
	1. public String,VO,List register() {}
	2. public ResponseEntity register() {}
	
	===> 1번과 2번의 공통점? 클라이언트(브라우저)에게 String,VO,List 전달 
	===> 1번과 2번의 차이점? 2번은 데이터와 함께 서버의 HTTP(조작된)상태코드 를 전달할 수 있다
	                                           ----> 예) 200, 400, 404, 500
	*/
	
	
	/*
	  <요청예상?>
	  $.ajax({
	           url:'/replies',
	           type:'post',
	           data:{
	               bno:120,
	               replytext:'댓글추가',
	               replyer:'길동이'
	           },
	           headers:{
	              'Content-Type':'application/json'   ----> 보낼 데이터의 형식Type정의
	           },
	           dataType:'json',                       ----> 받을 데이터의 형식Type정의
	           success:function(result){
	              console.log(result)===> 'SUCCESS'출력
	           }
	         });
	  
	 */
	
	//댓글입력
	//@ResponseBody : VO ---> JSON
	//@RequestBody : JSON ---> VO    : 보내는 쪽에서 JSON명시를 해야함
	@RequestMapping(value="", method=RequestMethod.POST)
	public  ResponseEntity<String> register(@RequestBody ReplyVO reply) {

		
		//ResponseEntity<클라이언트에게 전달할 자료형>
		
		ResponseEntity<String> entity=null;
		try {
			service.addReply(reply);
			entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);//200
		} catch (Exception e) {
			//입력실패
			entity = new ResponseEntity<>("FAIL",HttpStatus.BAD_REQUEST);//400
			e.printStackTrace();
		}
		
		return entity;
	}//register
	
	
	//특정 게시물에 대한 전체 댓글 조회
	           //실제요청  ===> /replies/all/120
	@RequestMapping(value="/all/{bno}",method=RequestMethod.GET)
	//{bno} ---> 파라미터의 역할
	public List<ReplyVO> list(@PathVariable("bno")int bno) {
		List<ReplyVO> list=null;
         try {
			 list= service.listReply(bno);
		} catch (Exception e) {
			e.printStackTrace();
		}
         return list;
	}//list
	
	//페이징된 댓글
	//실제요청: /replies/120/2    ===> 120:글번호, 2:2페이지
	@RequestMapping(value="/{bno}/{page}",method=RequestMethod.GET)
	public Map<String, Object> listPage(@PathVariable("bno") int bno,
			             @PathVariable("page") int page) {
		
		List<ReplyVO> list = null;
		Map<String, Object> map = new HashMap<>();
		
		try {
			Criteria cri = new Criteria();//기본값: 1페이지, 10개의 레코드
			cri.setPage(page);//2페이지 , 10개의 레코드
			
			PageMaker pageMaker = new PageMaker();//번호(생성)출력 
			  pageMaker.setCri(cri);//현재페이지에 대한 정보
			  int totalCount = service.count(bno);
			  pageMaker.setTotalCount(totalCount);//마지막페이지 Number
			//1페이지(예:1 2 3 4 5 6 7 8 9 10)
			//2페이지(예:11 12 13 14 15)			
			
			list = service.listReplyPage(bno, cri);//페이징된(범위:cri) 댓글 조회
			
			//pageMaker와 list정보를 한개의 변수(객체)에 저장!!  ===> Map
			  map.put("list", list);
			  map.put("pageMaker", pageMaker);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return list;//[{VO},{VO}]
		return map;//{"list":[{VO},{VO}],"pageMaker":pageMaker}

	}//listPage
	
	
	//특정 댓글 수정
	              //실제요청 ===> /replies/5 
	@RequestMapping(value="/{rno}",method= {RequestMethod.PUT, RequestMethod.PATCH} )
	public ResponseEntity<String> update(@PathVariable("rno")int rno,
			           @RequestBody ReplyVO reply)//수정할 데이터 
	{
		System.out.println(">>>Controller수정요청!!");
		ResponseEntity<String> entity=null;
		//데이터와 함께 (조작된)서버에 상태(status)를 전달
		
		try {
			reply.setRno(rno); //URL경로를 통해 전달받은 rno값을 VO에 설정.
			service.modifyReply(reply);
			//return "SUCCESS";
			entity= new ResponseEntity<String>("SUCCESS",HttpStatus.OK);//200
		} catch (Exception e) {
			e.printStackTrace();
			//return "FAIL";
			entity= new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);//400
		
		}
		
		return entity;
	}//update
	
	//댓글삭제
	           //실제요청URL==> /replies/4
	@RequestMapping(value="/{rno}",method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
	   try {
			service.removeReply(rno);
			return new ResponseEntity<String>("SUCCESS",HttpStatus.OK);//200
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("FAIL",HttpStatus.BAD_REQUEST);//400
		}
	}//remove
}








