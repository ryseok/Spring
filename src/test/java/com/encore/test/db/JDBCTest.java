package com.encore.test.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	//JDBC 연결 테스트 코드 만들기
	@Test
	public void testConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		System.out.println("DB연결 성공!!");
	}

	@Test
	public void testConnection2() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// try-with구문: JDK7버전부터 지원
		// 형식) try(AutoCloseable객체){작업}catch(Exception e){예외처리}
		// ---> finally{ conn.close(); } 문 생략하는 것이 가능
		try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger")) {
			System.out.println("DB연결 성공2!!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
