<%@page import="user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저검색페이지</title>
</head>
<body>

	<h1>회원 정보 조회</h1>
	<form action="/searchUser" method="get">
		<input type="text" placeholder="회원번호입력" name="userNo">
		<button>조회</button>
	</form>

</body>
</html>