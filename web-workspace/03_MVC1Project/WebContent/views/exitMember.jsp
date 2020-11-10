<%@page import="member.model.dao.MemberDao"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member loginMember = (Member)session.getAttribute("loginMember");
    	int result = new MemberDao().deleteOneMember(loginMember);
    	session.invalidate();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<% if(result>0){%>
	<h1>탈퇴되엇습니다 ㅂㅂ</h1>
	<a href="/">메인페이지로...</a>
	<%}else { %>
	<h1>안되엇네요 이런 </h1>
	<a href="/">메인페이지로...</a>
	<% } %>
</body>
</html>