<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생관리프로그램</h1>
	<hr>
	<h1><a href="/view/insertFrm.jsp">1. 학생 등록</a></h1>
	<form action="/searchStudent">
		<input type="text" name="studentNo" placeholder="학생번호입력">
		<button>조회</button>
	</form>
	<h2><a href="/searchAllStudent">3. 학생 전체 조회</a></h2>
	<form action="/deleteStudent">
		<input type="text" name="studentNo" placeholder="삭제할 번호 입력">
		<button>삭제</button>
	</form>
	<form action="/updateStudentFrm">
		<input type="text" name="studentNo" placeholder="수저ㅕㅇ할학생번호입력">
		<button>수정페이지로</button>
	</form>
	<hr>
	<form action="/loginMember" method="post">
		아이디 : <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		<input type="submit" value="로그인">
	</form>
		<form action="/searchMember" method="post">
		아이디 : <input type="text" name="memberId"><br>
		<input type="submit" value="조회">
	</form>
	<form action="/selectAllMember" method="post">
		<input type="checkbox" name="chkPw">비밀번호
		<input type="checkbox" name="chkName"> 이름
		<input type="submit" value="조회">
	</form>
</body>
</html>