package com.encore.control;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	//uploadForm 보이기
	//===> views 밑에 JSP 파일을 만드는 경우 리턴값 명시 안해도 찾아줌
	@RequestMapping(value="uploadForm", method=RequestMethod.GET)
	public void uploadForm() {
		
	}
	
	//<form action="" id="from1" method="post" enctype="multipart/form-data">
	//===> 데이터의 처리는 프로젝트의 시작단게에서 적용한 multipartResolver 설정하여 처리됨
	@RequestMapping(value="uploadForm", method=RequestMethod.POST)
	public String uploadFormResult(MultipartFile file, Model model) throws Exception{
		System.out.println("업로드 확인>>>" + file.getSize());
		//===>file.getSize() 정보추줄 하기위 한 작업, 즉 테스트 작업
		
		String savedName = uploadFile(file.getOriginalFilename(),file.getBytes());
		
		model.addAttribute("savedName",savedName);
		
		return "uploadResult";
		
	}
	
	private String uploadFile(String originalName, byte[] fileData) throws IOException {
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath,savedName);
		
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}

	@Resource(name="uploadPath")
	private String uploadPath;
}
