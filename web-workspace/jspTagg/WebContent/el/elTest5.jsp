<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 연산자</h1>
	<hr>
	<h3>첫번째 회원 정보</h3>
	이름 : ${requestScope.m1.name }<br>
	나이 : ${requestScope.m2.age }<br>
	주소 : ${requestScope.m3.addr }<br>
	<h3>첫번째 회원 정보</h3>
	이름 : ${requestScope.m1.name }<br>
	나이 : ${requestScope.m1.age }<br>
	주소 : ${requestScope.m1.addr }<br>
	<h3>2번째 회원 정보</h3>
	이름 : ${requestScope.m2.name }<br>
	나이 : ${requestScope.m2.age }<br>
	주소 : ${requestScope.m2.addr }<br>
	<h3>3번째 회원 정보</h3>
	이름 : ${sessionScope.m3.name }<br>
	나이 : ${sessionScope.m3.age }<br>
	주소 : ${sessionScope.m3.addr }<br>
	<h3>4번째 회원 정보</h3>
	이름 : ${sessionScope.m4.name }<br>
	나이 : ${sessionScope.m4.age }<br>
	주소 : ${sessionScope.m4.addr }<br>
</body>
</html>