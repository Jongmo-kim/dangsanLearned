<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 학생 정보</h1>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th><th>이름</th><th>전화번호</th><th>EMAIL</th><th>주소</th>
		</tr>
		<c:forEach items="${list }" var="s">
			<tr>
				<td>${s.studentNo }</td>
				<td>${s.studentName }</td>
				<td>${s.studentPhone }</td>
				<td>${s.email }</td>
				<td>${s.addr }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/">메인페이지로</a>
</body>
</html>