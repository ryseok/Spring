package com.encore.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO{
	//sql문 호출(XML 문서내의)
	@Inject
	private SqlSession sqlSession;
	

	@Override
	public EmpVO empSelect(String ename) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("emp.empSelect",ename);
	}


}
