<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력폼(미션)</title>
</head>
<%-- 제목 		: 게시판 만들기 미션 	--%>
<%-- 작성자 		: rys 			--%>
<%-- 날짜 		: 2018.08.30 	--%>
<%-- 파일명  		: form.jsp		--%>
<body>
	<h1>입력폼</h1>
	<hr>
	<form method="post">
	<input type="text" name="title" placeholder="제목 입력하시오">
	<br><br>
	<textarea rows="10" cols="22" name="content" placeholder="내용 입력하시오"></textarea>
	<br><br>
	<input type="text" name="writer" placeholder="작성자 입력하시오">
	<br>
	<button>등록</button>
	</form>
</body>
</html>