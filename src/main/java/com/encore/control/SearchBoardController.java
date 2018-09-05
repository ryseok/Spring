package com.encore.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.BoardVO;
import com.encore.domain.Criteria;
import com.encore.domain.PageMaker;
import com.encore.domain.SearchCriteria;
import com.encore.service.BoardService;

@Controller
@RequestMapping("sboard")
public class SearchBoardController {
	@Inject
	BoardService service;

	// 입력폼 보이기
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String registerGET() throws Exception {
		return "sboard/register";
		// ===>WEB-INF/views/board/register.jsp
	}

	// DB입력
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes attr) throws Exception {
		service.regist(board);
		// System.out.println("DB등록!!!");
		attr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:list";
	}

	@RequestMapping("/list")
	public String listPage(SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("cri", cri);
		// model.addAttribute("list",service.listCriteria(cri));
		model.addAttribute("list", service.listSearchCriteria(cri));

		// 하단번호
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		// pageMaker.setTotalCount(service.listCount());
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

		return "/sboard/list";
	}

	@RequestMapping("readPage") // 게시물 읽기 요청
	public String readPage(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		model.addAttribute("boardVO", service.read(bno));// 영역에 공유데이터 저장
		// model.addAttribute("cri", cri);//영역에 공유데이터 저장

		return "sboard/readPage";
	}

	@RequestMapping(value = "modifyPage", method = RequestMethod.GET) // 게시물 수정폼
	public String modGET(Model model, int bno, @ModelAttribute("cri") SearchCriteria cri) throws Exception {
		model.addAttribute("boardVO", service.read(bno));
		return "sboard/modifyPage";
	}

	@RequestMapping(value = "modifyPage", method = RequestMethod.POST) // 게시물 DB수정
	public String modPOST(BoardVO board, SearchCriteria cri, RedirectAttributes attr) throws Exception {
		service.modify(board);// 수정작업
		attr.addFlashAttribute("msg", "SUCCESS");

		// list.jsp를 호출하면서 유지해야 하는 URL 파라미터String 정의!!
		// cri.setPage(2);
		//System.out.println(">>>>" + cri);
		attr.addAttribute("page",cri.getPage());
		attr.addAttribute("perPageNum",cri.getPerPageNum());
		attr.addAttribute("searchType",cri.getSearchType());
		attr.addAttribute("keyword",cri.getKeyword());

		return "redirect:list";// 수정작업확인
	}

	// 삭제
	@RequestMapping(value = "removePage", method = RequestMethod.POST)
	public String delete(@RequestParam("bno") Integer bno, RedirectAttributes attr,SearchCriteria cri) throws Exception {
		service.delete(bno);
		attr.addFlashAttribute("msg", "SUCCESS");
		attr.addAttribute("page",cri.getPage());
		attr.addAttribute("perPageNum",cri.getPerPageNum());
		attr.addAttribute("searchType",cri.getSearchType());
		attr.addAttribute("keyword",cri.getKeyword());
		return "redirect:list";
	}
}
