<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<div class="table-wrapper" style="text-align:center;width:80%;margin:0 auto;">
		<c:if test="${sessionScope.member != null && sessionScope.member.memberLevel }">
			<div style="text-align: right;">
				<a href="/noticeWriteFrm" class="btn btn-primary btn-sm">글쓰기</a>
			</div>
		</c:if>
		<table class="table table-striped">
				<tr>
					<th colspan="4" style="font-size:20px; font-weight:bold">
						공지사항
					</th>
				</tr>
				<tr>
					<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th>
				</tr>
				<tr>
					<th>${n.rNum }</th>
					<th><a href="/noticeView?noticeNo=${n.noticeNo }">${n.noticeTitle }</a></th>
					<th>${n.noticeWriter }</th>
					<th>${n.noticeDate }</th>					
				</tr
				>
			</table>
			<div id="pageNavi"></div>
			</div>
	</section>
</body>
</html>