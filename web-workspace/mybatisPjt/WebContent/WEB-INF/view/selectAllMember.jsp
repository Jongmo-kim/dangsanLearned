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
	<h1>전체 멤버 정보</h1>
	<hr>
<c:forEach items="${list }" var="m">
		번호 : ${m.memberNo }<br>
		아이디 : ${m.memberId }<br>
		<c:if test="${m.memberPw != null }">
		비밀번호 : ${m.memberPw }<br>
		</c:if>
		<c:if test="${m.memberName!= null }">
		이름: ${m.memberName }<br>
		</c:if>
		
		주소 : ${m.addr }<br>
		<hr>
		
</c:forEach>
	<a href="/">메인페이지로</a>
</body>
</html>