<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags"  prefix="my"%> 


<style>
.center {
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
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<h3>문의하기</h3>


<div class = "row">
<!-- 글번호, 제목, 작성자, 작성일시, 조회수 -->
<table class = "table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>카테고리</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>답변여부</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="board" items="${boardList }">
		<c:choose>
				<c:when test="${board.category ne '공지사항'}">
		<tr>
			<td>${board.boardNo }</td>
			<td>${board.category }</td>
			<td><a href = "boardInfo.do?bno=${board.boardNo }&page=${paging.page }&kerword=${keyword }
			&searchCondition=${searchCondition}">${board.boardTitle }</a></td>
			<td>${board.memberId }</td>
			<td><fmt:formatDate value ="${board.boardDate }" pattern="yyyy-MM-dd" /></td>
			<td>${board.boardViews }</td>
			<td>
			<c:choose>
			<c:when test="${board.replyCnt != 0 }">
			<p>답변완료</p>
			</c:when>
			<c:otherwise>
			<p>답변대기</p>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
			</c:when>
			</c:choose>
	</c:forEach>
	</tbody>
</table>
</div>
<my:paging pageInfo="${paging }"></my:paging>
<div class = "row"><button class = "col-sm-3" id = "addBoard" onclick ="location.href='addBoard.do'">글쓰기</button></div>
	
<div class="row">
	<form action="boardList.do">
		<div class="row">
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${searchCondition == 'T' ? 'selected' : ''}>제목</option>
					<option value="W" ${searchCondition == 'W' ? 'selected' : ''}>작성자</option>
					<option value="TW" ${searchCondition == 'TW' ? 'selected' : ''}>제목 & 작성자</option>
				</select>
			</div>
			<div class="col-sm-6">
				<input type="text" name="keyword" value="${keyword }" class="form-control">

			</div>

			<div class="col-sm-2">
				<input type="submit" value="찾기" class="btn btn-primary">
			</div>
		</div>
	</form>


</div>
    <script>
	const totalList = JSON.parse('${json}');
	const logid = '${logId}';
	const auth = '${auth}';
</script>




