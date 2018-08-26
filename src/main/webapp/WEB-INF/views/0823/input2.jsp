<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%--input2.jsp--%>
<body>
	<h1>입력폼</h1>
	<hr>
	<form action="result2" method="post">
		<input type="text" name="name" placeholder="이름">
		<br>
		<input type="text" name="age" placeholder="나이">
		<br>
		<input type="text" name="job" placeholder="직업">
		<br>
		<button>전송</button>
	</form>
</body>
</html>