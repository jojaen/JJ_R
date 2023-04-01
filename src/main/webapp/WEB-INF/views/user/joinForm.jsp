<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="joinFormBox">
	<div class="joinChoice">
		<div class="SignUpBtn">
			<div class="smallbtnbox2">
				<a href="/auth/joinForm" class="aSign" id="aSign">Sign Up</a>
			</div>
		</div>
		<div class="LoginBtn">
			<div class="smallbtnbox2">
				<a href="/auth/loginForm" class="aLogin" id="aLogin">Login</a>
			</div>
		</div>
	</div>
	<div class="JoinBigBox">
		<form novalidate action="" name="sentMessage" name="frm" id="joinForm"
			method="post">

			<label class="styleBox" for="userid">아이디</label><Br>
			<div class="bBox">
				<input type="text" name="userid" id="userid" class="idCheck"
					placeholder="Your id" autofocus="autofocus">
			</div>

			<label class="styleBox" for="userpwd">비밀번호</label><Br>
			<div class="bBox">
				<input type="password" name="userpwd" id="userpwd" class="pwdCheck"
					placeholder="Your password" >
			</div>

			<label class="styleBox" for="userpwdChk">비밀번호 재확인</label><Br>
			<div class="bBox">
				<input type="password" name="userpwdChk" id="userpwdChk"
					class="pwdCheck" placeholder="Your password" >
			</div>

			<label class="styleBox" for="username">이름</label><Br>
			<div class="bBox">
				<input type="text" name="username" id="username" class="nameCheck"
					placeholder="Your Name" >
				<div class="nameCheck1">10글자 이하로 입력해주세요.(숫자와 특수문자를 사용할 수
					없습니다.)</div>
				<div class="nameCheck2">이름을 입력해 주세요.</div>
			</div>
		</form>
		<div class="joinBtnBox">
			<input type="button" id="joinBtn" value="Sign Up" class="signUpBtn"></input>
		</div>
	</div>
</div>
<script	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<%@ include file="../layout/footer.jsp"%>