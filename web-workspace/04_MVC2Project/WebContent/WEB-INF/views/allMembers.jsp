<%@page import="java.util.ArrayList"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Member> memberList = (ArrayList<Member>)session.getAttribute("memberList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모든 회원 조회</title>
</head>
<body>
	<table>
	<tr>
	<th>번호</th>
	<th>아이디</th>
	<th>비밀번호</th>
	<th>이름</th>
	<th>휴대전화</th>
	<th>이메일</th>
	<th>성별</th>
	<th>가입일</th>
	</tr>
	<%for(Member m : memberList){%>
	 <tr>
	 	<%=m.toMemberThTag()%>
	 </tr>
	 <%} %>
	</table>
</body>
</html>