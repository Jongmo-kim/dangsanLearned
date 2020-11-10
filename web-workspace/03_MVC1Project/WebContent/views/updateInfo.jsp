<%@page import="member.model.dao.MemberDao"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //1. 인코딩
    request.setCharacterEncoding("utf-8");
    //2. view에서 보낸 데이터 저장
    Member member = new Member();
    Member loginMember = (Member)session.getAttribute("loginMember");
    member.setMemberId(request.getParameter("memberId"));
    
   	member.setMemberNo(loginMember.getMemberNo());
    member.setMemberPw(request.getParameter("memberPw"));
    member.setMemberName(request.getParameter("memberName"));
    member.setGender(request.getParameter("gender"));
    member.setEmail(request.getParameter("email"));
    member.setPhone(request.getParameter("phone"));
    //3. 비지니스 로직
    int result = new MemberDao().updateMember(loginMember.getMemberNo(),member);
    
    //4. 결과처리
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if (result == 0 ) {%>
	<h1>수정 실패</h1>
	<a href="/">메인 페이지로</a>
	<%} else {
	session.setAttribute("loginMember", member);%>
	
	<h1>수정 성공</h1>
	<a href="/">메인 페이지로</a>
	<%} %>
</body>
</html>