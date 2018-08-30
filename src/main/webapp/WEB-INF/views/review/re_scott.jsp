<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보 복습</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			$.ajax({
				url			: "/Spring/reSearch",
				type 		: "POST",
				data			: {ename : $("input[name=search]").val()},
				success 	: function(result) {
					var htmlTxt = "";
					if(typeof(result)=="string" && result.length==0){
						htmlTxt = "사원정보가 없습니다.";
					}else{
						htmlTxt =	"	<fieldset><legend>주) ys 사원정보</legend>" + 
											"사원정보			: " + result.empno+
										  	"<br>사원명	: " + result.ename+
										  	"<br>급여		: " + result.sal+
										  	"<br>부서번호	: " + result.deptno+
										  	"</fieldset>";
					}
					$("div").html(htmlTxt);
				}
			});
		});
	});
</script>
</head>
<%--re_scott.jsp--%>
<body>
	<h1>사원정보 조회하기</h1>
	<hr>
	<input type="text" name="search" placeholder="사원이름을 검색하시오.">
	<button type="button">사원정보 검색</button>
	<hr>
	<div></div>
</body>
</html>