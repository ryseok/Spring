<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <style type="text/css">
     #modDiv{
       background-color: orange;
       width: 300px;
       height: 100px;
       padding: 30px;
       position:absolute;
       top:50%;
       left: 50%;
       margin-top: -50px;
       margin-left: -150px;
       z-index: 1000;
     }
     
  .pagination {
	  display: inline-block;
	  padding-left: 0;
	  margin: 20px 0;
	  border-radius: 4px;
  }
  .pagination > li {
  display: inline;
   }
   .pagination > li > a {
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
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript">
    var bno=136;
    
    function replylist(){//전체 댓글
	  $.ajax({
	  	  url:'/replies/all/'+bno,
	  	  success:function(result){//result ---> List데이터
	  		 console.log(result.length);
	  		 console.log(result);
	  		 var str='';
	  		 $(result).each(function(){
	  			 str+='<li data-rno="'+this.rno+'" data-rtext="'+this.replytext+'"  class="replyLi">'+this.rno 
	  			 +":"+this.replytext+'<button>수정</button></li>';
	  		 });
	  		 $('#replies').html(str);
	  	  }
	  });
    }//replylist
    
    // replies/120/2    ===> 120:글번호, 2:2페이지
    function replylistPage(page){//특정 페이지의 댓글(예:1페이지의 댓글 10개)
	  $.ajax({
	  	  url:'/replies/'+bno+'/'+page,
	  	  success:function(result){//result ---->Map { List("list"), PageMaker("pageMaker")}
	  		 var str='';
	  		 $(result.list).each(function(){
	  			 str+='<li data-rno="'+this.rno+'" data-rtext="'+this.replytext+'"  class="replyLi">'+this.rno 
	  			 +":"+this.replytext+'<button>수정</button></li>';
	  		 });
	  		 $('#replies').html(str);
	  		 printPaging(result.pageMaker);
	  	  }
	  });
    }//replylistPage
    
    function printPaging(pageMaker){//하단 번호출력
  	  
  	  var str='';
  	  for(var i=pageMaker.startPage; i<=pageMaker.endPage; i++){
  		  str+= "<li><a>"+i+"</a></li>";
  	  }
  	  $('.pagination').html(str);
    }//printPaging
    
    
    $(function(){  //window ready    	
      //replylist();
      replylistPage(1);
    
      $('#btn_create').click(function(){//입력요청
    	  var replyer = $('input[name=replyer]').val();
    	  var replytext = $('input[name=replytext]').val();
    	  
    	  $.ajax({
    		    url:'/replies',
    		    type:'post',
    		    data: JSON.stringify({//파라미터 데이터 ----> JSON으로 변환
    		    	   //컨트롤러의 메소드 파라미터에 @RequestBody가 정의되어있을때 사용
    		    	   bno:bno,
    		    	   replyer:replyer,
    		    	   replytext:replytext
    		    }),
    		    headers:{  
    		    	  //JSON데이터를 서버(컨트롤러)에 보냄!!
    		    	'Content-Type':'application/json'
    		    },
    		    //dataType:'json'//from 서버
    		    success:function(result){
    		    	alert(result);
    		    	$('input[name=replyer]').val('');
    		    	$('input[name=replytext]').val('');
    		    	replylist();
    		    }
    	  });    	  
      });//댓글 입력
      
      
      //<ul><li data-rno=15 data-rtext='안녕댓글'>안녕댓글<button>수정</button></li></ul>
      //댓글 수정폼 요청
      $('#replies').on('click','.replyLi button',function(){//('click','li button',function(){
    	  //alert('버튼클릭!!')
    	  //수정버튼 좌측에 있는 댓글번호,댓글내용 얻기
    	  var reply = $(this).parent();//---> <li>엘리먼트
    	  //var text = $(this).prev();
    	  //alert($(this).prev().text);
    	  
    	  var rno = reply.attr('data-rno');
    	  var replytext = reply.attr('data-rtext');//reply.text();
    	  //alert(rno+">>"+replytext);
    	  $('.modal-title').html(rno);
    	  $('#replytext').val(replytext);
    	  
    	  $('#modDiv').show(1500);
      });
      
      //댓글 삭제요청
      $('#replyDelBtn').click(function(){
    	  var rno = $(".modal-title").html();    	  
      
    	  $.ajax({
    		  url:'/replies/'+ rno,//--->/replies/4
    		  type:'delete',
    		  success:function(result){
    			  if(result==='SUCCESS'){
    				  alert('삭제되었습니다!!');
    				  $('#modDiv').hide(1500);//모달창 닫기
    				  replylist();//갱신내용 반영
    			  }
    		  }
    	  });  
    	  
      });
      
      //모달창 닫기
      $('#closeBtn').click(function(){
    	  $('#modDiv').hide(1500);//모달창 닫기
      });
      
      //댓글수정
      $('#replyModBtn').click(function(){
    	  var rno = $(".modal-title").html();    	  
      
    	  $.ajax({
    		  url:'/replies/'+ rno,//--->/replies/5
    		  type:'put',
    		  data:JSON.stringify({
    			replytext:$('#replytext').val()  
    		  }),
    		  headers:{
    			'Content-Type':'application/json'  
    		  }
    		  ,
    		  success:function(result){
    			  if(result==='SUCCESS'){
    				  alert('수정되었습니다!!');
    				  $('#modDiv').hide(1500);//모달창 닫기
    				  replylist();//갱신내용 반영
    			  }
    		  }
    	  });  
    	  
      });//댓글 수정
      
     
      
    });//window ready
  </script>
  
</head>
<%--ajax_test.jsp(ajax요청 테스트) --%>
<body>
  <h3>Ajax요청 테스트</h3>
  <div>
    <div>작성자: <input type="text" name="replyer"></div>
    <div>댓글내용: <input type="text" name="replytext"></div>
    <button id="btn_create">댓글추가</button>
  </div>
  <hr>
  
  <!-- 댓글list출력 -->
  <ul id="replies"></ul>
  
  <!-- 페이지 번호출력 -->
  <ul class="pagination"></ul> 
  
  <!-- 수정과 삭제를 위한DIV 모달창-->
  <div id="modDiv" style="display: none;">
    <div class="modal-title"></div>
    <div>
      <input type="text" id="replytext">
    </div>
    <div>
      <button id="replyModBtn">수정</button>
      <button id="replyDelBtn">삭제</button>
      <button id="closeBtn">닫기</button>
    </div>
  </div>
</body>
</html>



