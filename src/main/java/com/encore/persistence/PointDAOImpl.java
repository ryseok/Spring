package com.encore.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public boolean updatePoint(String userid, int point) throws Exception {
		Map<String, Object> map = new HashMap<>();
		  map.put("userid", userid);
		  map.put("point", point);  
		int t = sqlSession.update("point.updatePoint", map);
		//t:수정된 행의 갯수
		if(t==1)return true;
		return false;
	}//updatePoint

}