<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style type="text/css">
table.type02 {
    border-collapse: separate;
    border-spacing: 0;
    text-align: left;
    line-height: 1.0;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
  	margin : 20px 10px;
}
table.type02 th {
    /* width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #fff;
    border-left: 1px solid #fff;
    background: #ddd;
    text-align: center;
}
table.type02 td {
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>
<link type="text/css" rel="stylesheet" href="./css/ui.css">
</head>
<body>

<h4 align="right" style="background-color: #f0f0f0">환영합니다 ${login.id }님 환영합니다</h4>

<h1>게시판</h1>

<hr>

<div align="center">

<!-- arrow생성 -->
<jsp:useBean id="ubbs" class="bit.com.a.util.BbsArrow"/>

<table class="type02">
<col width="70"><col width="600"><col width="150"><col width="150">

<tr>
	<th>번호</th><th>제목</th><th>작성일</th><th>작성자</th>
</tr>

<c:if test="${empty bbslist }">
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
</c:if>	

<c:forEach items="${bbslist }" var="bbs" varStatus="vs">

	<!-- depth를 변수에 할당 -->
	<jsp:setProperty property="depth" name="ubbs" value="${bbs.depth }"/>	<!-- setDepth 호출 -->

	<tr>
		<td align="center">${vs.count }</td>
				
		<c:if test="${bbs.del eq 0 }">
			<td class="seqclick" style="text-align: left;" seq=${bbs.seq }>	
				
				<!-- arrow 이미지를 추가 -->
				<jsp:getProperty property="arrow" name="ubbs"/>	<!-- getArrow 호출 -->
								
				${bbs.title }					
			</td>
		</c:if>
		
		<c:if test="${bbs.del eq 1 }">
			<td class="">
				<font color="#ff0000"><b>이 글은 게시자에 의해서 삭제 되었습니다</b></font> 	
			</td>
		</c:if>
			
		<td align="center">${bbs.wdate }</td>
		 		 
		<td align="center">${bbs.id }</td>
	</tr>
</c:forEach>	
</table>

<br>
<a href="bbswrite.do">글쓰기</a>
</div>


<script type="text/javascript">

$(function () {
	
	$(".seqclick").mousedown(function() {	
		location.href = "bbsdetail.jsp?seq=" + $(this).attr("seq");
	});
	
	$(".seqclick").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".seqclick").mouseout(function() {
		$(this).css("background", "#ffffff");
	});
	
});

</script>

</body>
</html>