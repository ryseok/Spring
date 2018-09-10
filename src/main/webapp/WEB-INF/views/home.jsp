<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp" %>
<script>
 $(function(){
   $('#listBtn').click(function(){
	  self.location='/sboard/list';
    });
 });
</script>
<%-- home.jsp --%>
 <section class="content">
   <div class="row">
     <div class="col-md-12">
       <div class="box">
         <div class="box-header with-border">
           <h3 class="box-title">홈페이지</h3>
           <hr>
           <font color="blue">로그인성공</font><br>
           <button id="listBtn">목록보기</button>
         </div>
       </div>
     </div>
   </div>
 </section>
<%@include file="include/footer.jsp" %>