<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>문자전송</h2>
	<form action="send" method="post">
	보내는 사람 : <input type="text" name="from"><br>
	받는 사람 : <input type="text" name="to"><br>
	메세지 : <input type="text" name="msg"><br>
	<input type="submit" value="전송">
	</form>
</body>
</html>