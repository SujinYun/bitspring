<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
button{
	background-color: white;
}
a{
	text-decoration: none; color: blue;
}
</style>
</head>
<body>

<h1>답글쓰기</h1>

<form id="frm">

<table border="1" class="type01">
<tr>
	<td align="center">id</td>
	<td style="padding-left: 10px">
	${login.id }
 		<input type="hidden" name="id" value="${login.id }">
 		<input type="hidden" name="seq" value="${seq }">
	</td>
</tr>
<tr>
	<td align="center">title</td>
	<td style="padding-left: 10px">
		<input type="text" name="title" value="" id="title">
	</td>
</tr>
<tr>
	<td align="center">content</td>
	<td style="padding-left: 10px; padding-right: 10px">
		<textarea rows="10px" cols="50" name="content" id="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2" align="right">
	<input type="button" name="Addanswer" value="등록" id="Addanswer">
	</td>
</tr>
</table>

</form>

</body>

<script type="text/javascript">
 $("#Addanswer").click(function() {
	
	if($("#title").val().trim() == "" ){
		alert("제목을 입력해주십시오.");
		$("#title").focus();
		// 커서가 id칸에 맞춰짐
	}
	else if($("#content").val().trim() == ""){
		alert("내용을 입력해주십시오.");
		$("#content").focus();
	}
	else{
		$("#frm").attr("action","bbsanswerAf.do").submit();		
	}

 });
</script>
</html>