<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my"%>


<style>
.centers {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #FF6F61;
	color: white;
	border: 1px solid #FF6F61;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

h3 {
	text-align: center;
}

button {
	background-color: #ff6f61;
	border-color: #ff6f61;
	color: #fff;
	display: inline-block;
	font-size: 1rem;
	font-weight: 500;
	line-height: 1.5rem;
	padding: .875rem 1.75rem;
	text-align: center;
	transition: color .15s ease-in-out, background-color .15s ease-in-out,
		border-color .15s ease-in-out, box-shadow .15s ease-in-out;
		    height: calc(3.25rem + 2px);
    white-space: nowrap;
		
}
</style>
<c:choose>
	<c:when test="${boardType =='N'}">
		<h3>NOTICE</h3>
	</c:when>
	<c:otherwise>
		<h3>Q&A</h3>
	</c:otherwise>
</c:choose>


<div class="row">
	<!-- 글번호, 제목, 작성자, 작성일시, 조회수 -->
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<c:choose>
						<c:when test="${boardType =='Q'}">
				<th>답변여부</th>
				</c:when>
				</c:choose>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boardList }">

				<tr>
					<td>${board.boardNo }</td>
					<td>${board.category }</td>
					<c:choose>
						<c:when test="${boardType =='N'}">
							<td><a
								href="boardInfo.do?boardType=N&bno=${board.boardNo }&page=${paging.page }&kerword=${keyword }&searchCondition=${searchCondition}">${board.boardTitle }</a></td>
						</c:when>
						<c:otherwise>
							<td><a
								href="boardInfo.do?boardType=Q&bno=${board.boardNo }&page=${paging.page }&kerword=${keyword }&searchCondition=${searchCondition}">${board.boardTitle }</a></td>
						</c:otherwise>
					</c:choose>


					<td>${board.memberId }</td>
					<td><fmt:formatDate value="${board.boardDate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${board.boardViews }</td>
					<c:choose>
						<c:when test="${boardType =='Q'}">
						<td><c:choose>
							<c:when test="${board.replyCnt != 0 }">
								<p>답변완료</p>
							</c:when>
							<c:otherwise>
								<p>답변대기</p>
							</c:otherwise>
						</c:choose></td>
						</c:when>
						</c:choose>
				</tr>


			</c:forEach>
		</tbody>
	</table>
</div>

<my:paging pageInfo="${paging }"></my:paging>
<c:choose>
	
	<c:when test="${boardType eq 'N'and( auth == 'user' or logId == 'none')}">

	</c:when>
	<c:otherwise>
	<div class="row">
	<button class="col-sm-2" id="addBtn">글쓰기</button>
</div>
	</c:otherwise>
</c:choose>

<div class="row">
	<form action="boardList.do">
		<input type="hidden" name="boardType" value="${boardType }">
		<div class="row">
			<div class="col-sm-3">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${searchCondition=='T' ? 'selected' : '' }>제목</option>
					<option value="W" ${searchCondition=='W' ? 'selected' : '' }>작성자</option>
					<option value="TW" ${searchCondition=='TW' ? 'selected' : '' }>제목
						& 작성자</option>
				</select>
			</div>
			<div class="col-sm-6">
				<input type="text" name="keyword" value="${keyword }"
					class="form-control">

			</div>

			<div class="col-sm-3">
			<button class="btn btn-danger" id="SearchBtn">검색</button>
			</div>
		</div>
	</form>
	</div>
	<script>
	
	const writer = '${logId }';
</script>
	<script src="js/board.js"></script>