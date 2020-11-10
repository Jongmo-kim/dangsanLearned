<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Member loginMember = (Member)session.getAttribute("loginMember");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>indexjsp</title>
</head>
<body>
	<h1>회원가입관리mvc1</h1>
	<hr>
	<% if(loginMember == null) {%>
		<h3>1. <a href="/views/loginFrm.html">로그인</a></h3>
		<h3>2. <a href="/views/joinFrm.html">회원가입</a></h3>
	
	<% } else {%>
		<h3>환영합니다,[<%=loginMember.getMemberName() %>]사령관님</h3>
		<h3>1. <a href="/views/mypage.jsp">마이페이지</a></h3>
		<h3>2. <a href="/views/logout.jsp">logout</a></h3>
		<h3>3. <a href="/views/exitMember.jsp">회원탈퇴</a></h3>
	<% } %>
	
</body>
</html>