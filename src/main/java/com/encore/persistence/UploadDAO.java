package com.encore.persistence;

import com.encore.domain.UploadVO;

public interface UploadDAO {
	public void insert(UploadVO uploadVO) throws Exception;
}
