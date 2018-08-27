package com.encore.s0827;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.myapp.s0823.Person;

@Controller
@RequestMapping("you") //공통된 경로는 클래스위에 등록
public class YouController {
	
	@RequestMapping("hello")
	public String hello() {
		return "0827/hello";
	}
	
	//name_input 방법1
	@RequestMapping("input")
	public String input(HttpServletRequest request) {
		String username = request.getParameter("username");
		System.out.println("입력된 이름 : "+username);
		return "0827/name_input";
	}

	//name_input 방법2 : 알아서 request.getParameter("username"); 해줌
	@RequestMapping("result")
	public String input(String username) { //<input type="text" name="username">
		System.out.println("입력된 이름 : "+username);
		return "0827/result";
	}

	//name_input Person 추가해서 콘솔 출력
	@RequestMapping("result2")
	public String input(Person p,String username) {
		System.out.println("입력된 이름 : "+username);
		System.out.println("입력된 사람정보 : "+p);
		return "0827/result";
	}
	
	//미션 실패...(답 봄)
	@RequestMapping(value="calc",method=RequestMethod.GET)
	public String calcGET() {
		System.out.println("GET 요청");
		//계산폼 보이기
		return "0827/calc_form";
	}

	@RequestMapping(value="calc",method=RequestMethod.POST)
	public String calcPOST(String su1, String su2, String oper,
							HttpServletRequest requset) {
		System.out.println("POST 요청");
		//계산 결과를 저장후 폼 보이기
		Calculator calc = new Calculator(Integer.parseInt(su1) , Integer.parseInt(su2), oper);
		requset.setAttribute("result",calc.getResultStr());
		return "0827/calc_form";
	}
	
	@RequestMapping("doD")
	public String doD(Model model) {
		ProductVO vo = new ProductVO("샘플 상품", 100000);
		//방법1
		//model.addAttribute("vo",vo); //==requset.setAttribute("vo",vo);
		
		//방법2
		model.addAttribute(vo); //==requset.setAttribute("productVO",vo);
		//===> 만약 키값을 정의하지 않는다면 vo의 데이터타입(ProductVO)의 첫글자를 소문자로 하는 키가 설정됨
		return "0827/prodouctDetail";
	}
	
	@RequestMapping("doE")
	public String doE(Model m ,RedirectAttributes attr) {
		ProductVO vo = new ProductVO("꿀", 50000);
		attr.addFlashAttribute("vo",vo);
		//return "redirect:/resources/prodouctDetail.jsp";
		//===>직접 JSP페이지 명시하면 RedirectAttributes 공유 안됨
		
		return "redirect:doF";
	}

//	@RequestMapping("doF")
//	public String doF() {
//		return "0827/prodouctDetail";
//	}
	
	@RequestMapping("doF")
	public String prodouctDetail() {
		return "0827/prodouctDetail";
	}
}
