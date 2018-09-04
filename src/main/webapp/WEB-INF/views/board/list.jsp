<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>조회 폼</title>
<style type="text/css">
.pagination {
  display: inline-block;
  padding-left: 0;
  margin: 20px 0;
  border-radius: 4px;
}
.pagination > li {
  display: inline;
}
.pagination > li > a,
.pagination > li > span {
  position: relative;
  float: left;
  padding: 6px 12px;
  margin-left: -1px;
  line-height: 1.42857143;
  color: #337ab7;
  text-decoration: none;
  background-color: #fff;
  border: 1px solid #ddd;
}
.pagination > .active > a{
  z-index: 2;
  color: #fff;
  cursor: default;
  background-color: #337ab7;
  border-color: #337ab7;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var msg = "${msg}";
		if (msg == "success") {
			alert("등록완료 ;)");
		}else if(msg == "upfail"){
			alert("등록 실패 :(");
		}
	});
</script>
</head>
<!--작성일 	: 180904-->
<!--수업내용 	: 페이징처리 복습-->
<!--작성자 	: rys-->
<!--파일명	: list.jsp-->
<body>
	<h1>목록보기</h1>
	<hr>
	<table border="1" cellpadding="5" cellspacing="0">
		<thead>
		<tr bgcolor="skyblue">
			<th>글번호</th>
			<th>타이틀</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody>
		<!--var속성은 list.get(index)-->
		<c:forEach items="${list }" var = "board">
			<tr>
				<td>${board.bno}</td>
				<td><a href="/mboard/read?bno=${board.bno}">${board.title}</a> </td>
				<td>${board.writer}</td>
				<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd hh:mm"/></td>
				<td>${board.viewcnt}</td>			
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br><br>
	<!--현재 페이지 따라서 표시 해줌-->
	<c:if test="${maker.prev}"><a href="/mboard/list?page=${maker.startPage-1 }">◁◁</a></c:if>
	<ul class="pagination">
	<c:forEach begin="${maker.startPage }" end="${maker.endPage }" var="i">
		 <li 
        <c:out value="${(i==maker.cri.page)?'class=active':''}"/>
        >
			<a href="/mboard/list?page=${i}$perPageNum=${maker.cri.perPageNum } ">${i }</a>
		</li>
	</c:forEach>
	</ul>
	<c:if test="${maker.next}"><a href="/mboard/list?page=${maker.endPage+1 }">▷▷</a></c:if>
</body>
</html>