﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css"/>

<style type="text/css">
#login_wrap {
	margin:10px;
}
#login_wrap th {
	font-weight:bold;
}
#main_wrap { 
	width:800px; 
	margin-left:auto; 
	margin-right:auto; padding:0px; 
}			
#content_wrap { 
	width: 100%; 
	height: 500px; 
	background-image:url("image/kakaoimg.jpg"); 
	background-repeat:no-repeat; 
	background-position:top center;  
}
			
.login_title_warp {
	width:500px; 
	color:#FFFFFF; 
	text-align:center; 
	background-color:#3e5fba; 
	border:solid 1px #EFEFEF; 
	font-weight:bold; 
	height:60px;
}

/* table셋팅 */
.content_table { width:98%; border-bottom:1px solid #EFEFEF; border-right:1px solid #EFEFEF; border-collapse:collapse; margin-left:auto; margin-right:auto;  clear:both; }
.content_table td, .content_table th { text-align:center; border-top:1px solid #EFEFEF; border-left:1px solid #EFEFEF; padding:0.3em; }
.content_table th { background-color:#4D6BB3; color:#FFFFFF; line-height: 1.7em; font-weight:normal;}
.content_table td { padding-left:5px; text-align:left; line-height: 1.7em; }
.content_table td.contents { width:100%; height:400px; overflow:auto; }
.content_table th, .content_table td { vertical-align:middle; }

.content_table select { height:19px; border:#CCCCCC solid 1px; vertical-align:middle; line-height: 1.8em; padding-left:0px; }
.content_table select option { margin-right:10px; }

</style>

</head>
<body>

<div id="main_wrap">
	<div id="middle_wrap">
		<div id="content_wrap">
			
			<div style="width: 502px; height: 166px; margin-left: auto; margin-right: auto;
						position: relative; top: 100px;">
								
			<div class="login_title_warp">
				<div style="margin-top:12px">
					<h2>회원가입</h2>
				</div>
			</div>
			
			<div id="login_wrap">
				<form action="" method="post" id="_frmForm" name="frmForm">
				
				<table class="content_table" style="width: 75%">
				<colgroup>
					<col style="width:30%">
					<col style="width:70%">
				</colgroup>
				
				<tr>
					<th>아이디 체크</th>
					<td>
						<input type="text" name="sid" id="_id" size="30">
						<a href="#none" id="_btnGetId" title="id체크">
							<img alt="" src="image/idcheck.png">
						</a>
						<div id="_rgetid"></div>
					</td>
				</tr>
				
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" id="_userid" size="30" data-msg="아이디를" readonly>
					</td>
				</tr>
				
				<tr>
					<th>패스워드</th>
					<td>
						<input type="password" name="pwd" id="_pwd" size="30" data-msg="패스워드를">
					</td>
				</tr>
				
				<tr>
					<th>이름</th>
					<td>
						<input type="text" name="name" id=_name size="30" data-msg="이름을">
					</td>
				</tr>
				
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email" id=_email size="30" data-msg="이메일을">
					</td>
				</tr>
				
				<tr>
					<td colspan="2" style="height: 50px; text-align: center;">
					<a href="#none" id="_btnRegi" title="회원가입">
						<img alt="" src="image/regi.jpg">
					</a>
					
					<a href="#none" id="_btnLogin" title="로그인">
						<img alt="" src="image/login.jpg">
					</a>
					</td>
				</tr>
				
				
				
				</table>
				
				</form>
			</div>
				
				
				
				
			</div>		
		</div>	
	</div>
</div>

<script type="text/javascript">
$("#_btnGetId").click(function(){
//	alert("test");
	$.ajax({
		url:"getId.do",
		type:"post",
		data:{id:$("#_id").val()},
		success:function(msg){

// 			alert("suc");
			if(msg == 'YES'){
	 		//	alert("msg == YES");	// id있음	
	 		$("#_rgetid").html("사용할 수 없는 아이디입니다.");
	 		$("#_rgetid").css("color", "red");
	 		$("#_id").val("");
	 		$("#_userid").val("");
	 		$("#_id").focus();
	 		
			}else{
	 		//	alert("msg == NO");		// 없음
	 		$("#_rgetid").text("사용 가능한 아이디입니다.");
	 		$("#_rgetid").css("color", "blue");
	 		$("#_userid").val($("#_id").val());
	 		$("#_pwd").focus();
	 		
	 		
			}
		},
		error:function(){
			alert("err");
		}
	});
	

});


//회원가입 버튼을 눌렀을 때	
$("#_btnRegi").click(function(){
	
	// 빈 칸 체크
	if($("#_userid").val() == null || $("#_userid").val() == ""){
		alert("아이디를 입력하세요");
		$("#_id").focus();
	}
	else if($("#_pwd").val() == null || $("#_pwd").val() == ""){
		alert("패스워드를 입력하세요");
		$("#_pwd").focus();
	}
	else if($("#_name").val() == null || $("#_name").val() == ""){
		alert("이름을 입력하세요");
		$("#_name").focus();
	}
	else if($("#_email").val() == null || $("#_email").val() == ""){
		alert("이메일을 입력하세요");
		$("#_email").focus();
	}
	else{
		$("#_frmForm").attr("action", "regiAf.do").submit();
	}
	

});



</script>

</body>
</html>





