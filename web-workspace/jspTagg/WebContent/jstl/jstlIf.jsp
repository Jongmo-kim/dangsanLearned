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
	<c:if test="${num%2 ==0 }">
	짝수입니다.
	</c:if>
	<c:if test="${num%2 ==1 }">
	호올수입니다.
	</c:if>
</body>
</html>