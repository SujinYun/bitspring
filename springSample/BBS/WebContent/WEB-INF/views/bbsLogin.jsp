<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<form id="frm" action="" method="post">
id:<input type="text" placeholder="id입력" id="_id" name="id"><br>
pwd:<input type="password" placeholder="password입력" id="_pwd" name="pwd"><br>
save id<input type="checkbox" id="_SaveId"><br>
<button type="button" id="_acc">account</button>
<input type="button" value="login" id="_login">

</form>

</body>

<script type="text/javascript">
$(function () {
	$("#_acc").on("click", function () {
		$("#frm").attr("action", "account.do").submit();
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
 $("#_login").click(function() {
	
	if($("#_id").val().trim() == "" ){
		alert("id를 입력해주십시오.");
		$("#_id").focus();
		// 커서가 id칸에 맞춰짐
	}
	else if($("#_pwd").val().trim() == ""){
		alert("password를 입력해주십시오.");
		$("#_pwd").focus();
	}
	else{
		$("#frm").attr({"action":"loginAf.do", "target":"_blank"}).submit();		
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
</html>