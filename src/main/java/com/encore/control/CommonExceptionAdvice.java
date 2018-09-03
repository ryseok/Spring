package com.encore.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	@ExceptionHandler(Exception.class) // 예외 처리 메소드!!
	public String common(Exception e, Model model) {
		logger.info("모델객체>>> " + model);
		
		logger.info(e.toString());// 에러메시지를 (서버콘솔)화면에 출력
		model.addAttribute("exception", e);
		return "error_common"; // 응답페이지
	}

}