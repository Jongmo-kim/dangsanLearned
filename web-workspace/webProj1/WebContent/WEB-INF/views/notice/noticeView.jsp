<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<section>
	<div class="table-wrapper" style="width: 80%; margin: 0 auto">
		<table class="table table-bordered">
			<tr>
				<th colspan="2">${n.noticeTitle }</th>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${n.noticeWriter }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><c:if test="${n.noticeFileName != null }">
						<img src="/img/file.png" width="16px">
						<a
							href="javascript:fileDownload('${n.noticeFileName }','${n.noticeFilePath }')">
							${n.noticeFileName } </a>
					</c:if></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${n.noticeContentBr }</td>
			</tr>
			<tr>
				<th colspan="2">
					<c:if test="${sessionScope.member != null && sessionScope.member.memberId.equals(n.noticeWriter)}">
						<a href="/noticeUpdateFrm?noticeNo=${n.noticeNo }"
							class="btn btn-primary btn-sm">수정하기</a>
						<a href="/noticeDelete?noticeNo=${n.noticeNo }"
							class="btn btn-primary btn-sm">삭제하기</a>
					</c:if> <a href="javascript:history.go(-1)" class="btn btn-primary btn-sm">목록으로</a>
				</th>
			</tr>
		</table>
		<c:if test="${sessionScope.member != null }">
			<div class="inputComment">
				<form action="/insertNoticeComment" method="post">
					<ul>
						<li><input type="hidden" name="noticeCommentLevel" value="1">
							<input type="hidden" name="noticeCommentWriter"
							value="${sessionScope.member.memberId}"> <input
							type="hidden" name="noticeRef" value="${n.noticeNo }"> <input
							type="hidden" name="noticeCommentRef" value="0"> <textarea
								class="form-control" name="noticeCommentContent"></textarea></li>
						<li>
							<button type="submit" class="btn btn-secondary btn-lg btn-block">등록</button>
						</li>
					</ul>
				</form>
			</div>
		</c:if>
		<div class="commentList">
			<c:forEach items="${list }" var="nc" varStatus="i">
				<c:if test="${nc.noticeCommentLevel ==1 }">
					<ul>
						<li>
							<p>${nc.noticeCommentWriter }</p>
							<p>${nc.noticeCommentDate }</p>
						</li>
						<li>
							<p>${nc.noticeCommentContentBr }</p> <textarea
								name="noticeCommentContent" class="form-control changeComment"
								style="display: none;">${nc.noticeCommentContent }</textarea> 
								<c:if test="${sessionScope.member != null }">
								<p class="linkBox">
									<c:if
										test="${sessionScope.member.memberId.equals(nc.noticeCommentWriter)}">
										<a href="javascript:void(0)"
											onclick="modifyComment(this,'${nc.noticeCommentNo }','${n.noticeNo }')">수정</a>
										<a href="javascript:void(0)"
											onclick="deleteComment(this,'${nc.noticeCommentNo }','${n.noticeNo }')">삭제</a>
									</c:if>
									<a href="javascript:void(0)" class="recShow">답글달기</a>
								</p>
								<div class="inputComment re">
									<form action="/insertNoticeComment" method="post">
										<ul>
											<li><input type="hidden" name="noticeCommentLevel"
												value="2"> <input type="hidden"
												name="noticeCommentWriter"
												value="${sessionScope.member.memberId}"> <input
												type="hidden" name="noticeRef" value="${n.noticeNo}">
												<input type="hidden" name="noticeCommentRef"
												value="${nc.noticeCommentNo}"> <textarea
													class="form-control" name="noticeCommentContent"></textarea>
											</li>
											<li>
												<button type="submit"
													class="btn btn-secondary btn-lg btn-block">등록</button>
												<button type="button"
													class="btn btn-secondary btn-lg btn-block recCancel">취소</button>
											</li>
										</ul>
									</form>
								</div>
							</c:if>
						</li>
					</ul>
					<c:forEach items="${list }" var="ncc" varStatus="i">
						<c:if
							test="${ncc.noticeCommentLevel==2 && ncc.noticeCommentRef == nc.noticeCommentNo }">
							<ul class="rere">
								<li>└></li>
								<li>
									<p>${ncc.noticeCommentWriter }</p>
									<p>${ncc.noticeCommentDate }</p>
								</li>
								<li>
									<p>${ncc.noticeCommentContentBr }</p> <textarea
										name="noticeCommentContent" class="form-control changeComment"
										style="display: none;">${ncc.noticeCommentContent }</textarea>
									<c:if test="${sessionScope.member !=null}">
										<p class="linkBox">
											<c:if test="${sessionScope.member.memberId.equals(ncc.noticeCommentWriter) }">
												<a href="javascript:void(0)"
													onclick="modifyComment(this,'${ncc.noticeCommentNo }','${n.noticeNo }')">수정</a>
												<a href="javascript:void(0)"
													onclick="deleteComment(this,'${ncc.noticeCommentNo }','${n.noticeNo }'')">삭제</a>
											</c:if>
										</p>
									</c:if>
								</li>
							</ul>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</div>
	</div>
	</section>
	<script>
		function fileDownload(filename,filepath){
			var url = "/noticeFileDownload";
			var encFilename = encodeURIComponent(filename);
			var encFilepath = encodeURIComponent(filepath);					
			location.href= url+"?filename="+encFilename+"&filepath="+encFilepath;
		}
		$('.recShow').click(function(){
			$(this).hide();
			var idx = $('.recShow').index(this);
			$('.recCancel').eq(idx).parents("div").css("display","block");
		});
		$('.recCancel').click(function(){
			var idx = $('.recCancel').index(this);
			$(this).parents(".re").css("display","none");
			$(".recShow").eq(idx).show();
		});
		function modifyComment(obj,commentNo,noticeNo){
			$(obj).parent().prev().show();			//textarea보여주기
			$(obj).parent().prev().prev().hide();	//p태그 숨기기
			//수정버튼 -> 수정완료
			$(obj).html("수정완료");
			$(obj).attr('onclick','modifyComplete(this,"'+commentNo+'","'+noticeNo+'")');
			//삭제버튼->수정취소
			$(obj).next().html("취소");
			$(obj).next().attr('onclick','modifyCancel(this,"'+commentNo+'","'+noticeNo+'")');
			$(obj).next().next().hide();//답글달기버튼 숨기기
		}
		function modifyCancel(obj,commentNo,noticeNo){
			$(obj).parent().prev().hide();			//textarea숨기기
			$(obj).parent().prev().prev().show();	//p태그 보여주기
			//수정완료 -> 수정버튼
			$(obj).prev().html('수정');
			$(obj).prev().attr('onclick','modifyComment(this,"'+commentNo+'","'+noticeNo+'")');
			//수정취소-> 삭제버튼
			$(obj).html('삭제');
			$(obj).attr('onclick','deleteComment(this,"'+commentNo+'","'+noticeNo+'")');
			//답글달기 버튼 보여주기
			$(obj).next().show();
		}
		function modifyComplete(obj,commentNo,noticeNo){
			var form = $("<form action='/noticeCommentUpdate' method='post'></form>");
			form.append($("<input type='text' name='noticeCommentNo' value='"+commentNo+"'>"));
			form.append($("<input type='text' name='noticeNo' value='"+noticeNo+"'>"));
			form.append($(obj).parent().prev());
			$("body").append(form);
			form.submit();
		}
		function deleteComment(obj,commentNo,noticeNo){
			if(confirm("댓글을 삭제하시겠습니까?")){
				location.href="/noticeCommentDelete?noticeCommentNo="+commentNo+"&noticeNo="+noticeNo;				
			}			
		}		
	</script>
</body>
</html>