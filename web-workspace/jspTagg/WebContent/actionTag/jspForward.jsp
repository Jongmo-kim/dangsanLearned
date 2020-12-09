<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp:include tag</h1>
	<hr>
	<%if(false) {%>
	<jsp:forward page="/actionTag/forward.jsp"/>
	<%}else { %>
	<jsp:forward page="/actionTag/forward2.jsp"/>
	<%} %>
</body>
</html>