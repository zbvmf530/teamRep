<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3>수정화면</h3>

<form action="updateBoard.do" method="post">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td>${bno.boardNo }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="boardTitle" value="${bno.boardTitle }"></td>
		</tr>
		<tr>
		
			<th>내용</th>
			<td><textarea name="boardContent" cols="30" rows="4">${bno.boardContent }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${bno.memberId }</td>
		<tr align="center">
			<td colspan="2">
<%-- 			<c:choose> --%>
<%-- 					<c:when test="${bno.memberId eq logId}"> --%>
						<button class="btn btn-primary" onclick="location.href='/updateBoard.do?${bno.boardNo}'">수정</button>
						<%-- 					</c:when> --%>
<%-- 					<c:otherwise> --%>
<!-- 						<input class="btn btn-primary" disabled type="submit" value="수정"> -->
<%-- 					</c:otherwise> --%>
<%-- 				</c:choose> --%>
				</td>
		</tr>

	</table>
	<input type="hidden" name="bno" value="${bno.boardNo }"> 
	<input type="hidden" name="category" value="${bno.category }"> 
	<input type="hidden" name="page" value="${page }">
    <input type="hidden" name="searchCondition" value="${searchCondition }">
	<input type="hidden" name="keyword" value="${keyword }">
</form>

