<%@page import="user.model.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
    	User u = (User)request.getAttribute("user");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회 결과</title>
</head>
<body>
		<table border="1">
			<tbody>
				<tr>
					<th>회원번호</th>
					<th>회원아이디</th>
					<th>회원이름</th>
					<th>회원나이</th>
				</tr>
				<tr>
					<th><%=u.getUserNo() %></th>
					<th><%=u.getUserId() %></th>
					<th><%=u.getUserName() %></th>
					<th><%=u.getUserAge() %></th>
				</tr>
			</tbody>
		</table>
</body>
</html>