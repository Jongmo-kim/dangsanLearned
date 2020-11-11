<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="container" style="margin: 0 auto; width:80%; color:black; text-align:center;">
		<form name="checkIdFrm">
			<input type="hidden" name="checkId">
		</form>
			<form action="/join" method="post" id = "memberJoin">
				<h1>회원가입</h1>
				<table class="table">
					<tr>
						<th><label for="memberId">아이디</label></th>
						<td><input type="text" name="memberId" id="memberId" class="form-control"></td>
						<td style="width=150px;"><button type="button" class="btn btn-primary" onclick="checkId()">중복체크</button></td>
						<td style="width=150px;"><span id="idChkMsg"></span></td>
					</tr>
					<tr>
						<th><label for="memberPw">비밀번호</label></th>
						<td><input type="password" name="memberPw" id="memberPw" class="form-control"></td>
						<td style="width=150px;"></td>
					</tr>
					<tr>
						<th><label for="memberPwre">비밀번호확인</label></th>
						<td><input type="password" name="memberPwre" id="memberPwre" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
						<tr>
						<th><label for="memberName">이름</label></th>
						<td><input type="text" name="memberName" id="memberName" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="phone">전화번호</label></th>
						<td><input type="password" name="phone" id="phone" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					<tr>
						<th><label for="address">주소</label></th>
						<td><input type="password" name="address" id="address" class="form-control"></td>
						<td style="width:150px;"></td>
					</tr>
					</table>
					<hr>
					<div id="btn-box">
						<button class="btn btn-success btn-lg">회원가입</button>
						<button class="btn btn-success btn-lg" type="reset">초기화</button>
					</div>
			</form>
		</div>
	</section>
	<script>
		function checkId(){
			var memberId = $("#memberId").val();
			if(memberId == ""){
				alert('아이디를 입력하세요.');
			}
			var url = "/checkId";
			var title = "checkId";
			var status = "left = 500px, top= 100px, width=300px, height=200px, menubar=no,status=no, scrollbars=yes";
			var popup = window.open("",title,status);
			$("[name=checkId]").val(memberId);//숨겨둔input의 value속성에 사용자가 입력한 아이디값 대입
			var checkFrm = $("[name=checkIdFrm]");
			checkFrm.attr("target",title);
			checkFrm.attr("action",url);
			checkFrm.submit();
			
		}
	</script>
</body>
</html>