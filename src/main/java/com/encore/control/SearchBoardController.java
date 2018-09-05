package com.encore.control;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.domain.PageMaker;
import com.encore.domain.SearchCriteria;
import com.encore.service.BoardService;

@Controller
@RequestMapping("sboard")
public class SearchBoardController {
	@Inject
	BoardService service;
	
	@RequestMapping("list")
	public String listPage(SearchCriteria cri,Model model) throws Exception {		
		model.addAttribute("cri",cri);
		model.addAttribute("list",service.listCriteria(cri));
		
		//하단번호
		PageMaker pageMaker = new PageMaker();
		  pageMaker.setCri(cri);
		  pageMaker.setTotalCount(service.listCount());
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "/sboard/list";
	}
}
