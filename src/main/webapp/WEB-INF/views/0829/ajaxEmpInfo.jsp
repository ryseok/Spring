<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원정보(Ajax)</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			$.ajax({
				url : "/Spring/empInfo2",
				type : "POST",
				data : {ename : $("input[name=ename]").val()},
				success : function (result) {
					//alert(result); //Test
					var htmlTxt = "";
					if(typeof(result)=="string" && result.length==0){
						htmlTxt="<font color='red'>사원정보가 없습니다.</font>";
					}else{
					htmlTxt="사원번호 : " 		+ result.empno+
								"<br>사원명 : "   + result.ename+
								"<br>급여 : "		+ result.sal+
								"<br>부서번호 : "	+ result.deptno;			
					}
					$("div").html(htmlTxt);
				}
			});
		});
	});
</script>
</head>
<body class="align-center">
	<h1>사원정보 보내기</h1>
	<hr>
	<form method="post">
		<input type="text" name="ename" placeholder="사원명">
		<button type="button">사원정보 조회</button>
	</form>
	<hr>
	<div></div>
</body>
</html>