<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    MemberDao에서
result = pstmt.executeQuery()실행
conn.setAutoCommit(false);추가

JoinServlet에서
String memberPw = request.getParameter("password");
-> String memberPw = request.getParameter("memberPw");

Member member = new Member(); ->	
		Member member = new Member();추가
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);


JoinResult.jsp에서
(String) request.getAttribute("message");
-> (String)request.getAttribute("msg"); 로변경


    
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<a href="/joinFrm">회원가입하기</a>
</body>
</html>