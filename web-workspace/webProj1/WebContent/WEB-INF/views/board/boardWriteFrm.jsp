<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 작성</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="width: 80%; margin: 0 auto">
		<!--  파일을 보내려면 post형식, enctype 설정해두어야함-->
			<form action="/insertBoard" method="post" enctype="multipart/form-data">
			<table class="table">
				<tr>
					<th colspan="2">자유게시글 작성</th>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" class="form-control" name="boardTitle"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="filename"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=m.getMemberId() %></td>
					<input type="hidden" name="boardWriter" value="<%=m.getMemberId()%>">
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="boardContent" rows="3" cols="40"></textarea>
					</td>
				</tr>
				<tr style="text-align: center;">
					<th colspan="2">
						<button type="submit" class="btn btn-primary">등록하기</button>
					</th>
					
				</tr>
				</table>
			</form>
		</div>
	</section>
</body>	
</html>