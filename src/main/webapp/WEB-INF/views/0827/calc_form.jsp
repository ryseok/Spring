<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<title>Spring 계산기</title>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
//			$.ajax({
// 					url:"/Spring/you/calc",
// 					data:{
// 					num1 : $("[name=num1]").val(),
// 					num2 : $("[name=num2]").val(),						
// 					oper : $("[name=oper]").val()						
// 					},
					success:function(){
						$("div").html();	
					}
//			});
		});
	});
</script>
</head>
<body>
	<h1>계산기</h1>
	<hr>
 	<form action="" method="post">
		<input type="text" name="num1">
		<select name="oper">
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
		<input type="text" name="num2">
		<button>계산</button>
 	</form>
	<hr>
	<div></div>
</body>
</html>