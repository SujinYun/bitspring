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
.Btncss{
	background: white;
}
table{
	border: groove;
	border-collapse: collapse;
}
</style>
</head>
<body>

<form action="bbswriteAf.do" method="get">

<table border="1">
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