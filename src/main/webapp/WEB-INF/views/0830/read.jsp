<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>읽기전용(미션)</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			var str = $(this).text();
			if(str == "수정"){
				location.href="modify?bno=${board.bno}";
			}else if(str == "삭제"){
				location.href="delete?bno=${board.bno}";
			}else if(str == "목록보기"){
				location.href='list';
			}
		});
	});
</script>
</head>
<%-- 제목 		: 게시판 만들기 미션 	--%>
<%-- 작성자 		: rys 			--%>
<%-- 날짜 		: 2018.08.30 	--%>
<%-- 파일명  		: read.jsp		--%>
<body>
	<h3>게시물보기</h3>
	<hr>
	제목
	<input type="text" name="title" disabled value="${board.title }">
	<br>
	내용
	<textarea rows="5" cols="25" name="content" disabled>${board.content }</textarea>
	<br>
	작성자
	<input type="text" name="writer" disabled value="${board.writer }">
	<br>
	<button>수정</button>
	<button>삭제</button>
	<button>목록보기</button>
</body>
</html>