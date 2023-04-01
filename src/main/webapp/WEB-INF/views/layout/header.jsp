<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>header</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	
<script src="https://kit.fontawesome.com/983b1b1bfd.js"
	crossorigin="anonymous"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Dongle&family=Gugi&family=Nanum+Pen+Script&family=Yeon+Sung&display=swap"
	rel="stylesheet">

<!-- 해더 푸터 메인 스타일 -->
<link rel="stylesheet" href="/css/header.css">
<link rel="stylesheet" href="/css/footer.css">
<link rel="stylesheet" href="/css/index.css">


<!-- 로그인 회원가입 스타일 -->
<link rel="stylesheet" href="/css/loginForm.css">
<link rel="stylesheet" href="css/joinForm.css">

<!-- 리뷰 스타일 -->
<link rel="stylesheet" href="/css/niBoardDetail.css">
<link rel="stylesheet" href="/css/niBoardList.css">
<link rel="stylesheet" href="/css/niBoardSaveOrUpdateForm.css">


<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>

</head>
<body>
	<header class="header">
		<nav class="exam_navbar">

			<div class="navbar_logo">
				<a href="/">NICP.P</a>
			</div>

			<ul class="navbar_menu">
				<li id="dropdown" class="menuhover"><a href="#" id="dropbtn"
					class="menu_a">게시판</a></li>
				<li id="dropdown2" class="menuhover"><a href="#" id="dropbtn2"
					class="menu_a">게시판</a></li>
				<li class="content">
					<ul class="content_li">
						<li><a href="/questionMain" class="menu_a">게시판</a></li>
					</ul>
				</li>
			</ul>

			<ul class="navbar_login">
				<c:choose>
					<c:when test="${empty principal}">
						<li><a href="/auth/loginForm">로그인</a></li>
						<li><a href="/auth/joinForm">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/logout" class="">로그아웃</a></li>
						<li><a href="/auth/userUpdateForm" class="">마이페이지</a></li>
					</c:otherwise>
				</c:choose>
			</ul>

			<a href="#" class="navbar_toggleBtn"><i class="fa-solid fa-bars"></i></a>
		</nav>
		<ul id="content_li2">
			<li class="content_li2_hover"><a href="/">게시판</a></li>
			<li class="nav-item"><a href="/auth/room" class="nav-link">Chat</a></li>
		</ul>
	</header>