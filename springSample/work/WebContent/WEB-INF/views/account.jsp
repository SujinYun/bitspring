<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

</head>
<body>

<div class="container">

<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">회원가입</h4>

<form action="" id="frm" method="post">

<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
		<input type="text" id="id" name="id" class="form-control" placeholder="id" onblur="trimplz()">
 </div> <!-- form-group// -->
 <div class="form-idcheck">
		<button type="button" id="Aoverlapping" class="btn-idchec">id check</button>

		<p id="idcheck" style="margin-left:10px; padding-top: 10px;">id 확인</p>
 </div>
<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
		<input type="text" class="form-control" id="pwd" name="pwd" placeholder="password">
</div> <!-- form-group// --> 
 <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" name="pwd" placeholder="Repeat password" type="password">
    </div> <!-- form-group// --> 

<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
		<input type="text" class="form-control" id="name" name="name" placeholder="name">
</div> <!-- form-group// -->
<div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
		<input type="text" class="form-control" id="email" name="email" placeholder="email">
 </div> <!-- form-group// -->
 <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="selected">+02</option>
		    <option value="1">+032</option>
		    <option value="2">+041</option>
		    <option value="3">+053</option>
		</select>
    	<input name="" class="form-control" placeholder="Phone number" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control">
			<option selected="selected">직업</option>
			<option>디자이너</option>
			<option>프로그래머</option>
			<option>자영업</option>
		</select>
	</div> <!-- form-group end.// -->
 
<div class="form-group">
		<button type="button" id="accBtn" class="btn btn-primary btn-block">Create Account</button>
</div> <!-- form-group// -->
<p class="text-center">Have an account? <a href="login.jsp">Log In</a> </p>

</form>
</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->




<script type="text/javascript">
// 중복확인 버튼을 누르면
$(function () {
	$("#Aoverlapping").on("click", function() {
		if($("#id").val().trim() == ""){
			alert("id를 입력해주십시오.");
			$("#id").focus();
			// 커서가 id칸에 맞춰짐
		}else{
		$.ajax({
			url:"overlapping.jsp",
			type:"get",
			data:"id="+$("#id").val(),
			success:function(data){
				$("#idcheck").text(data.trim());
			},
			error:function(){
				alert("error");
			}
		});
		}
	});
});

// null값 회원가입 시
$("#accBtn").click(function() {
	
	if($("#id").val().trim() == "" ){
		alert("id를 입력해주십시오.");
		$("#id").focus();
		// 커서가 id칸에 맞춰짐
	}
	else if($("#pwd").val().trim() == ""){
		alert("password를 입력해주십시오.");
		$("#pwd").focus();
	}
	else if($("#name").val().trim() == ""){
		alert("이름을 입력해주십시오.");
		$("#name").focus();
	}
	
	else{
		$("#frm").attr("action", "accountAf.do").submit();
	}
});

/* 
$("#Aoverlapping").click(function() {
	if($("#Aid").val().trim() == ""){
		alert("id를 입력해주십시오.");
		$("#Aid").focus();
		// 커서가 id칸에 맞춰짐
	}
});
 */
// 못함
/* 
$(document).ready(function() {
	
	$(function trimplz() {
		alert("test");
		$("#Aid").text() = $("#Aid").text().trim();
	});
	
});
 */


</script>




</body>
</html>