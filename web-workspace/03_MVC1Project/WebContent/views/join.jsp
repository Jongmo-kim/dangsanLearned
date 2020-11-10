<%@page import="member.model.dao.MemberDao"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //1. 인코딩
    request.setCharacterEncoding("utf-8");
    //2. veiw에서 보낸 데이터 저장
    Member member = new Member();
    member.setMemberId(request.getParameter("memberId"));
    member.setMemberPw(request.getParameter("memberPw"));
    member.setMemberName(request.getParameter("memberName"));
    member.setGender(request.getParameter("gender"));
    member.setEmail(request.getParameter("email"));
    member.setPhone(request.getParameter("phone"));
    //3. 비지니스 로직
    int result = new MemberDao().insertMember(member);
    //4. 결과처리
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 결과</h1>
	<hr>
	
	<% if(result>0){ %>
	<h3>[<%=member.getMemberName()%>]님 환영합니다.</h3>
	<a href="/views/loginFrm.html">로그인하기</a>
	<a href="/">메인페이지로 가기</a>	
	<% } else{ %>
	<h3>회원가입에 실패했습니다. 관리자에게 문의하세요.</h3>
	<a href="/">메인페이지로 가기</a>
	<%  }  %>
	
</body>
</html>