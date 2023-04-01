<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="review_DetailBox">
	<div class="reviewdetail_header">
		<h2>수강후기</h2>
	</div>
	<div class="reviewDetail_wrap">
		<div class="reviewDetailInfoBox">
			<div class="reviewDetail_TitleBox">
				<h3 class="detail_title">${niBoard.title}</h3>
			</div>
			<div class="reviewDetail_Info">
				<div>작성자: ${niBoard.username.name} |&nbsp;</div>
				<div>
					작성일:
					<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${niBoard.createTime}" />
					&nbsp;|&nbsp;
				</div>
				<div>조회수: ${niBoard.count}</div>
			</div>
		</div>

	</div>
</div>
<div>
	<div class="teacherInfoContent">
		<span class="teacherInfoDetail">${niBoard.content}&nbsp;</span><span></span>
	</div>
</div>
<div>
	<div class="teacherInfoContent">
		<span class="teacherInfoDetail">키워드&nbsp;</span>
	</div>

</div>
<div>
	<div class="teacherInfoContent">#빠른답변속도 #자세한답변 #친절한응대</div>
</div>

<%--      <div class="commuD_contentBigBox">${niBoard.content}
         <br>
         <c:choose>
            <c:when test="${niBoard.boardImg == null}">
               <div class="border border-2 img-fluid" style="display: none;">
                  <img src="/image/${niBoard.imgName}" alt="프로필 사진"
                     style="width: 100%; height: 100%; object-fit: cover;">
               </div>
            </c:when>
            <c:otherwise>
               <br>
               <div class="border border-2 img-fluid"
                  style="width: 300px; height: 300px; overflow: hidden; background-color: white;">
                  <c:set var="b_img" value="${niBoard.boardImg}"></c:set>
                  <%
                  String img = (String) pageContext.getAttribute("b_img");
                  String[] addStr = img.split("/");
                  for (String str : addStr) {
                     out.print("<img src='/upload/" + str + "'>");
                  }
                  %>
               </div>
            </c:otherwise>
         </c:choose>
      </div>
 --%>

<!-- 수정,삭제,목록 버튼 -->
<c:if test="${niBoard.username.id==principal.user.id}">
	<div class="reviewD_btnBox">
		<div class="review_listBtn">
			<i class="fa-regular fa-rectangle-list" onclick="location.href='/'"></i>
		</div>
		<div class="boardUpdateBtn">
			<button class="reviewD_modifyBtn2"
				onclick="location.href='/niBoard/${niBoard.id}/niBoardUpdateForm'">
				<i class="fa-solid fa-pen-to-square"></i>
			</button>
		</div>
		<div class="boardDeleteBtn">
			<button class="reviewD_deleteBtn2" id="boardDeleteBtn" type="button"
				value="${niBoard.id}">
				<i class="fa-solid fa-trash-can"></i>
			</button>
		</div>
	</div>
</c:if>
<!--댓글 입력 폼-->
<div class="replyBigBox">
	<input type="hidden" id="id" value="${niBoard.id}" />
	<div class="replyListTitle">COMMENT</div>

	<div class="replyBigBox2">
		<div class="replySmall1">
			<textarea class="replyWriteBox" placeholder="댓글을 남겨보세요."
				class="textarea" id="reply-content"></textarea>
		</div>
		<div class="replySmall2">
			<button class="reply_btn" id="btn-reply-save">등록</button>
		</div>

	</div>
	<!-- 댓글 반복 출력 -->
	<div class="replyListBox">
		<div class="replyListSmallBox">
			<c:forEach var="niReply" items="${niBoard.niReply}">
				<div class="replyListSmallBox2" id="reply_${niReply.id}">
					<div class="replyNameDateBtnBox">
						<div class="replyNameDateBox">
							<div class="replyName">${niBoard.username.name}</div>
							<div>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${niReply.createTime}" />
							</div>
						</div>
					</div>
					<div class="replyContentBox">
						<div class="replyContent">${niReply.content}</div>
					</div>

                    <input type="hidden" id="niReplyId" value="${niReply.id}">
					<button class="boardDetail_modifyButton" id="btn-reply-update">수정</button>
					<button class="boardDetail_cancel" id="btn-reply-cancel"
						style="display: none;">취소</button>
					<button
						onclick="board.reply_delete('${niBoard.id}','${niReply.id}')"
						id="btn-reply-delete">삭제</button>
					<div class="r_reply_edit" style="display: none;">
						<input type="hidden" value="${niReply.id}"> <input
							type="text" placeholder="수정" id="reply_edit">
						<button type="button" id="r_reply"
							class="btn btn-outline-primary bi bi-pencil-square">수정</button>
					</div>

				</div>
				<hr>
			</c:forEach>
		</div>
	</div>
</div>
<div class="MovePostsBigBox">
	<table class="MovePostsBox">
		<tr>
			<th class="beforePostBtn beforePostBtn3" id="MovePostBtn2">이전글</th>
			<c:choose>
				<c:when test="${niBoard_pre == '이전글이 없습니다.'}">
					<td class="nextPost beforePostBtn3">${niBoard_pre}</td>
				</c:when>
				<c:otherwise>
					<td class="nextPost beforePostBtn3"><a
						href="/niBoard/${niBoard.id-1}">${niBoard_pre.title}</a></td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th class="nextPostBtn nextPost3" id="MovePostBtn2">다음글</th>
			<c:choose>
				<c:when test="${niBoard_nxt == '다음글이 없습니다.'}">
					<td class="nextPost">${niBoard_nxt}</td>
				</c:when>
				<c:otherwise>
					<td class="nextPost"><a href="/niBoard/${niBoard.id+1}">${niBoard_nxt.title}</a></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>


</div>

<%@ include file="../layout/footer.jsp"%>