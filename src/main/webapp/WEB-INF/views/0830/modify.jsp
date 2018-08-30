<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정폼</title>
</head>
<%-- 제목 		: 게시판 만들기 미션 	--%>
<%-- 작성자 		: rys 			--%>
<%-- 날짜 		: 2018.08.30 	--%>
<%-- 파일명  		: modify.jsp	--%>
<body>
  <h3>수정폼</h3>
  <hr>
  <form method="post">
     글번호: <input type="text" name="bno" readonly value="${board.bno }"> <br>
     제목: <input type="text" name="title" value="${board.title }"> <br>
     내용: <textarea rows="5" cols="25" name="content">${board.content }</textarea> <br>
     작성자: <input type="text" name="writer" value="${board.writer }"> <br>
     <button type="submit">등록</button>
     <a href="/spTest/board/list"><button type="button">취소</button></a>
  </form>
</body>
</html>


