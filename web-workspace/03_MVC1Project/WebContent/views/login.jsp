<%@page import="member.model.dao.MemberDao"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%
		request.setCharacterEncoding("utf-8");
	
	String memberId = request.getParameter("memberId");
	String memberPw = request.getParameter("memberPw");
	Member member = new Member();
	member.setMemberId(memberId);
	member.setMemberPw(memberPw);
	Member loginMember = new MemberDao().selectOneMember(member);
	//4. 결과 처리
	//로그인 성공한 경우 - > session 등록, 로그인성공 알림창, 메인페이지이동
	//로그인 실패한 경우 -> 아이디 또는 비밀번호 확인 알림창, 로그인페이지로 이동
	if(loginMember != null){
		session.setAttribute("loginMember", loginMember);	
	}
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		<% if(loginMember != null){ %>
			alert('로그인 성공');
			location.href="/";
		<%} else {%>
			alert("아이디 또는 비밀번호를 확인해주세요");
			location.href="/views/loginFrm.html";
		<%}%>
		
	</script>
</body>
</html>
	