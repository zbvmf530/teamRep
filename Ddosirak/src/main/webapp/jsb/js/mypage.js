/**
 * 
 */
function drawCommonElements(pageName=""){
	let subcontent = $(document).find('div[id = "pagecontents"]');
	let contentTitle = $(document).find('h5[id = "subtitle"]').parent().parent().clone();
	contentTitle.find('h5[id = "subtitle"]').text(pageName);
	
	subcontent.html('');
	subcontent.append(contentTitle);
	
}
 function drawOrderPage(e){
	drawCommonElements("주문내역");
	let pageContent = $(document).find('div[id = "pagecontents"]');
 }
 
 function drawWishListPage(e){
	drawCommonElements("관심상품");
	let pageContent = $(document).find('div[id = "pagecontents"]');
	let row = $('<div class="row"]/>');
	let divItem = '<div class="col-6 col-md-4">'
				+'<div class="card mb-7">'
				+'<div class="card-img">'
                +'<button class="btn btn-xs btn-circle btn-white-primary card-action card-action-end">'
				+'<i class="fe fe-x"></i></button>'
                +'<button class="btn btn-xs w-100 btn-dark card-btn" data-bs-toggle="modal" data-bs-target="#modalProduct">'  
				+'<i class="fe fe-eye me-2 mb-1"></i> Quick View</button><img class="card-img-top" src="assets/img/products/product-131.jpg" alt="..."></div>'
				+ '<div class="card-body fw-bold text-center"><a class="text-body" href="main.do">Cotton floral print Dress</a> <br>'
				+'<span class="text-muted">$40.00</span></div></div></div>';
  
	for(let i = 0;i<6;i++){
		let itemdiv = $(divItem);
		row.append(itemdiv);
	}
	pageContent.append(row);
 }
 
 function drawUpdateMemberInfoPage(e){
	drawCommonElements("회원정보 수정");
	let pageContent = $(document).find('div[id = "pagecontents"]');
	let row = $('<div class="row"]/>');
	let subpage = '<form>'
              +'<div class="row">'
              +  '<div class="col-12 col-md-6">'
              +    '<div class="form-group">'
              +      '<label class="form-label" for="accountFirstName">'
              +        'First Name * </label>'
              +      '<input class="form-control form-control-sm" id="accountFirstName" type="text" placeholder="First Name *" value="Daniel" required=""></div></div>'
              +  '<div class="col-12 col-md-6"><div class="form-group"><label class="form-label" for="accountLastName">'
              +        'Last Name * </label>'
              +      '<input class="form-control form-control-sm" id="accountLastName" type="text" placeholder="Last Name *" value="Robinson" required="">'
              +    '</div></div><div class="col-12"><div class="form-group"><label class="form-label" for="accountEmail">Email Address *</label>'
              +      '<input class="form-control form-control-sm" id="accountEmail" type="email" placeholder="Email Address *" value="user@email.com" required=""></div>'
              +  '</div><div class="col-12 col-md-6"><div class="form-group"><label class="form-label" for="accountPassword">'
              +        'Current Password *</label>'
              +      '<input class="form-control form-control-sm" id="accountPassword" type="password" placeholder="Current Password *" required="">'
              +    '</div></div><div class="col-12 col-md-6"><div class="form-group"><label class="form-label" for="AccountNewPassword">'
              +        'New Password *</label>'
              +      '<input class="form-control form-control-sm" id="AccountNewPassword" type="password" placeholder="New Password *" required="">'
              +    '</div></div><div class="col-12 col-lg-6"><div class="form-group"><label class="form-label">Date of Birth</label>'
              +      '<div class="row gx-5"><div class="col-auto"><label class="visually-hidden" for="accountDate">Date</label>'
              +          '<select class="form-select form-select-sm" id="accountDate"><option>10</option>'
              +   '<option>11</option><option selected="">12</option></select></div><div class="col"><label class="visually-hidden" for="accountMonth">'
              +  'Month</label><select class="form-select form-select-sm" id="accountMonth"><option>January</option>'
              + '<option selected="">February</option><option>March</option></select></div><div class="col-auto">'
              +  '<label class="visually-hidden" for="accountYear">Year</label>'
              + '<select class="form-select form-select-sm" id="accountYear"><option>1990</option><option selected="">1991</option>'
              + '<option>1992</option></select></div></div></div></div><div class="col-12 col-lg-6"><div class="form-group mb-8">'
              + '<label class="form-label">Gender</label><div>'
              +  '<input class="btn-check" type="radio" name="gender" id="male" checked="">'
              +  '<label class="btn btn-sm btn-outline-border" for="male">Male</label>'
              +  '<input class="btn-check" type="radio" name="gender" id="female">'
              + '<label class="btn btn-sm btn-outline-border" for="female">Female</label></div></div></div>'
              +  '<div class="col-12"><button class="btn btn-dark" type="submit">Save Changes</button></div></div></form>';
              let itemdiv= $(subpage);
          row.append(itemdiv);
          pageContent.append(row);
 }
 
 function drawUpdateAddressPage(e){
	drawCommonElements("배송지 관리");
	let pageContent = $(document).find('div[id = "pagecontents"]');
 }
 
 function drawMyboardPage(e){
	drawCommonElements("내 게시물");
	let pageContent = $(document).find('div[id = "pagecontents"]');
 }
 
 function drawSignOutPage(e){
	drawCommonElements("회원탈퇴");
 }