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
<title>Insert title here</title>
</head>
<body>
<%if (loginMember == null) {%>
	<fieldset>
	<legend>로그인</legend>
	<form action="/login" method="post">
		아이디 : <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		<button>로그인</button>
		<button type="reset">초기화</button>
		<br>
		<a href="/views/joinFrm.html">회원가입</a>
	</form>
	
	</fieldset>
<% } else{%>
<h1>[<%=loginMember.getMemberName() %>]</h1>
<h3><a href="/mypage">마이페이지</a></h3>
<h3><a href="/selectAllMember">전체회원 조회</a></h3>
<%} %>	
</body>
</html>