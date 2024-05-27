<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form name="myFrm" action="deleteBoard.do">
<!-- 	<script>삭제하시겠습니까?</script> -->
	<h2>삭제할래?</h2>
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

	</table>
	<button type="submit" class="btn btn-danger">확인</button>
	<input type="hidden" name="bno" value="${bno.boardNo }"> 
	
</form>
<!-- <script> -->
<%-- //const logid = "${logId }"; --%>
<%-- // const writer = "${bno.writer }"; --%>

<!-- //document.forms.myFrm.addEventListener('submit',function(e){ -->
	
<!-- //	e.preventDefault(); -->
<!-- // 	if(logid != writer){ -->
<!-- // 		alert("권한이 없습니다"); -->
<!-- 		return; -->
<!-- 		 this.submit(); -->
	
<!-- }); -->

<!-- </script> -->
