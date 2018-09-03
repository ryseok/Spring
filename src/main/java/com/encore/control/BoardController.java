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
import com.encore.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	//서비스 호출
	@Inject
	private BoardService service;
	
	//입력폼 보이기
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String registerGET() throws Exception{
		return "board/register";
		//===>WEB-INF/views/board/register.jsp
	}
	
	//DB입력
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes attr) throws Exception{
		service.regist(board);
		//System.out.println("DB등록!!!");
		attr.addFlashAttribute("msg","SUCCESS");	
		return "redirect:listAll";
	}
	
	//목록요청 처리
	@RequestMapping("listAll")
	public String listAll(Model model) throws Exception{
		model.addAttribute("list",service.listAll()); //컨트롤러 영역에서 조회된 결과를 영역저장 - 뷰와 공유
		return "board/listAll";
	}

	//페이징
	@RequestMapping("listCri")
	public String listCri(Criteria cri,Model model) throws Exception{
		model.addAttribute("list",service.listCriteria(cri)); //컨트롤러 영역에서 조회된 결과를 영역저장 - 뷰와 공유
		return "board/listCri";
	}

	@RequestMapping("listPage")
	public String listPage(Criteria cri,Model model) throws Exception{
		//화면에 출력되는 목록(bno,title,writer,regdate,viewcont)
		model.addAttribute("list",service.listCriteria(cri));
		
		//화면하단에 출력되는 번호
		PageMaker maker = new PageMaker();
			maker.setCri(cri);
			maker.setTotalCount(service.listCount());
		
		model.addAttribute("pageMaker",maker);

		//컨트롤러 영역에서 조회된 결과를 영역저장 - 뷰와 공유
		return "board/listPage";
	}
	
	@RequestMapping("read")
	public String read(Integer bno, Model model)throws Exception{
		model.addAttribute("boardVO",service.read(bno));
		return "board/read";
	}

	@RequestMapping("readPage")
	public String read(Integer bno, @ModelAttribute("cri") Criteria cri, Model model)throws Exception{
		model.addAttribute("boardVO",service.read(bno));
		return "board/readPage";
	}
	
	//게시물 수정폼
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String modGET(Model model, int bno)throws Exception{
	   model.addAttribute("boardVO",service.read(bno));
	   return "board/modify";	
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)//게시물 DB수정
	public String modPOST(BoardVO board)throws Exception{
		service.modify(board);//수정작업
		return "redirect:listAll";//수정작업확인	
	}
	
	//삭제
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public String delete(@RequestParam("bno") Integer bno, RedirectAttributes rttr) throws Exception{
		service.delete(bno);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:listAll";
	}
}
