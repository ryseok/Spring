package com.encore.myapp.s0829;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.domain.EmpVO;
import com.encore.persistence.EmpDAO;

@Controller
public class EmpController {
	
	@Inject
	private EmpDAO dao;
	
	@RequestMapping(value="empInfo",method=RequestMethod.GET)
	public String empInput() {
		return "0829/empInfo";
	}
	
	@RequestMapping(value="empInfo",method=RequestMethod.POST)
	public String empResult(String ename, Model model) {
		System.out.println("ename : "+ename);
		
		//방법 1
		//EmpVO vo = dao.empSelect(ename);
		//model.addAttribute("vo",vo); //JSP페이지 에서는 ${vo.empno}
		
		//방법2
		model.addAttribute("empVO",dao.empSelect(ename)); //JSP페이지 에서는 ${empVO.empno}, 권장 : 키값 작성하자
		
		return "0829/empInfo";
	}
//================Ajax요청,응답
	@RequestMapping(value="empInfo2",method=RequestMethod.GET)
	public String empInput2() {
		return "0829/ajaxEmpInfo";
	}

	@RequestMapping(value="empInfo2",method=RequestMethod.POST)
	public @ResponseBody EmpVO empResult2(String ename) {
		return dao.empSelect(ename);
		//===>응답 : JSP페이지 없이,
		//엔터 치면  : {"empno":"7788","ename":"SCOTT","sal":"3000","deptno":"20"}
		//html 화면에 그래도 나옴
	}
}
