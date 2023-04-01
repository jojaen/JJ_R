<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="reviewSaveBox">
	<div class="reviewSaveSmallBox">

		<form>
			<div class="noticeTitleBox">
				<input type="hidden" id="id" value="${niBoard.id}" /> 
				<input name="title" type="text" value="${niBoard.title}"
					class="boardTitleSave" id="title">
			</div>
			<div class="noticeTitleBox">
				<input type="text" id="username" value="${niBoard.username.name}"
					readonly>
			</div>
			<div class="noticewriterBox">
				<textarea name="content" class="boardSaveTextarea" rows="24"
					id="content">${niBoard.content}</textarea>
			</div>
			<div id="fileBigbox">
				<div id="att_zone"></div>
				<div id="att_zone2">
					<span class="upload-name">"+" 버튼을 눌러 사진을 추가하세요.</span> <label
						for="btnAtt">+</label> <input type="file" id="btnAtt"
						class="files" name="uploadFile" multiple="multiple" />
				</div>
				<div class="notice_saveBtnBox">
					<input type="button" value="수정하기" id="boardUpdateBtn"
						class="boardSaveBtn">
				</div>
			</div>
		</form>
	</div>
</div>

<%@ include file="../layout/footer.jsp"%>
