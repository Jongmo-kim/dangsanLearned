<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<c:if test="${sessionScope.loginMember == null }">
		<fieldset>
			<legend><h1>로그인하기</h1></legend>
			<form action="/login">
				아이디 :<input type="text" name="loginId"><br>
				비밀번호 :<input type="password" name="loginPw"><br>
				<button>로그인하기</button>
			</form>
			<a href="/signupFrm">회원가입하기</a>
	</fieldset>
	</c:if>
	<c:if test="${sessionScope.loginMember != null }">
		<h1><a href="/selectAllMember">전체회원조회</a></h1>
		<h1><a href="/mypageFrm">마이페이지</a></h1>
		<h1><a href="/deleteMember">회원탈퇴</a></h1>
		<h1><a href="/logout">로그아웃</a></h1>
	</c:if>
</body>
</html>