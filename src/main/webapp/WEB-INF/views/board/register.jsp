<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 입력폼</title>
</head>
<!--작성일 	: 180904-->
<!--수업내용 	: 페이징처리 복습-->
<!--작성자 	: rys-->
<!--파일명 	: register.jsp(입력폼)-->
<body>
	<h1>입력폼</h1>
	<hr>
	<form method="post">
		타이틀
		<br>
		<input type="text" name="title" placeholder="타이틀">
		<br>
		내용
		<br>
		<textarea rows="3" cols="20" name="content" placeholder="내용"></textarea>
		<br>
		작성자
		<br>
		<input type="text" name="writer" placeholder="작성자">
		<br>
		<button>등록</button>
	</form>
</body>
</html>