/**
 * 
 */

 var logId = 'null';
 var auth = 'null';
 $(document).ready(initNavBar);
 function initNavBar(){
	console.log("navmenu.js 호출")
	makeCategory();
	
	 navsvc.getSessionID(result => {
		 logId=result['logId'];
		 auth=result['auth'];		 
		 makeloginMenu(logId,auth);
	 });
		
	// 공지사항, q&a 설정(메뉴바)
	$(document).find($('a[id="notice"]')).prop('href',`boardList.do?boardType=N`);
	//page searchCondition keyword
	$(document).find($('a[id="qna"]')).prop('href',`boardList.do?boardType=Q`);
	$('a[id="cartButton"]').prop('href',`cartpage.do`);
 }
 
 function makeloginMenu(id,gwon){
	console.log(id);
	let menuItems = $(document).find($('div[id="loginMenu"] ul')).find('li');
	// 세션정보 받아서 메뉴값 다르게 출력, href 다르게 설정
	let menutexts = ["마이페이지","로그아웃"];
	// ["관리페이지", "로그아웃"]
	// ["로그인", "회원가입"]
	if (id == 'none'){menutexts = ["로그인", "회원가입"];}
	else if(id != 'none') {
		 if (gwon == 'admin') {menutexts = ["관리페이지", "로그아웃"];}
		 else {menutexts = ["마이페이지", "로그아웃"];}
	}
	
	$.each(menuItems,function(idx,item){
		$(item).find($('a')).text(menutexts[idx]);
		if(menutexts[idx]=='로그인'){$(item).find($('a')).prop('href',`tloginForm.do`)}
		else if(menutexts[idx]=='로그아웃'){$(item).find($('a')).prop('href',`logout.do`)}
		else if(menutexts[idx]=='회원가입'){$(item).find($('a')).prop('href',`signupform.do`)}
		else if(menutexts[idx]=='마이페이지'){$(item).find($('a')).prop('href',`mypage.do`)}
		else if(menutexts[idx]=='관리페이지'){$(item).find($('a')).prop('href',`admin.do`)}
	});
 }
 
 function listPage(e){
	console.log(e.innerText);
 }
 
 function makeCategory(){
	// 대분류 초기화
	$('ul[id="test"]').html('');
	 navsvc.getnavMenu(result => {
		 $.each(result, function(key, idx) {
			 //console.log(result[key]);
			 let maincat = $('<li class="nav-item dropdown position-static"/>');
			 let mainname = $('<a class="nav-link" data-bs-toggle="dropdown" href="#"></a>');
			 let path1 = 'productlist.do?main=' + key + '&sub=null';
			 mainname.prop('href', path1);
			 mainname.text(key);
			 let dropdownCard = $('<div class="dropdown-menu w-100"><div class="card card-lg"> <div class="card-body"> <div class="tab-content"> <div class="tab-pane fade show active" id="navTab"> <div class="container"> <div class="row"></div></div></div></div></div></div></div>');

			 $('ul[id="test"]').append(maincat);
			 maincat.append(mainname);
			 maincat.append(dropdownCard);

			 let menus = dropdownCard.find('div[class="row"]');
			 $.each(result, function(key2, idx2) {
				 let subCol = $('<div class="col-6 col-md">');
				 let head = $('<div class="mb-5 fw-bold"></div>');
				 head.text(key2);
				 subCol.append(head);
				 let subLists = $('<ul class="list-styled mb-6 mb-md-0 fs-sm">');
				 $.each(result[key2], function(idx, category) {
					 let subCategory = $('<li class="list-styled-item">');
					 // 여기에 상품목록 페이지 링크 걸어서 테스트
					 let pageLink = $('<a class="list-styled-link" href="productlist.do?">');
					 let path2 = 'productlist.do?main=' + key2 + '&sub=' + category;
					 pageLink.prop('href', path2);
					 pageLink.text(category);
					 subCategory.append(pageLink);
					 subLists.append(subCategory);
				 });
				 subCol.append(subLists);
				 menus.append(subCol);

			 });
		 })
	 });
 }