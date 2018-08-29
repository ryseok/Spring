package com.encore.persistence;

import com.encore.domain.MemberVO;

public interface MemberDAO {
	public String getTime();
	
	public void insertMember(MemberVO vo);
}
