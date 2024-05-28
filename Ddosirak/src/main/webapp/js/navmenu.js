/**
 * 
 */

 $(document).ready(initNavBar);
 
 function initNavBar(){
	//console.log($('a[id="notice"]'));
	//console.log($('a[id="qna"]'));	
	makeCategory();
	let json = encodeURIComponent(JSON.stringify(totalList));
	let menuItems = $(document).find($('div[id="loginMenu"] ul')).find('li');
	// 세션정보 받아서 메뉴값 다르게 출력, href 다르게 설정
	let menutexts = ["마이페이지","로그아웃"];
	// ["관리페이지", "로그아웃"]
	// ["로그인", "회원가입"]
	if(logid != 'null'){
		if(auth == 'admin'){
			menutexts = ["관리페이지", "로그아웃"];
		}	
		else{
			menutexts = ["마이페이지","로그아웃"];	
		}
	}
	else{
		menutexts = ["로그인", "회원가입"];
	}
	$.each(menuItems,function(idx,item){
		//console.log(item);
		
//		console.log($(item).find($('a')));
		$(item).find($('a')).text(menutexts[idx]);
		if(menutexts[idx]=='로그인'){$(item).find($('a')).prop('href',`tloginForm.do?navmenu=${json}`)}
		else if(menutexts[idx]=='로그아웃'){$(item).find($('a')).prop('href',`logout.do?navmenu=${json}`)}
		else if(menutexts[idx]=='회원가입'){$(item).find($('a')).prop('href',`signupform.do?navmenu=${json}`)}
		else if(menutexts[idx]=='마이페이지'){$(item).find($('a')).prop('href',`mypage.do?navmenu=${json}`)}
		else if(menutexts[idx]=='관리페이지'){$(item).find($('a')).prop('href',`admin.do`)}
		/*$(item).text(menutexts[idx]);*/
	});
	
		
	//console.log($(document).find($('div[id="loginMenu"]')).prev());
	
	// 공지사항, q&a 설정(메뉴바)
	$(document).find($('a[id="notice"]')).prop('href',`boardList.do?navmenu=${json}`);
	//page searchCondition keyword
	$(document).find($('a[id="qna"]')).prop('href',`queryList.do?navmenu=${json}`);
	//svc.getnavMenu(result=>{console.log(result)});
	
 }
 
 function listPage(e){
	console.log(e.innerText);
 }
 
 function makeCategory(){
	// 대분류 초기화
	$('ul[id="test"]').html('');
	
	 // 대분류에 소분류 넣기
	 $.each(totalList, function(key, idx) {
		 //console.log(totalList[key]);
		 let maincat = $('<li class="nav-item dropdown position-static"/>');
		 let mainname = $('<a class="nav-link" data-bs-toggle="dropdown" href="#"></a>');
		 let path1 = 'productlist.do?main='+key+'&sub=null';
		 mainname.prop('href',path1);
		 mainname.text(key);
		 let dropdownCard = $('<div class="dropdown-menu w-100"><div class="card card-lg"> <div class="card-body"> <div class="tab-content"> <div class="tab-pane fade show active" id="navTab"> <div class="container"> <div class="row"></div></div></div></div></div></div></div>');

		 $('ul[id="test"]').append(maincat);
		 maincat.append(mainname);
		 maincat.append(dropdownCard);

		 let menus = dropdownCard.find('div[class="row"]');
		 $.each(totalList, function(key2, idx2) {
			 let subCol = $('<div class="col-6 col-md">');
			 let head = $('<div class="mb-5 fw-bold"></div>');
			 head.text(key2);
			 subCol.append(head);
			 let subLists = $('<ul class="list-styled mb-6 mb-md-0 fs-sm">');
			 $.each(totalList[key2],function(idx,category){
				let subCategory = $('<li class="list-styled-item">');
				// 여기에 상품목록 페이지 링크 걸어서 테스트
				let pageLink = $('<a class="list-styled-link" href="productlist.do?">');
				let path2 = 'productlist.do?main='+key2+'&sub='+category;
				pageLink.prop('href',path2);
				pageLink.text(category);
				subCategory.append(pageLink);
				subLists.append(subCategory);
				});
			subCol.append(subLists);
			 menus.append(subCol);

		 });
		 
	 });
 }