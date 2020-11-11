<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	boolean result = (boolean)request.getAttribute("result");
    	String memberId = (String)request.getAttribute("checkId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	#checked-container{
		text-align: center;
		padding-top: 50px;
	}
	#checked{
		color:red;
		font-weight:bold;
	}
</style>
<body>
	<div id="checked-container">
		<%if(result == true){ %>
			[<span>><%=memberId %></span>]는 사용이 가능합니다.
			<br><br>
			<button onclick="closeWindow();">닫기</button>
		<%} else { %>
			[<span id="checked">><%=memberId %></span>]는 사용이 가능합니다.
			<form action="/checkId">
				<input type="text" name="checkId" placeholder="아이디를 입력하세요"><br>
				<button>중복검사</button>
			</form>
		<%} %>
	</div>
</body>
</html>