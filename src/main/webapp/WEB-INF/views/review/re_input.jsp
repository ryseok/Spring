<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 Person</title>
</head>
<%--re_input--%>
<body>
	<h1>사람정보</h1>
	<hr>
	<form action="re_result" method="post">
	<%--VO 전달 시 name="" 꼭 작성!!!--%>
	<input type="text" placeholder="이름" name="name">
	<br>
	<input type="text" placeholder="나이" name="age">
	<br>
	<input type="text" placeholder="직업" name="job">
	<br>
	<button>전송</button>
	</form>
</body>
</html>