<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <section class="pt-7 pb-12">
      <div class="container">
        <div class="row">
          <div class="col-12">

            <!-- Heading -->
            <h3 class="mb-10 text-center">Shopping Cart</h3>

          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-7">

            <!-- List group -->
            <ul class="list-group list-group-lg list-group-flush-x mb-6" id = "cartlist">
              <li class="list-group-item" hidden = "hidden">
                <div class="row align-items-center">
                  <div class="col-3">

                    <!-- Image -->

                      <img src="./assets/img/screenshots/shop/product.png" alt="..." class="img-fluid">

                  </div>
                  <div class="col">

                    <!-- Title -->
                    <div class="d-flex mb-2 fw-bold">
                      <a class="text-body" href="product.html">담기</a> <span class="ms-auto">$40.00</span>
                      <input type="hidden" id = "optPrice">
                      <input type="hidden" id ="prodPrice">
                    </div>

                    <!-- Text -->
                    <p class="mb-7 fs-sm text-muted">
                    옵션 : ★BEST★오통닭 3종 20팩 (오리지널 10 + 매콤바베큐 5 + 양념갈비맛 5)
                    </p>

                    <!--Footer -->
                    <div class="d-flex align-items-center">
                      <span onclick="javascript: test(event);">
		                <i class="fas fa-arrow-alt-circle-left left"></i>
		              </span>
		              <input type="text" value="0" readonly>
		              <span onclick="javascript: test(event);">
		                <i class="fas fa-arrow-alt-circle-right right"></i>
		              </span>
                      <!-- Remove -->
                      <a class="fs-xs text-gray-400 ms-auto" href="#!">
                        <i class="fe fe-x"></i> Remove
                      </a>

                    </div>

                  </div>
                </div>
              </li>
            </ul>

          </div>
          <div class="col-12 col-md-5 col-lg-4 offset-lg-1">

            <!-- Total -->
            <div class="card mb-7 bg-light">
              <div class="card-body">
                <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x">
                  <li class="list-group-item d-flex fs-lg fw-bold">
                    <span>Total</span> <span class="ms-auto fs-sm">$89.00</span>
                  </li>
                </ul>
              </div>
            </div>

            <!-- Button -->
            <a class="btn w-100 btn-dark mb-2" href="checkout.html">Proceed to Checkout</a>

            <!-- Link -->
            <a class="btn btn-link btn-sm px-0 text-body" href="shop.html">
              <i class="fe fe-arrow-left me-2"></i> Continue Shopping
            </a>

          </div>
        </div>
      </div>
    </section>

    
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="jsb/js/cartService.js"></script>
  <script src="jsb/js/cart.js"></script>
