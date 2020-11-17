<%@page import="java.util.ArrayList"%>
<%@page import="notice.model.vo.NoticeComment"%>
<%@page import="notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Notice n = (Notice)request.getAttribute("n");
	ArrayList<NoticeComment> list = (ArrayList<NoticeComment>)request.getAttribute("list");
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/comment.css" />
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
						<a href="javascript:fileDownload('<%=n.getNoticeFileName()%>','<%=n.getNoticeFilePath()%>')">
							<%=n.getNoticeFileName() %>
						</a>
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
			<%if(m != null) {%>
			<div class="inputComment">
				<form action="/insertComment" method="post">
					<ul>
						<li>
							<input type="hidden" name="noticeCommentLevel" value ="1" />
							<input type="hidden" name="noticeCommentWriter" value ="<%=m.getMemberId() %>" />
							<input type="hidden" name="noticeRef" value ="<%=n.getNoticeNo() %>" />
							<input type="hidden" name="noticeCommentRef" value ="0" />
							<textarea class="form-control" name="noticeCommentContent"></textarea>
						</li>
						<li>
							<button class="btn btn-secondary btn-lg btn-block">등록</button>
						</li>
					</ul>
				</form>
			</div>
			<%} %>
			<div class="commentList">
			<%for(NoticeComment nc : list) {%>
				<%if(nc.getNoticeCommentLevel() == 1) {%>
					<ul>
						<li>
							<p><%=nc.getNoticeCommentWriter() %></p>
							<p><%=nc.getNoticeCommentDate() %></p>
						</li>
						<li>
							<p><%=nc.getNoticeCommentContentBr() %></p>
							<textarea name="noticeCommentContent" class="form-conrol changeComment" style="display:none;"><%=nc.getNoticeCommentContent() %></textarea>
							<%if(m!=null) {%>
							<p class="linkbox">
								<%if(m.getMemberId().equals(nc.getNoticeCommentWriter())) {%>
								
								<a href="javascript:void(0)" onclick="modifyComment(this,'<%=nc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">수정</a>
								<a href="javascript:void(0)" onclick="deleteComment(this,'<%=nc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">삭제</a>
								<%} %>		
								<a href="javascript:void(0)" class="recShow">답글달기</a>
							</p>
							<div class="inputComment re">
								<form action="/insertComment" method="post">
									<ul>
										<li>
											<input type="hidden" name="noticeCommentLevel" value ="<%=nc.getNoticeCommentLevel()+1 %>" />
											<input type="hidden" name="noticeCommentWriter" value ="<%=m.getMemberId() %>" />
											<input type="hidden" name="noticeRef" value ="<%=n.getNoticeNo() %>" />
											<input type="hidden" name="noticeCommentRef" value ="<%=nc.getNoticeCommentNo() %>" />
											<textarea class="form-control" name="noticeCommentContent"></textarea>
										</li>
										<li>
											<button class="btn btn-secondary btn-lg btn-block">등록</button>
											<button class="btn btn-secondary btn-lg btn-block recCancel" type="button">취소</button>
										</li>
									</ul>
								</form>
							</div>
							<%} %>
						</li>
					</ul>
					<%for(NoticeComment ncc : list) {//대댓글 출력%>
						<%if(ncc.getNoticeCommentLevel() == 2 
							&& ncc.getNoticeCommentRef() == nc.getNoticeCommentNo()) {%>
							<ul class="rere">
								<li>&#10551;</li>
								<li>
									<p><%=ncc.getNoticeCommentWriter() %></p>
									<p><%=ncc.getNoticeCommentDate() %></p>
								</li>
								<li>
									<p><%=ncc.getNoticeCommentContentBr() %></p>
									<textarea name="noticeCommentContent" class="form-conrol changeComment" style="display:none;"><%=nc.getNoticeCommentContent() %></textarea>
									<%if(m != null) {%>
									<p class="linkBox">
										<%if(m.getMemberId().equals(ncc.getNoticeCommentWriter())) {%>
										<a href="javascript:void(0)" onclick="modifyComment(this,'<%=ncc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">수정</a>
										<a href="javascript:void(0)" onclick="deleteComment(this,'<%=ncc.getNoticeCommentNo()%>','<%=n.getNoticeNo()%>')">삭제</a>
										<%} %>
									</p>
									<%} %>
								</li>
							</ul>
						<%} %>
					<%} %>
				<%} %>
			<%} %>
			</div>
		</div>
	</section>
	<script>
		function fileDownload(filename,filepath){
			var url = "/noticeFileDownload";
			var encFilename = encodeURIComponent(filename);
			var encFilepath = encodeURIComponent(filepath);
			location.href=url+"?filename="+encFilename+"&filepath="+encFilepath;
		}
		$(".recShow").click(function() {
			$(this).hide();
			var idx = $(".recShow").index(this);
			$(".recCancel").eq(idx).parents("div").css("display","block");
		});
		$(".recCancel").click(function() {
			var idx = $(".recCancel").index(this);
			$(this).parents(".re").css("display","none");
			$(".recShow").eq(idx).show();
		});
function modifyComment(obj,commentNo,noticeNo){
		$(obj).parent().prev().show();			//텍스트에어리어를 보여주는코드
		$(obj).parent().prev().prev().show();   //p태그를 숨기는 코드
		//수정버튼 -> 수정완료
		$(obj).html('수정완료');
		$(obj).attr('onclick','modifyComplete(this,"'+commentNo+'","'+noticeNo+'")');
		//삭제버튼 -> 수정취소
		$(obj).next().html('취소');
		$(obj).next().attr('onclick','modifyCancel(this,"'+commentNo+'","'+noticeNo+'")');
		$(obj).next().next().hide(); //답글달기버튼 숨기기
		}
function deleteComment(obj,commentNo,noticeNo){
	if(confirm("댓글을 삭제하시겠습니까?")){
		location.href="/noticeCommentDelete?noticeCommentNo="+commentNo+"&noticeNo="+noticeNo;
	}
}
function modifyCancel(obj,commentNo,noticeNo){
	$(obj).parent().prev().hide();			//텍스트에어리어를 숨겨주는코드
	$(obj).parent().prev().prev().show();   //p태그를 봉여주는 코드
	//수정완료 -> 수정
	$(obj).prev().html('수정');
	$(obj).prev().attr('onclick','modifyComment(this,"'+commentNo+'","'+noticeNo+'")');
	//취소 -> 삭제
	$(obj).next().html('삭제');
	$(obj).next().attr('onclick','deleteComment(this,"'+commentNo+'","'+noticeNo+'")');
	$(obj).next().show(); //답글달기버튼 숨기기
}
function modifyComplete(obj,commentNo,noticeNo){
	var form = $("<form action='/noticeCommentUpdate' method='post'></form>");
	form.append($("<input type='text' name='noticeCommentNo' value='"+commentNo+"'>"));
	form.append($("<input type='text' name='noticeNo' value='"+noticeNo+"'>"));
	form.append($(obj).parent().prev());
	$("body").append(form);
	form.submit();
	
}

	</script>
</body>
</html>