<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Member member = (Member)session.getAttribute("loginMember");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<form action="/updateMember" method="post">
		번호: <input type="text" name="memberNo" value="<%=member.getMemberNo() %>" readonly><br>
		아이디: <input type="text" name="memberId" value="<%=member.getMemberId() %>" readonly><br>
		비밀번호: <input type="text" name="memberPw" value="<%=member.getMemberPw() %>" readonly><br>
		이름: <input type="text" name="memberName" value="<%=member.getMemberName() %>" readonly><br>
		전화번호: <input type="text" name="phone" value="<%=member.getPhone() %>" readonly><br>
		이메일: <input type="text" name="email" value="<%=member.getEmail() %>" readonly><br>
		성별: <input type="text" name="gender" value="<%=member.getGender() %>" readonly><br>
		가입일: <input type="text" name="enrollDate" value="<%=member.getEnrollDate() %>" readonly><br>
	</form>
</body>
</html>