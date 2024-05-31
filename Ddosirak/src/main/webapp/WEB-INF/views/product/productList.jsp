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

h3 {
    text-align: center;
    color: #333;
    margin-top: 20px;
}

.product-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
    padding: 20px;
}

.product-card {
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 8px;
    overflow: hidden;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: calc(23% - 20px); /* 4 items per row with 20px gap */
    margin: 10px;
    box-sizing: border-box;
    text-align: center; /* Center align content */
}

.list-group-item {
    border: none;
    padding: 10px 15px;
}

.product-img-fluid {
    max-width: 100%;
    height: auto;
    display: block;
    margin: 0 auto;
}

.product-icon {
    width: 24px;
    height: 24px;
    margin: 0 5px;
}

.product-card-link {
    text-decoration: none;
    color: inherit;
}

.product-card-link img.product-icon {
    width: 30px;
    height: 30px;
}

@media (max-width: 1200px) {
    .product-card {
        width: calc(31% - 20px); /* 3 items per row */
    }
}

@media (max-width: 992px) {
    .product-card {
        width: calc(48% - 20px); /* 2 items per row */
    }
}

@media (max-width: 768px) {
    .product-list {
        flex-direction: column;
        align-items: center;
    }

    .product-card {
        width: 100%;
        max-width: 500px;
    }
}
</style>

<h3>상품목록페이지..</h3>
<div class="product-list">
    <c:forEach var="product" items="${productList}">
        <div class="product-card">
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <a href="productDetail.do?code=${product.productCode}" class="product-card-link">
                        <img class="product-img-fluid" src="/Ddosirak/productimages/${product.productImg}" alt="${product.productName}">
                    </a>
                </li>
                <li class="list-group-item">${product.productName}</li>
                <li class="list-group-item">
                    <a class="product-card-link" target="_blank" id="jangMiniBtn">
                        <img class="product-icon" src="https://www.goobnemall.com/design/goobne/wib/img/pc/icon_cartBg.svg" alt="Cart">
                    </a>
                    <a class="product-card-link" target="_blank" id="wishMiniBtn">
                        <img class="product-icon" src="https://www.goobnemall.com/design/goobne/wib/img/pc/icon_heartBg.svg" alt="Wishlist">
                    </a>
                </li>
                <li class="list-group-item">가격 : ${product.price}원</li>
            </ul>
        </div>
    </c:forEach>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="./js/btn.js"></script>
