<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
			<table class="table table-striped">
				<tr>
					<th colspan="4" style="font-size:20px; font-weight:bold">
						공지사항
					</th>
				</tr>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
				</tr>
				<%for(Notice n : list) {%>
				<tr>
					<th><%=n.getNoticeNo() %></th>
					<th><a href="/noticeView?noticeNo<%=n.getNoticeTitle() %>"><%=n.getNoticeTitle() %></a></th>
					<th><%=n.getNoticeWriter() %></th>
					<th><%=n.getNoticeDate() %></th>					
				</tr>
				<%} %>
			</table>
			<div id="pageNavi"><%=pageNavi %></div>
			
		</div>
	</section>
</body>
</html>