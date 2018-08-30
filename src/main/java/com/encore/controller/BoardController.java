package com.encore.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.BoardVO;
import com.encore.persistence.BoardDAO;

@Controller
@RequestMapping("board")
public class BoardController {
	//제목 		: 게시판 만들기 미션
	//작성자 		: rys
	//날짜 		: 2018.08.30
	
	@Inject
	private BoardDAO dao;
	
	//form폼 보이기
	@RequestMapping(value="form",method=RequestMethod.GET)
	public String form() throws Exception{
		return "0830/form"; //실제경로
	}

	//form폼에서 입력한것을 list에 넘기기
	@RequestMapping(value="form",method=RequestMethod.POST)
	public String formInsert(BoardVO boardVo, RedirectAttributes attr) throws Exception{		
		dao.insert(boardVo);
		String msg="입력 성공";
		attr.addFlashAttribute("msg",msg);
		return "redirect:/board/list"; //실제경로
	}
	
	//목록폼 보기
	@RequestMapping("list")
	public String list(Model model) throws Exception {
		model.addAttribute("list",dao.selectAll());
		return "0830/list"; //실제경로
	}

	//읽기전용
	@RequestMapping("read")
	public String reads(int bno,Model model) throws Exception {
		BoardVO boradVo = dao.read(bno);
				boradVo.setBno(bno);
		model.addAttribute("board",boradVo);
		return "0830/read"; //실제경로
	}
	
	//수정폼
	@RequestMapping(value="modify",method=RequestMethod.GET)
	public String upform(int bno, Model model) throws Exception{
		BoardVO boradVo = dao.read(bno);
				boradVo.setBno(bno);
		model.addAttribute("board",boradVo);
		return "0830/modify"; //실제경로
	}
	
	//수정 후 목록으로 넘기기
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public String formModify(BoardVO boardVo) throws Exception{		
		dao.update(boardVo);
		return "redirect:/board/list"; //실제경로
	}
	
	//삭제 후 목록으로 넘기기
	@RequestMapping(value="delete")
	public String delete(int bno) throws Exception{
		dao.delete(bno);
		return "redirect:/board/list";
	}
}
