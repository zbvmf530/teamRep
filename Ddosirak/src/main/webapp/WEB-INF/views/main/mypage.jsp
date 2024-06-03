<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%String logId = (String) session.getAttribute("logId"); 
String auth = (String) session.getAttribute("auth");
%>  
    
<section class="pt-7 pb-12">
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">

            <!-- Heading -->
            <h3 class="mb-10" id = "maintitle" >My Page</h3>

          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-3">
            <!-- Nav -->
            <nav class="mb-10 mb-md-0">
              <div class="list-group list-group-sm list-group-strong list-group-flush-x">
                <a class="list-group-item list-group-item-action dropend-toggle active" href="#" onclick="javascript: drawOrderPage(event); return false;">
                  주문내역
                </a>
                <a class="list-group-item list-group-item-action dropend-toggle " href="#" onclick="javascript: drawWishListPage(event); return false;">
                  관심상품
                </a>
                <a class="list-group-item list-group-item-action dropend-toggle " href="#" onclick="javascript: drawUpdateMemberInfoPage(event); return false;">
                  회원정보 수정
                </a>
                <a class="list-group-item list-group-item-action dropend-toggle " href="#" onclick="javascript: drawUpdateAddressPage(event); return false;">
                  배송지 관리
                </a>
                <a class="list-group-item list-group-item-action dropend-toggle " href="#" onclick="javascript: drawMyboardPage(event); return false;">
                  내 게시물
                </a>
                <a class="list-group-item list-group-item-action dropend-toggle" href="#" onclick="javascript: drawSignOutPage(event); return false;">
                  회원탈퇴
                </a>
              </div>
            </nav>

          </div>
          <div class="col-12 col-md-9 col-lg-8 offset-lg-1" id = "pagecontents">
        <div class="row">
          <div class="col-12 text-center">

            <!-- Heading -->
            <h5 class="mb-10" id = "subtitle">주문 내역</h5>

          </div>
        </div>
            <!-- Order -->
            <div class="card card-lg mb-5 border">
              <div class="card-body pb-0">

                <!-- Info -->
                <div class="card card-sm">
                  <div class="card-body bg-light">
                    <div class="row">
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Order No:</h6>

                        <!-- Text -->
                        <p class="mb-lg-0 fs-sm fw-bold">
                          673290789
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Shipped date:</h6>

                        <!-- Text -->
                        <p class="mb-lg-0 fs-sm fw-bold">
                          <time datetime="2019-10-01">
                            01 Oct, 2019
                          </time>
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Status:</h6>

                        <!-- Text -->
                        <p class="mb-0 fs-sm fw-bold">
                          Awating Delivery
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Order Amount:</h6>

                        <!-- Text -->
                        <p class="mb-0 fs-sm fw-bold">
                          $259.00
                        </p>

                      </div>
                    </div>
                  </div>
                </div>

              </div>
              <div class="card-footer">
                <div class="row align-items-center">
                  <div class="col-12 col-lg-6">
                    <div class="row gx-5 mb-4 mb-lg-0">
                      <div class="col-3">

                        <!-- Image -->
                        <div class="ratio ratio-1x1 bg-cover" style="background-image: url(assets/img/products/product-5.jpg);"></div>

                      </div>
                      <div class="col-3">

                        <!-- Image -->
                        <div class="ratio ratio-1x1 bg-cover" style="background-image: url(assets/img/products/product-112.jpg);"></div>

                      </div>
                      <div class="col-3">

                        <!-- Image -->
                        <div class="ratio ratio-1x1 bg-cover" style="background-image: url(assets/img/products/product-7.jpg);"></div>

                      </div>
                      <div class="col-3">

                        <!-- Image -->
                        <div class="ratio ratio-1x1 bg-light">
                          <a class="ratio-item ratio-item-text text-reset" href="#!">
                            <div class="fs-xxs fw-bold">
                              +2 <br> more
                            </div>
                          </a>
                        </div>

                      </div>
                    </div>
                  </div>
                  <div class="col-12 col-lg-6">
                    <div class="row gx-5">
                      <div class="col-6">

                        <!-- Button -->
                        <a class="btn btn-sm w-100 btn-outline-dark" href="reviewWrite.do">
                          리뷰 작성
                        </a>

                      </div>
                      <div class="col-6">

                        <!-- Button -->
                        <a class="btn btn-sm w-100 btn-outline-dark" href="#!">
                          Track order
                        </a>

                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>

            <!-- Order -->
            <div class="card card-lg mb-5 border">
              <div class="card-body pb-0">

                <!-- Info -->
                <div class="card card-sm">
                  <div class="card-body bg-light">
                    <div class="row">
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Order No:</h6>

                        <!-- Text -->
                        <p class="mb-lg-0 fs-sm fw-bold">
                          871090437
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Shipped date:</h6>

                        <!-- Text -->
                        <p class="mb-lg-0 fs-sm fw-bold">
                          <time datetime="2019-09-25">
                            25 Sep, 2019
                          </time>
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Status:</h6>

                        <!-- Text -->
                        <p class="mb-0 fs-sm fw-bold">
                          In Processing
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Order Amount:</h6>

                        <!-- Text -->
                        <p class="mb-0 fs-sm fw-bold">
                          $75.00
                        </p>

                      </div>
                    </div>
                  </div>
                </div>

              </div>
              <div class="card-footer">
                <div class="row align-items-center">
                  <div class="col-12 col-lg-6">
                    <div class="row gx-5 mb-4 mb-lg-0">
                      <div class="col-3">

                        <!-- Image -->
                        <div class="ratio ratio-1x1 bg-cover" style="background-image: url(assets/img/products/product-11.jpg);"></div>

                      </div>
                    </div>
                  </div>
                  <div class="col-12 col-lg-6">
                    <div class="row gx-5">
                      <div class="col-6">

                        <!-- Button -->
                        <a class="btn btn-sm w-100 btn-outline-dark" href="reviewWrite.do">
                          리뷰 작성
                        </a>

                      </div>
                      <div class="col-6">

                        <!-- Button -->
                        <a class="btn btn-sm w-100 btn-outline-dark" href="#!">
                          Track order
                        </a>

                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>

            <!-- Order -->
            <div class="card card-lg mb-5 border">
              <div class="card-body pb-0">

                <!-- Info -->
                <div class="card card-sm">
                  <div class="card-body bg-light">
                    <div class="row">
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Order No:</h6>

                        <!-- Text -->
                        <p class="mb-lg-0 fs-sm fw-bold">
                          891230563
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Shipped date:</h6>

                        <!-- Text -->
                        <p class="mb-lg-0 fs-sm fw-bold">
                          <time datetime="2019-09-07">
                            07 Sep, 2019
                          </time>
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Status:</h6>

                        <!-- Text -->
                        <p class="mb-0 fs-sm fw-bold">
                          Delivered
                        </p>

                      </div>
                      <div class="col-6 col-lg-3">

                        <!-- Heading -->
                        <h6 class="heading-xxxs text-muted">Order Amount:</h6>

                        <!-- Text -->
                        <p class="mb-0 fs-sm fw-bold">
                          $69.00
                        </p>

                      </div>
                    </div>
                  </div>
                </div>

              </div>
              <div class="card-footer">
                <div class="row align-items-center">
                  <div class="col-12 col-lg-6">
                    <div class="row gx-5 mb-4 mb-lg-0">
                      <div class="col-3">

                        <!-- Image -->
                        <div class="ratio ratio-1x1 bg-cover" style="background-image: url(assets/img/products/product-14.jpg);"></div>

                      </div>
                      <div class="col-3">

                        <!-- Image -->
                        <div class="ratio ratio-1x1 bg-cover" style="background-image: url(assets/img/products/product-15.jpg);"></div>

                      </div>
                    </div>
                  </div>
                  <div class="col-12 col-lg-6">
                    <div class="row gx-5">
                      <div class="col-6">

                        <!-- Button -->
                        <a class="btn btn-sm w-100 btn-outline-dark" href="reviewWrite.do">
                          리뷰 작성
                        </a>

                      </div>
                      <div class="col-6">

                        <!-- Button -->
                        <a class="btn btn-sm w-100 btn-outline-dark" href="#!">
                          Track order
                        </a>

                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
<hr />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="jsb/js/mypage.js"></script>