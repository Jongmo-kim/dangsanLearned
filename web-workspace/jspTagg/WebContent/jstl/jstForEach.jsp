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
	<h1>JSTL 사용</h1>
	<hr>
	<table border=1>
		<tr>
			<th>번호</th><th>이름</th><th>나이</th><th>주소</th>
		</tr>
		<c:forEach items="${list }" var="m" varStatus="i">
			<tr>
				<td><c:out value="${i.count }"/></td>
				<td>${m.name }</td>
				<td>${m.age }</td>
				<td>${m.addr }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>