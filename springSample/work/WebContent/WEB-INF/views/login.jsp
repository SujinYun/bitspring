<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form id="frm" action="">

<div style="padding: 200px 0px 0 400px;">
<div id="login-box">

<h2>Login Page</h2>
test 홈페이지에 오신 것을 환영합니다 
<br>
<br>

<div id="login-box-name" style="margin-top:20px;">User Id:</div>
<div id="login-box-field" style="margin-top:20px;">
	<input type="text" class="form-login" name="id" id="id" placeholder="id를 입력하세요" size="10" maxlength="50">
</div>
<div id="login-box-name">Password:</div>
<div id="login-box-field">
	<input type="password" class="form-login" name="pw" id="pwd" size="10" placeholder="password를 입력하세요" maxlength="48">
	<input type="checkbox" id="chk_save_id">Save id 
</div>
<br>
<input type="button" name="loginBtn" value="LOGIN" id="loginbtn">

<span class="login-box-options">
New User?  <a href="account.do" style="margin-left:30px;">Register Here</a>
</span>
</div>
</div>

</form>

<p id="test"></p>
<script type="text/javascript">
$(function () {
	
	$("#joinbtn").on("click", function () {
		$("#frm").attr("action", "account.jsp").submit();
	});

});

</script>


<script type="text/javascript">
/* 
$(function () {
	$("#loginbtn").on("click", function () {
		$.ajax({
			url:"loginAf.jsp",
			type:"post",
			data:"id="+$("#id").val()+"&pw="+$("#pw").val(),
		//	data:{"id":$("#id").val(), "pw":$("#pw").val()}
			success:function(data){
				$("#test").text(data.trim());
			//	$location.attr("")
			},
			error:function(){
				alert("error");
			}
		});
	});
});
 */
//null값 로그인 시
 $("#loginbtn").click(function() {
	
	if($("#id").val().trim() == "" ){
		alert("id를 입력해주십시오.");
		$("#id").focus();
		// 커서가 id칸에 맞춰짐
	}
	else if($("#pwd").val().trim() == ""){
		alert("password를 입력해주십시오.");
		$("#pwd").focus();
	}
	else{
		$("#frm").attr({"action":"loginAf.jsp", "target":"_blank"}).submit();		
	}
	
	
/* 	else $.ajax({
			url:"loginAf.jsp",
			type:"post",
			data:"id="+$("#id").val()+"&pw="+$("#pw").val(),
		//	data:{"id":$("#id").val(), "pw":$("#pw").val()}
			success:function(data){
				$("#test").text(data.trim());
				location.href = "bbslist.jsp";
				//location.href = "finish.jsp";
			},
			error:function(){
				alert("error");
			}
		}); */
	
});	

/* 	else{
		$("#frm").attr("action", "accountAf.jsp").submit();
	} */

 
/*  $("#_btnLogin").click(function() {	
		if( $("#id").val().trim() == "" ){
			alert("id를 입력해 주십시오");
			$("#id").focus();
		}
		else if( $("#pwd").val().trim() == "" ){
			alert("password를 입력해 주십시오");
			$("#pwd").focus();
		}
		else{
			$("#frm").attr({"action":"loginAf.jsp", "target":"_blank"}).submit();		
		}	
	}); */

var user_id = $.cookie("user_id");
if(user_id != null){	// 지정한 쿠키가 있을 때
	// alert("쿠키 있음");
	$("#id").val( user_id );
	$("#chk_save_id").attr("checked", "checked");
}

$("#chk_save_id").click(function() {
	
	if( $("#chk_save_id").is(":checked") ){	// 체크 되었을 때
		alert("체크 됨");
		if( $("#id").val().trim() == "" ){
			alert("id를 입력해 주십시오");
			$("#chk_save_id").prop("checked", false);			
		}else{	// 정상 기입한 경우
			// 쿠키 저장
			$.cookie("user_id", $("#id").val().trim(), {expires:7, path:'/'});
		}
	}
	else{
	//	alert("체크 없어짐");
		$.removeCookie("user_id", {path:'/'});
	}
	
});

</script>


</body>
</html>