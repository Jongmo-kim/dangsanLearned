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
	<c:choose>
		<c:when test="${num==1 }">
			1을 입력하셧군요
		</c:when>
		<c:when test="${num==2 }">
			2을 입력하셧군요
		</c:when>
		<c:when test="${num==3 }">
			3을 입력하셧군요
		</c:when>
		<c:otherwise>
			1~3중에 하나를 입력해달라고 요청했지만..
		</c:otherwise>
	</c:choose>
		
</body>
</html>