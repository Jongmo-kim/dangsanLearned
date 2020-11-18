<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/photoWriteFrm.jsp</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<div class="table-wrapper" style="text-align: center; width:80%; margin: 0 auto;">
		<form action="/insertPhoto" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<th colspan="2">사진 게시판 작성</th>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
						<%=m.getMemberId() %>
						<input type="hidden"name="photoWriter" value="<%=m.getMemberId() %>">
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="filename" onchange="loadImg(this)">
					</td>
				</tr>
				<tr>
					<th>이미지보기</th>
					<td>
						<div id="img-viewer">
							<img id="img-view" width="350">
						</div>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="3" name="photoContent" class="form-control"></textarea>
					</td>
				</tr>
				<tr style="text-align:center">
					<th colspan="2"><button type="submit" class="btn btn-outline-info">등록하기</button>
					</th>
				</tr>
			</table>		
		</form>
	</section>
	<script>
		function loadImg(f){
			//배열의 길이가 0 인지 확인
			//배열에 담겨있는 파일의 크기가 0 인지 확인
			if(f.files.length != 0 && f.files[0]!=0){
				var reader = new FileReader(); //JS파일리더객체 -> 파일정보 확인가능
				//현재 사용자가 선택한 파일의 경로를 읽어옴
				reader.readAsDataURL(f.files[0]);
				//파일 경로를 읽어오는 작업이 완료되면
				reader.onload=function(e){
					$("#img-view").attr('src',e.target.result); //파일경로를 src속성에 설정
				}
			}else{
				$("#img-view").attr("src","");
			}
		}
	</script>
</body>
</html>