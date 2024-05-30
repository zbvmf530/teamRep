<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%String logId = (String) session.getAttribute("logId"); 
String auth = (String) session.getAttribute("auth");
%>  
    

    
<!-- 회원정보 -->   
     <section class="py-11">
      <div class="container">
        <div class="row">
          <div class="col-12 col-md-4 col-lg-3">

            <!-- Filters -->
            <form class="mb-10 mb-md-0">
              <ul class="nav nav-vertical" id="filterNav">
                <li class="nav-item">

                  <!-- Toggle -->
                  <a class="nav-link dropdown-toggle fs-lg text-reset border-bottom mb-6" data-bs-toggle="collapse" href="#categoryCollapse">
                    마이페이지
                  </a>

                  <!-- Collapse -->
                  <div class="collapse show" id="categoryCollapse">
                    <div class="form-group">
                      <ul class="list-styled mb-0" id="productsNav">
                        <li class="list-styled-item">
                          <a class="list-styled-link" href="#">
                            주문내역
                          </a>
                        </li>
                        <li class="list-styled-item">
                          <a class="list-styled-link" href="#">
                            관심상품
                          </a>
                        </li>
                        <li class="list-styled-item">
                          <a class="list-styled-link" href="#">
                            내 게시물
                          </a>
                        </li>
                        <li class="list-styled-item">
                          <a class="list-styled-link" href="#">
                            회원정보 수정
                          </a>
                        </li>
                        <li class="list-styled-item">
                          <a class="list-styled-link" href="#">
                            회원탈퇴
                          </a>
                        </li>
                      </ul>
                    </div>
                  </div>

                </li>   
                
                </ul>
                </form>
                </div>
                <div class="col-12 col-md-8 col-lg-9">
                		<!-- 주문 정보 -->
                		<h6>주문내역</h6>
                		<hr/>
						<table class="table">
						
							<thead>
								<tr>
						              <th>주문일자</th>
						              <th>상품명</th>
						              <th>결제금액</th>
						              <th>주문상세</th>
						        </tr>
							</thead>
						
							<tbody>
							
							</tbody>
						</table>
                </div>
                
                </div>
                </div>
                </section>
    

<hr />
