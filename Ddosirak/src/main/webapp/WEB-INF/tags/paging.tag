<%@ tag body-content="empty" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="pageInfo" type="com.dosirak.common.PageDTO"
	required="true"%>

<div class="centers">
	<div class="pagination">
		<c:choose>
			<c:when test="${boardType =='N'}">
				<c:if test="${pageInfo.prev }">
					<!-- 이전페이지 여부 -->
					<a
						href="boardList.do?boardType=N&searchCondition=${searchCondition }&keyword=${keyword }&page=${pageInfo.startPage-1 }">&laquo;</a>
				</c:if>
				<c:forEach var="p" begin="${pageInfo.startPage }"
					end="${pageInfo.endPage }">
					<a
						href="boardList.do?boardType=N&searchCondition=${searchCondition }&keyword=${keyword }&page=${p }"
						class="${p == pageInfo.page ? 'active' :'' }">${p }</a>
				</c:forEach>
				<c:if test="${pageInfo.next }">
					<!-- 이후페이지 여부 -->
					<a
						href="boardList.do?boardType=N&searchCondition=${searchCondition }&keyword=${keyword }&page=${pageInfo.endPage+1 }">&raquo;</a>
				</c:if>
			</c:when>

			<c:otherwise>
				<c:if test="${pageInfo.prev }">
					<!-- 이전페이지 여부 -->
					<a
						href="boardList.do?boardType=Q&searchCondition=${searchCondition }&keyword=${keyword }&page=${pageInfo.startPage-1 }">&laquo;</a>
				</c:if>
				<c:forEach var="p" begin="${pageInfo.startPage }"
					end="${pageInfo.endPage }">
					<a
						href="boardList.do?boardType=Q&searchCondition=${searchCondition }&keyword=${keyword }&page=${p }"
						class="${p == pageInfo.page ? 'active' :'' }">${p }</a>
				</c:forEach>
				<c:if test="${pageInfo.next }">
					<!-- 이후페이지 여부 -->
					<a
						href="boardList.do?boardType=Q&searchCondition=${searchCondition }&keyword=${keyword }&page=${pageInfo.endPage+1 }">&raquo;</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</div>
