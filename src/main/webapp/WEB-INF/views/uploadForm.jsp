<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드</title>
<style type="text/css">
	ifame{
		width : 0px;
		height : 0px;
		border : 0px;
	}
</style>
<script type="text/javascript">
	function addFilePath(msg) {
		alert(msg);
		document.getElementById("form1").reset();
	}
</script>
</head>
<body>
	<!--enctype="multipart/form-data"는  multipart 방식으로 데이터가 전달된다는 것을 의미-->
	<form action="uploadForm" id="from1" method="post" enctype="multipart/form-data" target="zeroFrame">
		<input type="file" name="file"> <br>
		<button>업로드</button>
	</form>
	<iframe name="zeroFrame"></iframe>
</body>
</html>