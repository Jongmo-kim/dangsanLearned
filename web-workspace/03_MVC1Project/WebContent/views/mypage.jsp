<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //1.인코딩
    request.setCharacterEncoding("utf-8");
    //2. view에서 온 데이터 저장
    //3. 비지니스 로직
    Member loginMember = (Member)session.getAttribute("loginMember");
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
	<fieldset>
		<legend>내정보</legend>
		<form action="/views/updateMember.jsp" method="post">
			번호 : <input type="text" name="memberNo" value="<%=loginMember.getMemberNo() %>" readonly><br>
			아이디 : <input type="text" name="memberId" value="<%=loginMember.getMemberId() %>" readonly><br>
			비밀번호 : <input type="text" name="memberPw" value="<%=loginMember.getMemberPw() %>" readonly><br>
			이름 : <input type="text" name="memberName" value="<%=loginMember.getMemberName() %>" readonly><br>
			이메일 : <input type="text" name="email" value="<%=loginMember.getEmail()%>" readonly><br>
			가입일 : <input type="text" name="enrollDate" value="<%=loginMember.getEnrollDate() %>" readonly><br>
			성별 : <input type="text" name="gender" value="<%=loginMember.getGender() %>" readonly><br>
			휴대전화 : <input type="text" name="phone" value="<%=loginMember.getPhone() %>" readonly><br>
			<button>정보 수정</button>
		</form>
	</fieldset>
</body>
</html>