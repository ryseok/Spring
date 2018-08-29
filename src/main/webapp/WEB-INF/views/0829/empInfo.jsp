<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	.align-center { text-align: center; }
</style>
<title>사원정보</title>
</head>
<body class="align-center">
	<h1>사원정보 검색</h1>
	<hr>
	<form method="post">
		<input type="text" name="ename" placeholder="사원명">
		<!-- <button>사원정보 조회</button>	 -->
	</form>
	<hr>
	<c:if test="${empVO != null }">
	<fieldset>
		<legend>사원정보</legend>
			<table border="1" cellpadding="5" style="margin-left: auto; margin-right: auto;">
				<thead>
					<tr>
						<th>사원번호</th>					
						<th>사원명</th>					
						<th>급여</th>					
						<th>부서번호</th>					
					</tr>
				</thead>
				<tbody align="center">
					<tr>
						<td>${empVO.empno}</td>
						<td>${empVO.ename}</td>
						<td>${empVO.sal}</td>
						<td>${empVO.deptno}</td>
					</tr>
				</tbody>
			</table>
	</fieldset>
	</c:if>
	<c:if test="${pageContext.request.method=='POST' && empVO == null }">
		<fieldset>
			<legend>사원정보</legend>
				<font color="red">존재 하지 않는 사원입니다.</font>
		</fieldset>
	</c:if>
</body>
</html>