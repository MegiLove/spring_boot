<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${head }</h2>
	<hr>
	<form action="insertBoard" method="post" 
		enctype="multipart/form-data">
		
		<!-- 만약에 새글이면 0
			만약에 답글이면 부모글의 글번호가 전달이 됩니다. -->
		<input type="hidden" name="no" value="${no }">
		
		제목 : <input type="text" name="title" value="${title }"><br>
		작성자 : <input type="text" name="writer"><br>
		암호 : <input type="password" name="pwd"><br>
		내용 : <br>
		<textarea rows="10" cols="80" name="content"></textarea><br>
		첨부파일 : <input type="file" name="uploadFile"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
</body>
</html>