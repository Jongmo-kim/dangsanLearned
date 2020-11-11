<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 경로에서 / 는 webcontent를 의미 -->
<script type="text/javascript" src="/js/jquery-3.3.1.js">
	
</script>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/header/style.css">
<link rel="stylesheet" href="/css/header/responsive.css">
<script type="text/javascript" src="/js/bootstrap.js"></script>
<header class="header_area">
	<div class="main_menu">
		<nav class="navbar navbar-expand-lg navbar-light">
			<div class="container">
				<a class="navbar-brand logo_h" href="/">
					<img src="/img/logo.png" width="165" height="80">
				</a>
			<button class="navbar-toggler"  type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
				<ul class="nav navbar-nav menu_nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">MENU1</a>
					<li class="nav-item"><a class="nav-link" href="#">MENU2</a>
					<li class="nav-item"><a class="nav-link" href="#">MENU3</a>
					<li class="nav-item"><a class="nav-link" href="#">MENU4</a>
					<li class="nav-item"><a class="nav-link" href="#">MENU5</a>
				</ul>
			</div>
			</div>
			<div class="right-button">
				<ul>
					<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/login.jsp'">로그인</button></li>
					<li class="nav-item"><button class="btn btn-danger" onclick="location.href='/views/member/join.jsp'">회원가입</button></li>
				</ul>
			</div>
		</nav>
	</div>
</header>