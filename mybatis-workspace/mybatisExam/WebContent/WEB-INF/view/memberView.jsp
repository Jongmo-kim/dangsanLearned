<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>
	<form action="/updateMember">
	<fieldset>
	<legend><h1>회원정보 수정하기</h1></legend>
		번호 : <input type="text" name="memberNo" value="${loginMember.memberNo }" readonly><br>
		아이디 : <input type="text" name="memberId" value="${loginMember.memberId }" readonly><br>
		비밀번호 : <input type="text" name="memberPw" value="" required><br>
		이름 : <input type="text" name="memberName"value="${loginMember.memberName }" readonly><br>
		나이 : <input type="text" name="age" value="${loginMember.age }" readonly><br>
		주소 : <input type="text" name="addr"  value="${loginMember.addr}" required><br>
		가입일 : <input type="text" name="regDate" value="${loginMember.regDate}"readonly><br>
		<button>수정하기</button>
	</fieldset>
	</form>
	<a href="/">메인페이지로</a>
</body>
</html>