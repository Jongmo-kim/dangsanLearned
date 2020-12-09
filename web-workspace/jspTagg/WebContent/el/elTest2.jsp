<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>첫 번째 회원</h2>
	이름 : ${list[0].name }<br>
	나이 : ${list[0].age}<br>
	주소 : ${list[0].addr }<br>
	<h2>두 번째 회원</h2>
	이름 : ${list[1].name }<br>
	나이 : ${list[1].age}<br>
	주소 : ${list[1].addr }<br>
	
</body>
</html>