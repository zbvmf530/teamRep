<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="pt-7 pb-12">
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">

            <!-- Heading -->
            <h3 class="mb-4">Checkout</h3>

            <!-- Subheading -->
            <p class="mb-10">
              Already have an account? <a class="fw-bold text-reset" href="#!">Click here to login</a>
            </p>

          </div>
        </div>
        <div class="row">
          <div class="col-12 col-md-7">

            <!-- Form -->
            <form>

              <!-- Heading -->
              <h6 class="mb-7">Billing Details</h6>

              <!-- Billing details -->
              <div class="row mb-9">
                <div class="col-12 col-md-6">

                  <!-- First Name -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingFirstName">First Name *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingFirstName" type="text" placeholder="First Name" required>
                  </div>

                </div>
                <div class="col-12 col-md-6">

                  <!-- Last Name -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingLastName">Last Name *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingLastName" type="text" placeholder="Last Name" required>
                  </div>

                </div>
                <div class="col-12">

                  <!-- Email -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingEmail">Email *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingEmail" type="email" placeholder="Email" required>
                  </div>

                </div>
                <div class="col-12">

                  <!-- Company Name -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingCompany">Company name *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingCompany" type="text" placeholder="Company name (optional)">
                  </div>

                </div>
                <div class="col-12">

                  <!-- Country -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingCountry">Country *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingCountry" type="text" placeholder="Country" required>
                  </div>

                </div>
                <div class="col-12">

                  <!-- Address Line 1 -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingAddress">Address Line 1 *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingAddress" type="text" placeholder="Address Line 1" required>
                  </div>

                </div>
                <div class="col-12">

                  <!-- Address Line 2 -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingAddressTwo">Address Line 2</label>
                    <input class="form-control form-control-sm" id="checkoutBillingAddressTwo" type="text" placeholder="Address Line 2 (optional)">
                  </div>

                </div>
                <div class="col-12 col-md-6">

                  <!-- Town / City -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingTown">Town / City *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingTown" type="text" placeholder="Town / City" required>
                  </div>

                </div>
                <div class="col-12 col-md-6">

                  <!-- ZIP / Postcode -->
                  <div class="form-group">
                    <label class="form-label" for="checkoutBillingZIP">ZIP / Postcode *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingZIP" type="text" placeholder="ZIP / Postcode" required>
                  </div>

                </div>
                <div class="col-12">

                  <!-- Mobile Phone -->
                  <div class="form-group mb-0">
                    <label class="form-label" for="checkoutBillingPhone">Mobile Phone *</label>
                    <input class="form-control form-control-sm" id="checkoutBillingPhone" type="tel" placeholder="Mobile Phone" required>
                  </div>

                </div>
              </div>

              
              <!-- Address -->
              <div class="mb-9">

                <!-- Checkbox -->
                <div class="form-check">
                  <input class="form-check-input" id="checkoutShippingAddress" type="checkbox">
                  <label class="form-check-label fs-sm" data-bs-toggle="collapse" data-bs-target="#checkoutShippingAddressCollapse" for="checkoutShippingAddress">
                    Ship to a different address?
                  </label>
                </div>

                <!-- Collapse -->
                <div class="collapse" id="checkoutShippingAddressCollapse">
                  <div class="row mt-6">
                    <div class="col-12">

                      <!-- Country -->
                      <div class="form-group">
                        <label class="form-label" for="checkoutShippingAddressCountry">Country *</label>
                        <input class="form-control form-control-sm" id="checkoutShippingAddressCountry" type="text" placeholder="Country">
                      </div>

                    </div>
                    <div class="col-12">

                      <!-- Address Line 1 -->
                      <div class="form-group">
                        <label class="form-label" for="checkoutShippingAddressLineOne">Address Line 1 *</label>
                        <input class="form-control form-control-sm" id="checkoutShippingAddressLineOne" type="text" placeholder="Address Line 1">
                      </div>

                    </div>
                    <div class="col-12">

                      <!-- Address Line 2 -->
                      <div class="form-group">
                        <label class="form-label" for="checkoutShippingAddressLineTwo">Address Line 2</label>
                        <input class="form-control form-control-sm" id="checkoutShippingAddressLineTwo" type="text" placeholder="Address Line 2 (optional)">
                      </div>

                    </div>
                    <div class="col-6">

                      <!-- Town / City -->
                      <div class="form-group">
                        <label class="form-label" for="checkoutShippingAddressTown">Town / City *</label>
                        <input class="form-control form-control-sm" id="checkoutShippingAddressTown" type="text" placeholder="Town / City">
                      </div>

                    </div>
                    <div class="col-6">

                      <!-- Town / City -->
                      <div class="form-group">
                        <label class="form-label" for="checkoutShippingAddressZIP">ZIP / Postcode *</label>
                        <input class="form-control form-control-sm" id="checkoutShippingAddressZIP" type="text" placeholder="ZIP / Postcode">
                      </div>

                    </div>
                    <div class="col-12">

                      <!-- Button -->
                      <button class="btn btn-sm btn-outline-dark" type="submit">
                        Save Address
                      </button>

                    </div>
                  </div>
                </div>

              </div>

            </form>

          </div>
          <div class="col-12 col-md-5 col-lg-4 offset-lg-1">

            <!-- Heading -->
            <h6 class="mb-7">Order Items (3)</h6>

            <!-- Divider -->
            <hr class="my-7">

            <!-- List group -->
            <ul class="list-group list-group-lg list-group-flush-y list-group-flush-x mb-7">
              <li class="list-group-item">
                <div class="row align-items-center">
                  <div class="col-4">

                    <!-- Image -->
                    <a href="product.html">
                      <img src="assets/img/products/product-6.jpg" alt="..." class="img-fluid">
                    </a>

                  </div>
                  <div class="col">

                    <!-- Title -->
                    <p class="mb-4 fs-sm fw-bold">
                      <a class="text-body" href="product.html">Cotton floral print Dress</a> <br>
                      <span class="text-muted">$40.00</span>
                    </p>

                    <!-- Text -->
                    <div class="fs-sm text-muted">
                      Size: M <br>
                      Color: Red
                    </div>

                  </div>
                </div>
              </li>
              <li class="list-group-item">
                <div class="row align-items-center">
                  <div class="col-4">

                    <!-- Image -->
                    <a href="product.html">
                      <img src="assets/img/products/product-10.jpg" alt="..." class="img-fluid">
                    </a>

                  </div>
                  <div class="col">

                    <!-- Title -->
                    <p class="mb-4 fs-sm fw-bold">
                      <a class="text-body" href="product.html">Suede cross body Bag</a> <br>
                      <span class="text-muted">$49.00</span>
                    </p>

                    <!-- Text -->
                    <div class="fs-sm text-muted">
                      Color: Brown
                    </div>

                  </div>
                </div>
              </li>
            </ul>

            <!-- Card -->
            <div class="card mb-9 bg-light">
              <div class="card-body">
                <ul class="list-group list-group-sm list-group-flush-y list-group-flush-x">
                  <li class="list-group-item d-flex">
                    <span>Subtotal</span> <span class="ms-auto fs-sm">$89.00</span>
                  </li>
                  <li class="list-group-item d-flex">
                    <span>Tax</span> <span class="ms-auto fs-sm">$00.00</span>
                  </li>
                  <li class="list-group-item d-flex">
                    <span>Shipping</span> <span class="ms-auto fs-sm">$8.00</span>
                  </li>
                  <li class="list-group-item d-flex fs-lg fw-bold">
                    <span>Total</span> <span class="ms-auto">$97.00</span>
                  </li>
                </ul>
              </div>
            </div>

            <!-- Disclaimer -->
            <p class="mb-7 fs-xs text-gray-500">
              Your personal data will be used to process your order, support
              your experience throughout this website, and for other purposes
              described in our privacy policy.
            </p>

            <!-- Button -->
            <button class="btn w-100 btn-dark">
              Place Order
            </button>

          </div>
        </div>
      </div>
    </section>