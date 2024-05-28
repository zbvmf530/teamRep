<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page import="java.util.List"%>
<%@page import="java.util.Map" %>
  <%String logId = (String) session.getAttribute("logId"); 
String auth = (String) session.getAttribute("auth");
%>
  
<section class="py-12" id="howItWorks">
      <div class="container">
        <div class="row">
          <div class="col-12">
            <!-- Heading -->
            <h2 class="mb-10 text-center">
              상품 카테고리
            </h2>

          </div>
        </div>
        <div class="row">
        <c:forEach var="category" items="${totalList}">
          <div class="col-24 col-md-2">
            <!-- Card -->
            <div class="card bg-none mb-7 mb-md-0">
              <!-- Image -->
              <div class="card-img-top position-relative mx-auto" style="max-width: 120px;">
                <!-- Image -->
                <img class="img-fluid rounded-circle" src="jsb/imgs/saucedak.png" alt="...">
              </div>
              <!-- Body -->
              <div class="card-body text-center">
                <!-- Heading -->
                <h6 class="mb-4">
                  ${category.key}
                </h6>
              </div>
            </div>
          </div>
          </c:forEach>
        </div>
        
        <section class="py-12">
      <div class="container">
        <div class="row">
          <div class="col-12">

            <!-- Heading -->
            <h2 class="mb-10 text-center">
              추천상품
            </h2>

          </div>
        </div>
        <div class="row">
        <c:forEach var="product" items="${bestProducts}" begin="1" end="3" step="1">
        <div class="col-12 col-md-4 col-lg-3">
			        <div class="card">
					  <div class="card-img">
					    <!-- Image -->
					    <img class="card-img-top" src="./jsb/assets/img/products/product-6.jpg" alt="...">
					
					    <!-- Actions -->
					    <div class="card-actions">
					      <span class="card-action">
					        <button class="btn btn-xs btn-circle btn-white-primary" data-toggle="button">
					          <i class="fe fe-shopping-cart"></i>
					        </button>
					      </span>
					      <span class="card-action">
					        <button class="btn btn-xs btn-circle btn-white-primary" data-toggle="button">
					          <i class="fe fe-heart"></i>
					        </button>
					      </span>
					    </div>
					  </div>
					  <!-- Body -->
		              <div class="card-body fw-bold text-center">
		                <a class="text-body" href="#!">${product.productName}</a>
		                <div class="text-muted">${product.price}</div>
		              </div>
					</div>
				</div>
        </c:forEach>
        </div>
        
      </div>
    </section>
      </div>
    </section>
    <script>
	const totalList = JSON.parse('${json}');
	const logid = '${logId}';
	const auth = '${auth}';
</script>