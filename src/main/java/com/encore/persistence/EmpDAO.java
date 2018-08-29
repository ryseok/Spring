package com.encore.persistence;

import com.encore.domain.EmpVO;

public interface EmpDAO {
	//EmpController와 EmpDAOImpl클래스를 연결해 주는 객체
	//두 클래스의 관계를 느슨하게 하여서 Impl을 쉽게 변경할 수 있도록 함
	//===>유지보수에 유리함
	public EmpVO empSelect(String ename);
	
	
}
