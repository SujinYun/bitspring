<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsAccount.jsp</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<form action="accountAf.do" method="post">

id:<input type="text" placeholder="id를 입력하세요" id="id" name="id">
<button type="button" id="_idcheck">중복확인</button>
<p id="_resultMsg"></p>

pwd:<input type="password" placeholder="password를 입력하세요" id="pwd" name="pwd"><br><br>
name:<input type="text" id="name" name="name"><br><br>
email:<input type="text" id="email" name="email"><br><br>

<input type="submit" value="회원가입">

</form>

</body>


<script type="text/javascript">


$(function () {
	$("#_idcheck").on("click", function() {
		var id = $("#id").val().trim();
	//	alert(id);
		
		if($("#id").val().trim() == ""){
			alert("id를 입력해주십시오.");
			$("#id").focus();
			// 커서가 id칸에 맞춰짐
		}else{
		$.ajax({
			url:"idcheck.do",
			type:"get",
			data: "id=" + $("#id").val().trim(),
			success:function(data){
				if(data == "불가"){			
					$("#_resultMsg").text("사용 불가능한 아이디 입니다.");
					$("#_resultMsg").attr("style", "color:#f00")
					
				}else{		
					$("#_id").text(data.trim());
					$("#_resultMsg").text("사용 가능한 아이디 입니다.");
					$("#_resultMsg").attr("style", "color:#00f")
					
				}
			},
			error:function(r, s, err){
				alert("error");
			}
		});
		}
	});
});

</script>

</html>