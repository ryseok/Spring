package com.encore.control;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.domain.PageMaker;
import com.encore.service.BoardService;

//작성일 		: 180904
//수업내용 	: 페이징처리 복습
//작성자 		: rys
//파일명 		: MyBoardController.java

@Controller //컨트롤러 선언
@RequestMapping("mboard")
public class MyBoardController {
	@Inject
	private BoardService service;
	
	//입력폼 보이기
	//가상경로 : @RequestMapping
	@RequestMapping(value="register",method=RequestMethod.GET)
	public String m1() {
		//실제경로 : return
		return "board/register"; 
	}

	//DB입력
	//가상경로 : @RequestMapping
	@RequestMapping(value="register",method=RequestMethod.POST) 
	public String m2(BoardVO board,RedirectAttributes attr) {
		//board값을 DB에 넣어라
		//프로그램 순서 : Controller ===> Service ===> DAO ===> SQL(SML)
		if(service.create(board)) { //입력이 성공 했다면
			//리다이렉트 이동하는 페이지와 공유
			attr.addFlashAttribute("msg","success");
		}
		
		//실제경로 : return
		return "redirect:list"; 
	}
	
	//목록조회
	@RequestMapping("list")
	public String m3(Model model, Criteria cri) {
		//List<BoardVO> list = service.listAll(); //from DB ===> 데이터생성
		//model.addAttribute("list",list);
		//===>model.addAttribute("list",service.listAll());
		
//		page	start	perPageNum
//		1		0		10
//		2		10		10
//		3		20		10
		
//		start = (page-1)*perPageNum 왜? perPageNum이 변경가능 하므로
		//System.out.println("cri page==>" + cri.getPage());
		//System.out.println("cri perPageNum==>" + cri.getPerPageNum());
		model.addAttribute("list",service.listAll(cri.getPageStart(),
                								  cri.getPerPageNum()));
		
		PageMaker maker = new PageMaker();
			maker.setCri(cri);
			maker.setTotalCount(service.listCount());
			
		model.addAttribute("maker",maker);
		return "board/list";
	}
	
	//특정번호 조회
	@RequestMapping("read")
	public String m4(int bno, Model model) {
		model.addAttribute("board",service.read(bno));
		return "board/read";
	}
	
	//수정폼 보이기
	@RequestMapping(value="modify",method=RequestMethod.GET)
	public String m5(int bno,Model model) {
		model.addAttribute("board",service.read(bno));
		return "board/modify";
	}

	//DB수정 요청
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public String m6(BoardVO board,RedirectAttributes attr) {
		if(service.update(board)) { //수정 성공
			attr.addFlashAttribute("msg","success");
		}else { //수정 실패
			attr.addFlashAttribute("msg","upfail");
		}//if ~ else
		return "redirect:list";
	}
	
	//DB 삭제요청
	@RequestMapping("remove")
	public String m6(int bno, RedirectAttributes attr) {
		if(service.delete(bno)) {
			attr.addFlashAttribute("msg","success");
		}
		return "redirect:list";
	}
}
