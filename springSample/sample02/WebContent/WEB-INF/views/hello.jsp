<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>

<%
// scriptlet으로 하는 방법
String name1 = (String)request.getAttribute("name");
out.println("name=" + name1);

%>

<br>
<!-- el태그로 하는 방법 -->
<h3>${name }</h3>
<!-- el태그는 key값을 바로 입력하면 value값이 출력된다. -->

</body>
</html>