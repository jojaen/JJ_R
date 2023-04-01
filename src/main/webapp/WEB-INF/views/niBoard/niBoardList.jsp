<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>

<div class="Comm_Box">

   <!-- 글목록 보기 -->
   <div class="reviewList">
   
       <div class="reviewBtnBox">
         <a href="/niBoard/niBoardSaveForm" class="reviewBtn">글쓰기</a>
      </div>

      <div class="reviewInfoTitleBox">
         <table class="reviewInfoTitle">
            <tr>
               <td class="reviewNum">NO</td>
               <td class="reTitle">제목</td>
               <td class="reWriterName">작성자</td>
               <td class="reviewDate">등록일</td>
               <td class="reviewCount">조회수</td>
            </tr>
         </table>
      </div>


     
         <c:forEach var="board" items="${niBoard.content}">
          <table class="reviewInfoDetail">
            <tr class="reviewInfoDetail_tr">
               <td class="reviewNum"><a href="/niBoard/${board.id}"
                  class="btn btn-primary">${board.id}</a></td>
               <td class="reTitle"><a href="/niBoard/${board.id}" class="rboard_title">${board.title}</a>
               </td>
               <td class="reWriterName">${board.username.name}</td>
               <td class="reviewDate"><fmt:formatDate value="${board.createTime}" pattern="yyyy-MM-dd" /></td>
               <td class="reviewCount">${board.count}</td>
               
            </tr>
                  </table>
         </c:forEach>
         
         
           <div class="col-8 justify-content-center">
      	<ul class="pagination justify-content-center">
			<c:choose>
				<c:when test="${niBoard.first}">
					<li class="page-item disabled"><a class="page-link" href="?page=${niBoard.number-1}" style="display: none;">이전</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${niBoard.number-1}"><i class="fa-solid fa-angles-left"></i></a></li>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${startBlockPage}" end="${endBlockPage}">
				<c:choose>
					<c:when test="${niBoard.pageable.pageNumber+1==i}">
						<li class="page-item"><a class="page-link2" id="pageable_box" href="?page=${i-1}">${i}</a>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link2" href="?page=${i-1}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${niBoard.last}">
					<li class="page-item disabled"><a class="page-link" href="?page=${niBoard.number+1}" style="display: none;">다음</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${niBoard.number+1}"><i class="fa-solid fa-angles-right"></i></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
      </div>



   </div>
</div>
<%@ include file="../layout/footer.jsp"%>