<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 정보 수정</h1>
	<hr>
	<form action="/updateStudent" method="post">
	<fieldset>
		번호 : <input type="text" value="${s.studentNo }" name="studentNo" readonly>
		이름 : <input type="text" value="${s.studentName }" name="studentName" >
		전화번호 : <input type="text" value="${s.studentPhone }" name="studentPhone" >
		이메일 : <input type="text" value="${s.email }" name="email" >
		주소 : <input type="text" value="${s.addr }" name="addr" >
		<button>수정하기</button>
	</fieldset>
	</form>
</body>
</html>