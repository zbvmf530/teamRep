<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<tr>
<h3>게시글목록</h3>
<table class = "table">
<thead>
<tr>
<th>글번호</th>
<th>상품정보</th>
<th>카테고리</th>
<th>제목</th>
<th>작성자</th>
<th>작성일</th>
<th>조회</th>
</tr>
<tbody>
<c:forEach var="board" items="${boardList }">
<tr>
	<td>${board.boardNo }</td>
	<td>${board.boardNo }</td>
	<td>${board.category }</td>
	<td>${board.title }</td>
	<td>${board.writer }</td>
	<td>${board.date }</td>
	<td>${board.boardCnt }</td>

	</tr>
</c:forEach>
</tbody>
</table>