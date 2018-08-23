package com.encore.myapp;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.myapp.s0823.Person;

@Controller // extends HttpServlet, extends Action 대신
public class MyController {
	private static Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@RequestMapping("doA") // 가상의 경로 설정(/Spring/doA 요청이 들어왔다면)
	public void doA() { // service(request,response) execute(request,response) 대신
		System.out.println("doA 요청");
	}

	// 메소드 이름은 SpringMVC실행시 관여하는 부분이 없다.
	// 위의 doA()메소드의 리턴값이 없다면(void) 요청URL(가상의 경로)이 요청 페이지가 된다.
	// '/WEB-INF/views/'+"doA" + '.jsp'
	// ---> '/WEB-INF/views/doA.jsp'

	@RequestMapping("doB")
	public String doB() {
		logger.info("doB 요청");
		logger.error("에러 무엇?");
		return "hello";
	}

	/*
	 * 리턴 "문자열"은 메소드를 실행후 이동할 페이지에 대한 정보를 담고 있다 Front
	 * Controller(DispatcherServlet)에게 전달(리턴)하면 'servlet-context.xml'파일에 있는
	 * ViewResolver클래스를 통해 '/WEB-INF/views'+ "전달문자열" + '.jsp' 생성. 위의 예는
	 * '/WEB-INF/views/'+ "hello" + '.jsp' 생성. ----> '/WEB-INF/views/hello.jsp'
	 */
	
	//단순 JSP포워딩(URL요청에 대해서 Model 실행없이 JSP페이지만 전달)
	@RequestMapping("input")
	public String rys() {
		//return "input"; 	 //WEB-INF/input.jsp
		
		return "0823/input"; //WEB-INF/0823/input.jsp
	}
	
	@RequestMapping("result")
	public String osr(HttpServletRequest request, HttpSession session) {
		//파라미터 한글의 문자집함 정의(한글깨짐 방지)
		//request.setCharacterEncoding("UTF-8");
	
		String name = request.getParameter("username");
		//request.setAttribute("un", name);
		if(name != null) {
			session.setAttribute("un", name);
		}
		return "0823/result";
	}
	
	@RequestMapping("input2")
	public String id() {
		return "0823/input2";
	}
	
	/*
	@RequestMapping("result2")
	public String idResult(HttpServletRequest request) {
		//input2.jsp를 통해 입력받은 데이터를 얻어오고
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String job = request.getParameter("job");
		
		//그값을 영역에 저장해서 result2.jsp와 공유
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("job", job);
		
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		p.setJob(job);
		request.setAttribute("person", p);
				
		//result2.jsp 전달
		return "0823/result2";
	}*/
	
	
	@RequestMapping("result2")
	public String result2(Person p, HttpServletRequest request) {
		//request.setAttribute("person", p);
		return "0823/result2";
	}
}
