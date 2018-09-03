<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예외처리</title>
</head>
<body>
	<h2>${exception.getMessage() }</h2>
	<ul>
		<core:forEach items="${exception.getStackTrace() }" var="stack">
		<li>${stack.toString() }</li>
		</core:forEach>		
	</ul>
</body>
</html>