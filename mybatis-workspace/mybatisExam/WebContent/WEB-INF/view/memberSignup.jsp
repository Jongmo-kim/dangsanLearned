<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입페이지</title>
</head>
<body>
	<form action="/signup">
	<fieldset>
	<legend><h1>회원 가입하기</h1></legend>
		아이디 : <input type="text" name="memberId" required><br>
		비밀번호 : <input type="text" name="memberPw" required><br>
		이름 : <input type="text" name="memberName" ><br>
		나이 : <input type="text" name="age"><br>
		주소 : <input type="text" name="addr"><br>
		<button>가입하기</button>
	</fieldset>
	</form>
	<a href="/">메인페이지로</a>
</body>
</html>