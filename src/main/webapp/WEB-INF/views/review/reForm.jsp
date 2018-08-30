<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력폼</title>
</head>
<!--reForm.jsp-->
<body>
	<h1>게시물 작성</h1>
	<hr>
	<form method="post">
		<input type="text" name="title" placeholder="제목">
		<br><br>
		<textarea rows="10" cols="22" name="content" placeholder="내용"></textarea>
		<br><br>
		<input type="text" name="writer" placeholder="작성자">
		<br>
		<button>등록</button>
	</form>
</body>
</html>