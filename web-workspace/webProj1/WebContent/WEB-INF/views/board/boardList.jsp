

<%@page import="java.util.ArrayList"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    	String pageNavi = (String)(request.getAttribute("pageNavi"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#pageNavi>*{
		margin : 10px;
		
	}
	.selectPage{
		font-size:18px;'
		color :blue;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	
	<section>
	
		
		<div class="table-wrapper" style="text-align:center;width:80%;margin:0 auto;">
		<%if(m!=null) {%>
			<div style="text-align: right;">
			<a href="/boardWriteFrm" class="btn btn-primary btn-sm">글쓰기</a>
		</div>
		<%} %>
			<table class="table table-striped">
				<tr>
					<th colspan="4" style="font-size:20px; font-weight:bold">
						자유게시판
					</th>
				</tr>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
				</tr>
				<%for(Board n : list) {%>
				<tr>
					<th><%=n.getBoardNo() %></th>
					<th><a href="/boardView?boardNo=<%=n.getBoardNo() %>"><%=n.getBoardTitle() %></a></th>
					<th><%=n.getBoardwriter() %></th>
					<th><%=n.getBoardDate() %></th>					
				</tr>
				<%} %>
			</table>
			<div id="pageNavi"><%=	pageNavi %></div>
			
		</div>
	</section>
</body>
</html>