<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- <c:if test="${meassage != null}"> --%>
<%-- 	<p>${message }</p> --%>
<%-- </c:if> --%>

<form action="addBoard.do" method="post">

	<table class="table">
<!-- 		<tr> -->
<!-- 			<th>작성자</th> -->
<%-- 			<td><input type="hidden" name="memberId" readonly value="${memberId }"></td> --%>
<!-- 		</tr> -->
	<tr>
			<th>카테고리</th>
		<td><input type="hidden" name="selectCategory" readonly value="공지사항">공지사항</td>
		</tr>


		<tr>
			<th>제목</th>
			<td><input type="text" name="boardTitle"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="boardContent"></textarea></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="myImg"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"></td>
			</tr>
	</table>
	</form>






