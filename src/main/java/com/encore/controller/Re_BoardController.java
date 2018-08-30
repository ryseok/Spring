package com.encore.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.encore.domain.Re_BoardVO;
import com.encore.persistence.Re_BoardDAO;

@Controller
public class Re_BoardController {
	@Inject
	private Re_BoardDAO reBoardDao;
	
	@RequestMapping(value="reviewInForm", method=RequestMethod.GET)
	public String reviewInForm() throws Exception{
		return "review/reForm";
	}
	
	@RequestMapping(value="reviewInForm", method=RequestMethod.POST)
	public String reviewOutput(Re_BoardVO reBoard) throws Exception{
		reBoardDao.create(reBoard);
		return "redirect:/reviewList";
	}
	
	@RequestMapping("reviewList")
	public String reviewList(Model model) throws Exception{
		model.addAttribute("list2",reBoardDao.readAll());
		return "review/reList";
	}
}
