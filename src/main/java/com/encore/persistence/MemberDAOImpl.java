package com.encore.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.MemberVO;

@Repository //저장소(DB관련) 객체
public class MemberDAOImpl implements MemberDAO{
	/*           <ibatis>                           <mybatis>  
	호출객체      SqlMapClient                          SqlSession
	DML호출      insert(),delete(),update()            insert(),delete(),update()
	DQL호출      queryForObject(String id,Object val)  selectOne(String id,Object val)
	         queryForList()                        selectList()
    NameSpace     권장                                                            필수	         
	파라미터처리       #username#                         #{username}
	속성              resultClass, parameterClass           resultType, parameterType 
	 */

	//sql문 호출(XML 문서내의)
	@Inject
	private SqlSession session;
	
	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return session.selectOne("member.getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		session.insert("member.insertMember",vo);
		
	}

}
