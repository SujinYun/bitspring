<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>caldetail.jsp</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
table{
	border: groove;
	border-collapse: collapse;
}
table.type01{
    border-spacing: 0;
    text-align: left;
    line-height: 1.0;
    border-top: 1px solid #ccc;
    border-left: 1px solid #ccc;
  	margin : 20px 10px;
}
table.type01 th{
	    /* width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #fff;
    border-left: 1px solid #fff;
    background: #eee;
    text-align: center;
}
table.type01 td{
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
body{
	font-family: Times New Roman;
}
.addBtn{
	padding: 10px
}
</style>

</head>
<body>


<form action="calupdate.do">

<table border="1" class="type01">
<col width="50">
<tr>
	<th align="center">ID</th>
	<td style="padding-left: 10px">
		${cal.id }
		<input type="hidden" name="seq" value="${cal.seq }" id="_seq">
	</td>	
</tr>
<tr>
	<th align="center">Title</th>
	<td style="padding-left: 10px">
		${cal.title }
		<input type="hidden" name="title" value="${cal.title }">
	</td>	
</tr>
<tr>
	<th align="center">Date</th>
	<td style="padding-left: 10px">
		${cal.wdate }
		<input type="hidden" name="date" value="${cal.wdate }">
	</td>	
</tr>
<tr>
	<th>content</th>
	<td style="padding-left: 10px; padding-right: 10px">
		${cal.content }
		<input type="hidden" name="content" value="${cal.content }">
	</td>	
</tr>

</table>

<input type="button" value="돌아가기" id="cancel" style="background-color: #F6F6F6;">
<input type="submit" value="수정" id="update" style="background-color: #F6F6F6;">
<input type="button" value="삭제" id="del" style="background-color: #F6F6F6;">

</form>

</body>

<script type="text/javascript">
$(document).ready(function() {
	$("#cancel").click(function() {
		location.href="calendar.do";
	});
/* 	$("#update").click(function() {
		location.href="calupdate.jsp";
	}); */
	$("#del").click(function() {
		location.href="caldelete.do?seq=" + $("#_seq").val();
		
	});
});

</script>





</html>