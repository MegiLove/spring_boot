<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#form,#input_code{
	visibility: hidden;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		let email = "";
		let code = "";
		let type = "email";
		$("#btnSend").click(function(){
			to = $("#to").val();
			let data = {to:to,type:type};
			$.ajax({
				url:"checkVerification",
				data:data,
				success:function(data){
					code = data;
					alert("인증코드를 전송하였습니다.");
					$("#input_code").css("visibility","visible");
				}
			})
		});
		
		$("#btnCheck").click(function(){
			let userCode = $("#userCode").val();
			if(code == userCode){
				alert("인증되었습니다.");
				$("#form").css("visibility","visible");
			}else{
				alert("인증에 실패하였습니다.");
				$("input_code").css("visibility","hidden");
			}
		});
		
		$(".type").click(function(){
			type =$(this).val();
			if(type == "email"){
				$("#title").html("이메일 입력 ");
			}else{
				$("#title").html("휴대폰 번호 입력 ");
			}
		});
		
	});
</script>
</head>
<body>
	<h2>회원가입</h2>
	인증방법 선택
	<input type="radio" value="phone" id="phone" name="type" class="type">휴태폰 인증
	<input type="radio" value="email" id="email" name="type" checked="checked" class="type">이메일 인증
	<span id="title">이메일 주소</span> : <input type="text" id="to">
	<input id="btnSend" type="button" value="인증코드 받기"><br>
	<div id="input_code">
		인증코드 입력 : <input type="text" id="userCode">
		<input type="button" value="확인" id="btnCheck">
	</div>
	<hr>
	<form action="join" method="post" id="form">
		아이디 : <input type="text" name="id"><br>
		암호 : <input type="password" name="pwd"><br>
		이름 : <input type="text" name="name"><br>
		전화 : <input type="text" name="phone"><br>
		이메일 : <input type="text" name="email"><br>
		<input type="submit" value="가입">
		<input type="reset" value="취소">
	</form>
</body>
</html>