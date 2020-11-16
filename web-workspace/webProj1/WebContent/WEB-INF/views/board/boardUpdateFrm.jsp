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
<title>게시판 수정</title>
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="width:80%; margin:0 auto;">
			<form action="/boardUpdate" method="post" enctype="multipart/form-data">
				<input type="hidden" name="boardNo" value="<%=currBoard.getBoardNo() %>">
				<table class="table table-bordered">
					<tr>
						<th colspan="2">
							<input type="text" name="boardTitle" class="form-control" value="<%=currBoard.getBoardTitle() %>">
						</th>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=currBoard.getBoardwriter() %></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td>
							<input type="hidden" id="status" name="status" value="stay">
							<%if(currBoard.getBoardFileName() != null){ %>
								<img src="/img/file.png" width="16px" class="delFile">
								<input type="file" name="filename" id="file" style="display:none;">
								<span class="delFile"><%=currBoard.getBoardFileName() %></span>
								<button type="submit" id="fileDelBtn" class="btn btn-primary btn-sm delFiles">삭제</button>
								<input type="hidden" name="oldFilename" value="<%=currBoard.getBoardFileName() %>">
								<input type="hidden" name="oldFilepath" value="<%=currBoard.getBoardFilePath() %>">
								
							<%} else { %>
								<input type="file" name="filename">
							<%} %>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="boardContent" class="form-control" rows="3" cols="40"><%=currBoard.getBoardContent() %></textarea>
						</td>
					</tr>
					
					<tr>
						<th colspan="2">
							<button type="submit" class="btn btn-primary">수정완료</button>
							<a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
						</th>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<script>
		$("#fileDelBtn").click(function(){
			if(confirm('첨부파일을 삭제하시겠습니까? ')){
				$(".delFile").hide();
				$("#file").show();
				$("#status").val('delete');
			}
		});
	</script>
</body>
</html>