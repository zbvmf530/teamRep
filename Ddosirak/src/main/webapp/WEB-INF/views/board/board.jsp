<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

</style>






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
			<input type="hidden" name="replyCnt" value="${result.replyCnt }">
		</form>
		<table class="table">
			<tr>
				<th>제목</th>
				<th>${result.boardTitle }</th>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				
			</tr>
			<tr>
				<th>작성자</th>
				<th>${result.memberId }</th>
				<th>작성일자</th>
				<td><fmt:formatDate value="${result.boardDate }"
							pattern="yyyy-MM-dd" /></td>
				<th>조회수</th>
				<th>${result.boardViews }</th>
			</tr>
			<tr>
				<th>내용</th>
				<td>${result.boardContent }</td>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<tr align="center">

				<c:choose>
					<c:when test="${not empty result.boardImg }">
						<td  colspan="8"><img src="./imgs/${result.boardImg }" width="800" height="1000"></td> 
					</c:when>
					<c:otherwise>
						<!-- 이미지가 없을때 실행 -->
					</c:otherwise>
				</c:choose>
			</tr>	
			
			<tr align="center">
				<td colspan="8">
					<button class="btn btn-danger" id="delBtn">삭제</button>
					<button class="btn btn-primary" id="modBtn">수정</button>
				</td>
			</tr>
		</table>
	
	</c:otherwise>
</c:choose>

<!-- 댓글목록 -->

<div class="container reply">
	<div class="content">
		<ul>
			<li style="display: none;">
				<span class="col-sm-1">아이디</span>
			 	<span class="col-sm-4">날짜</span> 
			 	<span class="col-sm-4">내용</span>
			 	<div id='update'>
			 	<input class="col-sm-8" id="reply">
			 	</div>
			 	<span class="col-sm-1"><button onclick="updateRow(event)" class="btn btn-warning">수정</button></span> 
			 	<span class="col-sm-1"><button onclick="deleteRow(event)" class="btn btn-warning">삭제</button></span>
			</li>
		</ul>
	</div>
	<!-- content -->
	
			<p>댓글달기</p>
			<input class="col-sm-8" id="reply">
			<button class="col-sm-1" id="addReply">확인</button>
		
	</div>

<!-- container -->




<script>
	const bno = '${result.boardNo }';
	const writer = '${logId }';
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="js/replyService.js"></script>
<script src="js/board.js"></script>

