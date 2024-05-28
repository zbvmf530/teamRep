<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
div.reply div {
	margin: auto;
}

div.reply ul {
	list-style-type: none;
	margin: 5px;
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
}
</style>

<link href="css/paging.css" rel="stylesheet" />


<h2>상세화면</h2>


<c:choose>
	<c:when test="${empty result }">
		<p>조회된 결과가 없습니다</p>
		
	</c:when>
	<c:otherwise>
		<form name="myFrm">
			<input type="hidden" name="bno" value="${result.boardNo }">
			<input type="hidden" name="category" value="${result.category }">
			<input type="hidden" name="page" value="${page }">
			<input type="hidden" name="searchCondition" value="${searchCondition }">
			<input type="hidden" name="keyword" value="${keyword }">
	
		<table class="table">
			<tr>
				<th>제목</th>
				<th>${result.boardTitle }</th>
			</tr>
		
			<tr>
				<th>작성자</th>
				<th>${result.memberId }</th>
				<th>작성일자</th>
				<td><fmt:formatDate value ="${result.boardDate }" pattern="yyyy-MM-dd" /></td>
				<th>조회수</th>
				<th>${result.boardViews }</th>
			
			</tr>
			<tr>
				<th>내용</th>
				<td>${result.boardContent }</td>
			</tr>
			<tr align="center">
				<td colspan="4">
				<button class="btn btn-danger" id="delBtn">삭제</button>
				<button class="btn btn-primary" id="modBtn">수정</button>
				</td>
			</tr>
		</table>
			</form>
	</c:otherwise>
</c:choose>

<!-- 댓글목록 -->
<div class = "container reply">
<div class = "header">

</div>
	<div class = "content">
		<ul>
			<li style ="display : none;">
				<span class = "col-sm-2">2</span>
				<span class = "col-sm-2">3</span>
				<span class = "col-sm-2">user02</span>
				<span class = "col-sm-1"><button onclick="updateRow(event)" class = "btn btn-warning">수정</button></span>
				<span class = "col-sm-1"><button onclick="deleteRow(event)" class = "btn btn-warning">삭제</button></span>
			</li>
		
		</ul>
	<form>
	<p>댓글달기</p>
	<input class = "col-sm-8" id="reply">
	<button class = "col-sm-1" id = "addReply">확인</button>
</form>
	</div> <!-- content -->
	
</div> <!-- container -->

<script>
	const bno = '${result.boardNo }';
// 	const writer = '${logId }';
</script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src = "js/replyService.js"></script>
<script src = "js/board.js"></script>

