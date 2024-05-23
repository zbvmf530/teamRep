/**
 * 
 */

 $(document).ready(initNavMenu);
 
 function initNavMenu(){
	// 대분류 초기화
	
	
	$('ul[id="test"]').html('');
	
	 // 대분류에 소분류 넣기
	 $.each(totalList, function(key, idx) {
		 //console.log(totalList[key]);
		 let maincat = $('<li class="nav-item dropdown position-static"/>');
		 let mainname = $('<a class="nav-link" data-bs-toggle="dropdown" href="#"></a>');
		 let path1 = '/productlist.do?main='+key+'&sub=null';
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
				let pageLink = $('<a class="list-styled-link" href="/productlist.do?">');
				let path2 = '/productlist.do?main='+key2+'&sub='+category;
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
 
 function listPage(e){
	console.log(e.innerText);
 }