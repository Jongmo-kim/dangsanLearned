<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//변수명 m이 안되는이유 : 헤더에서 사용한변수명이 겹쳐서 그럼
    	Member member = (Member)request.getAttribute("member");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<form action="/updateMember" method="post" style="width: 800px; margin: 0 auto;color:cornflowerblue;">
		<h1>마이페이지</h1>
		<table class="table">
			<tr>
				<th>회원번호</th>
				<td><input type="text" name="memberNo" class="form-control" value="<%=member.getMemberNo() %>" readonly></td>				
			</tr>
			
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memberId" class="form-control" value="<%=member.getMemberId() %>" readonly></td>				
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="memberPw" class="form-control" value="<%=member.getMemberPw() %>" ></td>				
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone" class="form-control" value="<%=member.getPhone() %>" ></td>				
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="memberName" class="form-control" value="<%=member.getMemberName() %>" readonly></td>				
			</tr>
			<tr>
				<th>회원등급</th>
				<td>
					<%if(member.getMemberLevel()==1) { %>
						<span>관리자</span>			
					<%} else if(member.getMemberLevel()==2) {  %>
						<span>평민</span>
					<%} %>				
			</tr>
			<tr>
				<th>가입일</th>
				<td><input type="text" name="enroll" class="form-control" value="<%=member.getEnrollDate() %>" readonly></td>				
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" class="form-control" value="<%=member.getAddress() %>" ></td>				
			</tr>
			<tr>
				<th colspan="2" style="text-align: center">
				<button class="btn btn-outline-danger btn-lg" type="submit">수정하기</button>
				<%if(member.getMemberLevel()==1) {%>
					<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/adminPage'">회원관리</button>
				<%} else{ %>
					<button class="btn btn-outline-danger btn-lg" type="button" onclick="location.href='/deleteMember?memberId=<%=member.getMemberId()%>'">회원탈퇴</button>
				<%} %>
		</table>
	</form>
</body>
</html>