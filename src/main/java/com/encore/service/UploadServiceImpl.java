package com.encore.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.encore.domain.UploadVO;
import com.encore.persistence.UploadDAO;

@Service
public class UploadServiceImpl implements UploadService{

	@Inject
	UploadDAO uploadDAO; 
	
	@Override
	public void insert(UploadVO uploadVO) throws Exception {
		uploadDAO.insert(uploadVO);
		
	}

}
