<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>


<p>${prodName }</p>
<script type="text/javascript">
         var optionPrices = { 
            <c:forEach var="entry" items="${prodPrice}">
                '${entry.key}': ${entry.value}<c:if test="${!entry.last}">,</c:if>
            </c:forEach>
        };

        function updatePrice() {
            var selectedOption = document.getElementById("productOption").value;
            var price = optionPrices[selectedOption];
            document.getElementById("productPrice").innerText = price + "원";
        }
    </script>

<h3>상품상세페이지</h3>
<div class="card-container col-xs-12">
	<div class="card m-b-20">
		<ul class="list-group list-group-flush">
			<li class="list-group-item">상품명 : ${name }</li>
			<li class="list-group-item"><img class="img-fluid"
				src="./image/${prodImage}" alt="Product Image"></li>
		</ul>
	</div>
	<div class="card m-b-20">
		<div class="product-details">
			<span class="prod-option">옵션 <select id="productOption"
				name="productOption" onchange="updatePrice()">
					<!-- 옵션 선택 시 updatePrice 함수 호출 -->
					<c:forEach var="option" items="${optionList}">
						<option value="${option}">${option}</option>
					</c:forEach>
			</select>
			</span><br> <span class="prod-price" id="productPrice">
				${optionPrices.entrySet().iterator().next().value}원 </span>
			<!-- 기본 가격 표시 -->
		</div>
		<div class="button-group">
			<button type="button" class="btn btn-primary">위시리스트</button>
			<button type="button" class="btn btn-primary">장바구니</button>
			<button type="button" class="btn btn-secondary">바로구매</button>
		</div>
	</div>
</div>
	<hr />
	<hr />
<div>
	<h3>상품설명..</h3>
	
</div>
	<hr />
	<hr />
<div>
	<h3>리뷰..</h3>
	<h4>주문 수 - ${reviewCnt} 평점평균 - ${gradeAvg}</h4>
	<c:forEach var="review" items="${reviews}">
		<div class="review">
			<h3>${review.reviewTitle}</h3>
			<p>${review.reviewContent}</p>
			<p>평점: ${review.grade}</p>
		</div>
	</c:forEach>


</div>
