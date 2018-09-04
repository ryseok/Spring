<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>특정한 값 읽기 전용</title>
<style type="text/css">
.btn {
  display: inline-block;
  padding: 6px 12px;
  margin-bottom: 0;
  font-size: 14px;
  font-weight: normal;
  line-height: 1.42857143;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
      touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
          user-select: none;
  background-image: none;
  border: 1px solid transparent;
  border-radius: 4px;
}

.btn-primary {
  color: #fff;
  background-color: #337ab7;
  border-color: #2e6da4;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".update").click(function() {
			//self.location="/mboard/modify?bno=${board.bno}";//수정폼으로 이동
			
			//교재 따라하기
			$("[name=frm]").attr("action","/mboard/modify");
			$("[name=frm]").attr("method","get");
			$("[name=frm]").submit();
		});
		
		$(".delete").click(function() {
			self.location="/mboard/remove?bno=${board.bno}";
		});
		
		$(".list").click(function() {
			self.location="/mboard/list";//목록이동
		});
	});
</script>
</head>
<!--작성일 	: 180904-->
<!--수업내용 	: 페이징처리 복습-->
<!--작성자 	: rys-->
<!--파일명 	: read.jsp(입력폼)-->
<body>
	<!--교재에서 한짓-->
	<form name="frm" action="/mboard/modify">
		<input type="hidden" name="bno" value="${board.bno }">
	</form>
	<h1>읽기전용</h1>
	<hr>
		타이틀
		<br>
		<input type="text" name="title" placeholder="타이틀" disabled="disabled" value="${board.title }">
		<br>
		내용
		<br>
		<textarea rows="3" cols="20" name="content" placeholder="내용" disabled="disabled">${board.content }</textarea>
		<br>
		작성자
		<br>
		<input type="text" name="writer" placeholder="작성자" disabled="disabled" value="${board.writer }">
		<br><br>
		<button type="button" class="btn btn-primary update">수정</button>
		<button type="button" class="btn btn-primary delete">삭제</button>
		<button type="button" class="btn btn-primary list">Go 목록</button>
</body>
</html>