<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

	<div class="loginFormBox">
    <div class="loginChoice">
      <div class="SignUpBtn2">
        <div class="smallbtnbox">
          <a href="/auth/joinForm" class="aSign2" id="aSign2">Sign Up</a>
        </div>
      </div>
      <div class="LoginBtn2">
        <div class="smallbtnbox">
          <a href="/auth/loginForm" class="aLogin2" id="aLogin2">Login</a>
        </div>
      </div>
    </div>
    <div class="loginStyleBox">
      <div class="loginImgBox">
        <img class="loginFormImg" src="/image/loginFormImg.jpg">
      </div>
      <form action="/auth/loginProc" method="POST" name="login" id="loginForm">
        <div class="bBox2">
          <input type="text" id="username" name="username" class="userid" placeholder="아이디" autofocus="autofocus">
        </div>
        <div class="bBox2">
          <input type="password" id="password" name="password" class="userpwd" placeholder="비밀번호">
        </div>
        <div class="bBox3">
          <div class="logintpye">
            <input type="checkbox" name="remember"> 로그인상태유지
          </div>
          <div class="findInfo">
          	<button type='button' id="modal_btn">아이디 찾기</button>
          	<span>|&nbsp;</span>
            <button type='button' id="modal_btn2">비밀번호 찾기</button>
          </div>
        </div>
        <div class="bBox2">
          <button type="submit" id="login-btn" name="userLogin">Login</button><br>
          <a href="/auth/joinForm" id="join-btn">Sign Up</a>
        </div>
      </form>
    </div>
  </div>
    
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>