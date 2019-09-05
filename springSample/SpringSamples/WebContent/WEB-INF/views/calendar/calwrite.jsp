<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, 1);

int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int tday = cal.get(Calendar.DATE);
int thour = cal.get(Calendar.HOUR_OF_DAY);
int tmin = cal.get(Calendar.MINUTE);

String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
/*
// 연도
int year = cal.get(Calendar.YEAR);
System.out.println("year=" + year);

//월	
int month = cal.get(Calendar.MONTH);
System.out.println("month=" + month);
*/
//일
	// 마지막 날짜
int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
System.out.println("lastDay= " + lastDay);

// user id
/* MemberDto user = (MemberDto)session.getAttribute("login");
String id = user.getId();
 */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calwrite.jsp</title>
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
._addBtn{
	padding: 10px
}
</style>

</head>
<body>

<h1>일정추가</h1>

<form action="" id="frm">
<input type="hidden" name="id" value="${mem.id }">

<table border="1" class="type01">
<col width="50">
<tr>
	<th align="center">ID</th>
	<td style="padding-left: 10px">
		${mem.id }
	</td>	
</tr>
<tr>
	<th align="center">Title</th>
	<td style="padding-left: 10px">
		<input type="text" name="title" id="title">
	</td>	
</tr>
<tr>
	<th align="center">Date</th>
	<td style="padding-left: 10px">
		<select name="year">
			<%
			for(int i = tyear - 5;i < tyear + 6; i++){
				%>
				<option <%=year.equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>년
		
		<select name="month">
		<%
			for(int i = 1;i <= 12; i++){
				%>
				<option <%=month.equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>월
		
		<select name="day">
		<%
			for(int i = 1;i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
				%>
				<option <%=day.equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>일
		
		<select name="h">
		<%
			for(int i = 0;i < 24; i++){
				%>
				<option <%=(thour + "").equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>시
		
		<select name="m">
		<%
			for(int i = 0;i < 60; i++){
				%>
				<option <%=(tmin + "").equals(i+"")?"selected='selected'":"" %>
					value="<%=i %>"><%=i %></option>
					
				<%
			}
		%>		
		</select>분
	</td>	
</tr>
<tr>
	<th>content</th>
	<td style="padding-left: 10px; padding-right: 10px">
		<textarea rows="10" cols="50" name="content" id="content"></textarea>
	</td>	
</tr>

</table>

<input type="button" value="취소" id="cancel" style="background-color: #F6F6F6;">
<input type="button" value="일정추가" style="background-color: #F6F6F6;" id="_addbtn">

</form>

</body>

<script type="text/javascript">
$(document).ready(function() {
	$("#cancel").click(function() {
		location.href="calendar.do";
	});
	
	$("#_addbtn").click(function() {
		if($("#title").val().trim() == "" ){
			alert("제목을 입력해주세요.");
			$("#title").focus();
			// 커서가 id칸에 맞춰짐
		}
		else if($("#content").val().trim() == ""){
			alert("내용을 입력해주세요.");
			$("#content").focus();
		}
		else{
			$("#frm").attr("action", "calwriteAf.do").submit();		
		}
	});
	
});


$(document).ready(function() {
	// 날짜설정
//	setDay();
	
	// select가 바뀔때마다 setDay를 호출 (달마다 28,30,31일을 바꿔주기 위해)
	$("select[name='month']").change(setDay);
});
function setDay() {
	// 년도, 월을 통해서 마지막 날짜를 구한다.
	var year = $("select[name='year']").val() + "";
	var month = $("select[name='month']").val() + "";

	var lastday = (new Date(year, month, 0)).getDate();
	alert(lastday);
	
	/* 위 코드를 합친 것
	var lastday = (new Date($("select[name='year']").val() + "",
					$("select[name='month']").val() + "", 0)).getData();
	 */
	
	 // select에 날짜적용
	 var str = "";
	 for(i=1; i<=lastday; i++){
		 str += "<option value='" + i + "'>" + i + "</option>";
	 }
	 
	 $("select[name='day']").html(str);
	 
}



</script>





</html>