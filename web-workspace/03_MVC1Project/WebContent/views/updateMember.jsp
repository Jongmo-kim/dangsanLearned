<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update info</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<fieldset>
		<legend>내정보</legend>
		<form action="/views/updateInfo.jsp">
			아이디 : <input type="text" name="memberId"><br>
			비밀번호 : <input type="text" name="memberPw"><br>
			이름 : <input type="text" name="memberName"><br>
			이메일 : <input type="text" name="email"><br>
			가입일 : <input type="text" name="enrollDate"><br>
			성별: 남<input type="radio" value="남" name="gender">여<input type="radio" value="여" name="gender"><br>
			휴대전화 : <input type="text" name="phone"><br>
			<button>수정하기</button>
		</form>
	</fieldset>
</body>
</html>