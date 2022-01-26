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
	<h2>게시물 목록</h2>
	<a href="insertBoard">등록</a><br>
	<form action="listBoard" method="post">
		<select name="searchColumn">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	<table border="1" width="80%">
		<tr>
			<td><a href="listBoard?orderColumn=no">글번호</a></td>
			<td><a href="listBoard?orderColumn=title">제목</a></td>
			<td><a href="listBoard?orderColumn=writer">작성자</a></td>
			<td><a href="listBoard?orderColumn=hit">조회수</a></td>
			<td><a href="listBoard?orderColumn=ip">ip</a></td>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td>
					<a href="detailBoard?no=${b.no }">${b.title }</a>
				</td>
				<td>${b.writer }</td>
				<td>${b.hit }</td>
				<td>${b.ip }</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listBoard?pageNUM=${i }">${i }</a>&nbsp;&nbsp;
	</c:forEach>
</body>
</html>










