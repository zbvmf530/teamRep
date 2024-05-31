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
 }
 
 function drawUpdateMemberInfoPage(e){
	drawCommonElements("회원정보 수정");
	let pageContent = $(document).find('div[id = "pagecontents"]');
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