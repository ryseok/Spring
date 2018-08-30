<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 목록(미션)</title>
<script type="text/javascript">
	var result = ('${msg}');
	if(result === "입력 성공"){
		alert("처리완료");
	}
</script>
</head>
<%-- 제목 		: 게시판 만들기 미션 	--%>
<%-- 작성자 		: rys 			--%>
<%-- 날짜 		: 2018.08.30 	--%>
<%-- 파일명  		: list.jsp		--%>
<body>
	<h1>게시물 목록</h1>
	<hr>
	<table border="1" cellpadding="5">
		<thead>
			<tr bgcolor="skyblue">
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<core:forEach items="${list }" var = "board">
			<tr>
				<td>${board.bno }</td>
				<td><a href="read?bno=${board.bno }">${board.title }</a></td>
				<td>${board.writer }</td>
				<td>
					<fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd hh:mm:ss"/>
				</td>
			</tr>
			</core:forEach>
		</tbody>
	</table>
</body>
</html>