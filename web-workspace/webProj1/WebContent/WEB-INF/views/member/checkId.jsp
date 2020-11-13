<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	boolean result = (boolean)request.getAttribute("result");
    	String checkId = (String)request.getAttribute("checkId");
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
			[<span>><%=checkId %></span>]는 사용이 가능합니다.
			<br><br>
			<button onclick="closeWindow('<%=checkId%>');">닫기</button>
		<%} else { %>
			[<span id="checked">><%=checkId %></span>]는 사용이 가능합니다.
			<form action="/checkId">
				<input type="text" name="checkId" placeholder="아이디를 입력하세요"><br>
				<button>중복검사</button>
			</form>
		<%} %>
	</div>
	<script>
		function closeWindow(checkId){
			var memberId = opener.document.getElementById("memberId");
			var memberPw = opener.document.getElementById("memberPw");
			memberId.value = checkId;
			memberPw.focus();
			self.close();
		}
	</script>
</body>
</html>