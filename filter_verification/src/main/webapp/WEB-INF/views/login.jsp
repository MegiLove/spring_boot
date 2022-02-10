<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<c:if test="${re == 1 }">
		로그인되었습니다.
	</c:if>
	<c:if test="${re == 0 }">
		암호가 틀렸습니다.
	</c:if>
	<c:if test="${re == -1 }">
		아이디가 존재하지 않습니다.
	</c:if>
	<c:if test="${re == 403 }">
		권한이 없는 사용자 입니다.
	</c:if>
	
	<hr>
	<form action="login" method="post">
		아이디 : <input type="text" name="id"><br>
		암호 : <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
</body>
</html>