<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>follow Test</title>
<!--구글 제이쿼리-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	var count = 0; 					//follow 카운터
	var doubleCheck = true;	//버튼 한번 클릭
	
	$(function() { 		
		//팔로우 하기
		$("#plus").click(function() { 
			count++; //팔로우 하기 버튼 클릭시 증가
			if(count >= 0){
			$("#followers").val("팔로워 "+count+"명"); //input 태그에 팔로우 수 보여 주는곳
			//$('#plus').attr("disabled", doubleCheck);  //팔로우 하기 버튼 한번만 클릭 할 수 있음
			$('#plus').hide();  //팔로우 하기 버튼 한번만 클릭 할 수 있음
			$('#subtraction').show(); //팔로우 취소 버튼 한번만 클릭 할 수 있음
			}
// 			if(doubleCheck){ //팔로우 하기 버튼 클릭 되었으면 팔로우 취소 할 수 있음
// 				$('#subtraction').attr("disabled", false); 
// 			}
		});
		
		//팔로우 취소
		$("#subtraction").click(function() {
			count--; //팔로우 취소 버튼 클릭시 감소
			if(count >= 0){
				$("#followers").val("팔로워 "+count+"명"); //input 태그에 팔로우 수 보여 주는곳		
				//$('#subtraction').attr("disabled", doubleCheck); //팔로우 취소 버튼 한번만 클릭 할 수 있음
				$('#subtraction').hide(); //팔로우 취소 버튼 한번만 클릭 할 수 있음
				$('#plus').show();  //팔로우 하기 버튼 한번만 클릭 할 수 있음
			}
// 			if(doubleCheck){ //팔로우 취소 버튼 클릭 되었으면 팔로우 하기 할 수 있음
// 				$('#plus').attr("disabled", false); 
// 			}
		});
	});
</script>
</head>
<body>
<h1>follow 증가 또는 감소 TEST</h1>
<hr>
<!--가이드가 좋으면 팔로우-->
<button type="button" id="plus">팔로우 하기</button>

<!--가이드 팔로우중 별로라면 팔로우 취소-->
<button type="button" id="subtraction" style="display: none;">팔로우 취소</button>
<br><br>
<!--현재 가이드 팔로워 수-->
<input type="text"  id="followers" readonly="readonly" value="팔로워 0명">
</body>
</html>