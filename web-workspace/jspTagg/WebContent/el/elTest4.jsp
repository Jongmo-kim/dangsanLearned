<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 연산자</h1>
	<hr>
	<table border=1>
		<tr>
			<th>표현식</th><th>값</th>
		</tr>
		<tr>
			<td>\${2+5 }</td><td>${2+5 }</td>
		</tr>
		<tr>
			<td>\${4/5 }</td><td>${4/5 }</td>
		</tr>
		<tr>
			<td>\${4 div 5 }</td><td>${4 div 5 }</td>
		</tr>
		<tr>
			<td>\${4/5 }</td><td>${4/5 }</td>
		</tr>
		<tr>
			<td>\${4<5 }</td><td>${4<5 }</td>
		</tr>
		<tr>
			<td>\${4 gt 5 }</td><td>${4 gt 5 }</td>
		</tr>
		<tr>
			<td>\${4 lt 5 }</td><td>${4 lt 5 }</td>
		</tr>
		<tr>
			<td>\${4 lt 5 }</td><td>${4 gt 5 }</td>
		</tr>
		<tr>
			<td>\${4/5 }</td><td>${4/5 }</td>
		</tr>
	</table>	
</body>
</html>