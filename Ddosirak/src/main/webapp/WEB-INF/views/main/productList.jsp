<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<h3>상품목록페이지..</h3>
<c:forEach var="product" items="${productList }">

	<ul class="list-group list-group-flush">
		<li class="list-group-item"><a
			href="productDetail.do?code=${product.productCode }"
			class="card-link" > <img class="img-fluid"
			src="/BoardWeb/image/${product.productImg }">
		</a></li>
		<li class="list-group-item">${product.productName }</li>
		<li class="list-group-item"><a
			href="https://www.goobnemall.com/shop/shopbrand.html?type=M&amp;xcode=003&amp;mcode=001"
			class="card-link" target="_blank"> <img class="img-fluid"
				src="https://www.goobnemall.com/design/goobne/wib/img/pc/icon_cartBg.svg">
		</a> <a
			href="https://www.goobnemall.com/shop/shopbrand.html?type=M&amp;xcode=003&amp;mcode=001"
			class="card-link" target="_blank"> <img class="img-fluid"
				src="https://www.goobnemall.com/design/goobne/wib/img/pc/icon_heartBg.svg">
		</a></li>
		<li class="list-group-item">가격 : ${product.price }</li>
	</ul>

</c:forEach>
