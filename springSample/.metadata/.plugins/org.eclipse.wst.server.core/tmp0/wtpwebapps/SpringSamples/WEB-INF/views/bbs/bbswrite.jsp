<%@page import="bit.com.a.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
table.type01 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    margin : 20px 10px;
}
table.type01 th {
    /* width: 150px; */
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border: 1px solid #ccc;
    text-align: center;
}
table.type01 td {
    /* width: 350px; */
    padding: 10px;
    vertical-align: top;
    border: 1px solid #ccc;
}
.Btncss{
	background: white;
}
</style>
</head>
<body>

<form action="bbswriteAf.do" method="get">

<table border="1" class="type01">
<tr>
	<td align="center">id</td>
	<td>
		<input type="text" name="id" value="${login.id }">
	</td>
</tr>
<tr>
	<td align="center">title</td>
	<td>
		<input type="text" name="title" value="">
	</td>
</tr>
<tr>
	<td>content</td>
	<td>
		<textarea rows="10px" cols="50" name="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2" align="right">
	<input type="submit" name="addwrite" value="글추가" class="Btncss">
	</td>
</tr>

</table>

</form>

</body>




</html>