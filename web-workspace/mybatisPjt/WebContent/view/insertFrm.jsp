<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생등록페이지</h1>
	<hr>
	<form action="/insert" method="post">
		<fieldset>
			이름: <input type="text" name="studentName"><br>
			전화번호: <input type="text" name="studentPhone"><br>
			이메일: <input type="text" name="email"><br>
			주소: <input type="text" name="addr"><br>
			<button>등록하기</button>
		</fieldset>
	</form>
</body>
</html>