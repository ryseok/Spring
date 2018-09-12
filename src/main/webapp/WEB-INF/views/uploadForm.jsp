<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<!--enctype="multipart/form-data"는  multipart 방식으로 데이터가 전달된다는 것을 의미-->
	<form action="" id="from1" method="post" enctype="multipart/form-data">
		<input type="file" name="file"> <br>
		<button>업로드</button>
	</form>
</body>
</html>