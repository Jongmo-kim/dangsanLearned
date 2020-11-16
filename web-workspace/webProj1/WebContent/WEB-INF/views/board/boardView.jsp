<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	Board currBoard = (Board)request.getAttribute("currBoard");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="width:80%; margin:0 auto;">
			<table class="table table-bordered">
				<tr>
					<th colspan="2"><%=currBoard.getBoardTitle() %></th>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=currBoard.getBoardwriter() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(currBoard.getBoardFileName() != null) {%>
						<img src="/img/file.png" width="16px" />
						<a href="#"><%=currBoard.getBoardFileName() %></a>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><%=currBoard.getBoardContentBr() %></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<%if(m != null && m.getMemberId().equals(currBoard.getBoardwriter())) {%>
						<a href="/noticeUpdateFrm?noticeNo=<%=currBoard.getBoardNo() %>" class="btn btn-primary btn-sm">수정하기</a>
						<a href="/noticeDelete?noticeNo=<%=currBoard.getBoardNo() %>" class="btn btn-primary btn-sm">삭제하기</a>
						<%} %>
						<a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
					</th>
				</tr>
			</table>
		</div>
	</section>
</body>
</html>