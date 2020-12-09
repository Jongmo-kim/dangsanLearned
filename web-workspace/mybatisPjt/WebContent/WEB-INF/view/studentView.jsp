<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>번호 :${s.studentNo }</li>
		<li>이름 :${s.studentName }</li>
		<li>핸드폰번호 :${s.studentPhone }</li>
		<li>이메일 :${s.email }</li>
		<li>주소 :${s.addr }</li>
	</ul>
	<a href="/">메인페이지로</a>
</body>
</html>