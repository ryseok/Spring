package com.encore.myapp.review;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.domain.EmpVO;
import com.encore.persistence.EmpDAO;

@Controller
public class ReEmpController {
	
	@Inject
	private EmpDAO dao;
	
	@RequestMapping(value="reSearch",method=RequestMethod.GET)
	public String reSearch() {
		return "review/re_scott";
	}
	
	@RequestMapping(value="reSearch",method=RequestMethod.POST)
	public @ResponseBody EmpVO  result(String ename) {
		return dao.empSelect(ename);
	}
}
