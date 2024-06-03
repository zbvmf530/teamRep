<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
}

h1, h3 {
	text-align: center;
	color: #333;
	margin-top: 20px;
}

.product-detail {
	padding: 20px;
	max-width: 1200px;
	margin: 0 auto;
}

.card-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-around;
	gap: 20px;
}

.product-card {
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 8px;
	overflow: hidden;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 500px;
}

.list-group-item {
	border: none;
	padding: 10px 15px;
	text-align: center;
}

.product-img-fluid {
	max-width: 100%;
	height: auto;
	display: block;
	margin: 0 auto;
}

.product-details, .button-group, .review {
	margin-top: 20px;
}

.prod-option, .prod-price {
	font-size: 18px;
	margin-top: 10px;
	display: block;
	text-align: center;
}

.button-group {
	display: flex;
	justify-content: center;
	gap: 10px;
	margin-top: 20px;
}

.review {
	background-color: #f1f1f1;
	border-radius: 5px;
	padding: 10px;
	margin-top: 10px;
}

.review h3 {
	margin: 0;
	font-size: 20px;
}

.review p {
	margin: 5px 0;
	font-size: 16px;
}

.review dl {
	margin: 10px 0 0;
	text-align: left;
}

.review dt, .review dd {
	display: inline-block;
	margin: 0 5px;
}

.product-img-fluid {
	margin: 0 auto;
}

@media ( max-width : 768px) {
	.card-container {
		flex-direction: column;
		align-items: center;
	}
}
</style>

<input type="hidden" value="${code}" id="prodCode">
<div id="detailContainer" class="product-detail">
	<h1>상품상세페이지</h1>
	<h3 class="detailWrap"></h3>
	<div class="card-container col-xs-12">
		<div class="product-card m-b-20">

			<ul class="list-group list-group-flush">
				<li class="list-group-item"><img class="product-img-fluid"
					style="width:220px;
						   height:220px;
						   "
					src="/Ddosirak/productimages/${prodImage}" alt="Product Image" 
					></li>
			</ul>
			
		</div>
		<div class="product-card m-b-20">
			<li class="list-group-item"><h5>${name}</h5></li>

			<div class="product-details">
				<span class="prod-option">옵션 : <select id="productOption"
					name="productOption" onchange="updatePrice()">
						<c:forEach var="option" items="${optionList}">
							<option value="${option.optionCode}">${option.optionName}</option>
						</c:forEach>
				</select>
				</span><br> <span class="prod-price" id="productPrice">가격 : ${optionList[0].optionPrice}원</span>
			</div>
			<div class="button-group">
				<button type="button" class="btn btn-primary" id="wishBtn">위시리스트</button>
				<div class="modal" id="wishModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">알림</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
							</div>
							<div class="modal-body">위시리스트 추가완료!</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal" id="wishButton">확인</button>
							</div>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-primary" id="jangBtn">장바구니</button>
				<div class="modal" id="jangModal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">알림</h4>
								<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
							</div>
							<div class="modal-body">장바구니 추가완료!</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" id="jangButton"
									data-bs-dismiss="modal">확인</button>
							</div>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-secondary" id="baroBtn">
					<a href="checkout.do">바로구매</a>
				</button>

			</div>
		</div>
	</div>
	<hr />
	<hr />
	<div>
		<h3 class="detailWrap">상품설명..</h3>
	</div>
	<hr />
	<hr />
		<div>
			<h3 class="detailWrap">리뷰..</h3>
			<h4>리뷰 수 - ${reviewCnt} 평점평균 - ${gradeAvg}</h4>
			<c:forEach var="review" items="${reviews}">
				<div class="review">
					<h3>${review.reviewTitle}</h3>
					<p>${review.reviewContent}</p>
					<p>평점: ${review.grade}</p>
					<dl class="desc">
						<dt class="first">작성자</dt>
						<dd class="pr-list-writer">${review.memberId}</dd>
					</dl>
				</div>
			</c:forEach>
		</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="./js/updatePrice.js"></script>
<script src="./js/btn.js"></script>


