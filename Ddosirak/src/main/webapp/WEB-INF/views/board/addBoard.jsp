<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:if test="${message != null}">
	<p>${message }</p>
</c:if>


<form action="addBoard.do" method="post" enctype="multipart/form-data">

	
<table class="table">
<c:choose>
<c:when test="${auth == 'user'}">
	<tr>
		<td>카테고리</td>
		<td><select name="selectCategory" class="form-control">

					<option value="상품문의" ${selectCategory == '상품문의' ? 'selected' : ''}>상품문의</option>
					<option value="결제문의" ${selectCategory == '결제문의' ? 'selected' : ''}>결제문의</option>
					<option value="배송문의" ${selectCategory == '배송문의' ? 'selected' : ''}>배송문의</option>
					<option value="교환/반품문의"
						${selectCategory == '교환/반품문의' ? 'selected' : ''}>교환/반품문의</option>
			</select></td>
	</tr>
	
	<tr>
		<td>상품선택</td>
		<c:forEach var="board" items="${boardList }">
		<td>
		<select name="selectProduct" class="form-control">
		<option value="${board.productCode }">dddd</option>
		
	
		</select><td>
		</c:forEach>
		
		</c:when>
	</c:choose>
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






