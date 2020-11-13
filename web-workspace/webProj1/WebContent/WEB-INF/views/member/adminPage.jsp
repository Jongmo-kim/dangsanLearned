<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    	String searchWord = (String)request.getAttribute("searchWord");
    	boolean isWordNull = (searchWord!=null);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
	<style>
		select.form-control,input.form-control{
			display: inline-block;
			width: 200px;
			height: 30px;
			font-size: 0.8em;
		}
	</style>
	<section>
		<div style="margin: 0 auto; width:80%;margin-top:100px;">
			<form action="/searchKeyword">
				<select name="type" class="form-control">
					<option value="memberId">아이디</option>
					<option value="memberName>">이름</option>
				</select>
				
				<input type="text" class="form-control" name="keyword" value="<%= isWordNull?searchWord:""%>">
				<button type="submit" class="btn btn-outline-secondary btn-sm">검색</button>
			</form>
		</div>
	</section>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<section>
		<table class="table table-hover" style="width:80%; margin: 0 auto; text-align:center;">
			<tr>
				<th>선택</th>
				<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일</th>				
				<th>등급</th>
				<th>등급변경</th>				
				
			</tr>		
			<%for(Member member : list){%>
			<%if(member.getMemberNo() != m.getMemberNo()) {%>
			<tr>
				<td><input type="checkbox" class="chk"></td>
				<td><%=member.getMemberNo() %></td>
				<td><%=member.getMemberId() %></td>
				<td><%=member.getMemberName() %></td>
				<td><%=member.getPhone() %></td>
				<td><%=member.getAddress() %></td>
				<td><%=member.getEnrollDate() %></td>
				<td>
				
					<select>
					<%if(member.getMemberLevel()==1){ %>
						<option value="1" selected>관리자</option>
						<option value="2">정회원</option>
						<option value="3">준회원</option>
					<%} else if (member.getMemberLevel()==2) {%>
					<option value="1">관리자</option>
						<option value="2" selected>정회원</option>
						<option value="3">준회원</option>
					<%} else if (member.getMemberLevel()==3) { %>
						<option value="1">관리자</option>
						<option value="2">정회원</option>
						<option value="3" selected>준회원</option>
						<%} %>
					</select>
				</td>
				
				<td>
				<button class="btn btn-outline-info btn-sm changeBtn" >변경</button>
				</td>
			</tr>
			
			<%} }%>
			<tr>
				<th colspan="9">
					<button type="button" class="changeAllBtn btn btn-info btn-lg">전체 선택</button>
				</th>
			</tr>
		</table>
	</section>
	<script>
		$(".changeBtn").click(function(){
			var memberLevel = $(this).parent().prev().children().val();
			alert(memberLevel);
			var memberNo = $(this).parent().parent().children(":first-child").next().html();
			alert(memberNo);
			location.href="/changeLevel?memberNo="+memberNo+"&memberLevel="+memberLevel;
			
		});
		$(".changeAllBtn").click(function(){
			var inputs = $("[type=checkbox]:checked");
			var num = new Array();
			var level = new Array();
			inputs.each(function(idx,item){
				num.push($(item).parent().next().html());
				level.push($(item).parent().parent().find("select").val());
			});
			location.href="/changeAllLevel?num="+num.join("/")+"&level="+level.join("/");

		});
		
	</script>
</body>
</html>