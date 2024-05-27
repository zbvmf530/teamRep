<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- <c:if test="${meassage != null}"> --%>
<%-- 	<p>${message }</p> --%>
<%-- </c:if> --%>

<form action="addBoard.do" method="post" enctype="multipart/form-data">
	<p> 선택 </p>
		
			<select name="selectCategory" class="form-control">
				<option value="T" ${selectCategory == '상품문의' ? 'selected' : ''}>상품문의</option>
				<option value="W" ${selectCategory == '결제' ? 'selected' : ''}>결제</option>
				<option value="W" ${selectCategory == '배송' ? 'selected' : ''}>배송</option>
				<option value="TW" ${selectCategory == '교환/반품' ? 'selected' : ''}>교환/반품</option>
			</select>

	
	<table class="table">
		
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




