<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Notice n = (Notice)request.getAttribute("n");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="width:80%; margin:0 auto;">
			<table class="table table-bordered">
				<tr>
					<th colspan="2"><%=n.getNoticeTitle() %></th>
				</tr>
				<tr>
					<th>작성자</th>
					<td><%=n.getNoticeWriter() %></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<%if(n.getNoticeFileName() != null) {%>
						<img src="/img/file.png" width="16px" />
						<a href="#"><%=n.getNoticeFileName() %></a>
						<%} %>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><%=n.getNoticeContentBr() %></td>
				</tr>
				
				<tr>
					<th colspan="2">
						<%if(m != null && m.getMemberId().equals(n.getNoticeWriter())) {%>
						<a href="/noticeUpdateFrm?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-primary btn-sm">수정하기</a>
						<a href="/noticeDelete?noticeNo=<%=n.getNoticeNo() %>" class="btn btn-primary btn-sm">삭제하기</a>
						<%} %>
						<a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
					</th>
				</tr>
			</table>
		</div>
	</section>
	<script>
	function fileDownload(filename,filepath) {
		var url = "/noticeFileDownload";
		var encFilename = encodeURIComponent(fileName);
		var encFilename = encodeURIComponent(fileName);
		location.href=url+"?filename"+encFileName+"&filepath="+encFilePath;
	}
	</script>
</body>
</html>