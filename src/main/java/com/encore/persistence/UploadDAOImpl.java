package com.encore.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.UploadVO;

@Repository
public class UploadDAOImpl implements UploadDAO{

	@Inject
	SqlSession session;
	
	@Override
	public void insert(UploadVO uploadVO) throws Exception {
		session.insert("upload.insert",uploadVO);
		
	}

}
