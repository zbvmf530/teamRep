

$(document).ready(initCart);


function initCart(){	
	
	$(document).find($('span[id="totalPrice"]')).text('0');
	$(document).find($('span[id="totalPrice"]')).attr('data-totalprice',0);
	drawCart();
	//console.log($('ul[id="cartlist"]').find('li'));
}
function drawCart(){
	let cartList = $('ul[id="cartlist"]');
	let cartItemFormat = $('ul[id="cartlist"]').find('li[hidden="hidden"]');
	cartList.find('li').each((idx,item)=>{if(idx>0){$(item).remove()}});
	cartsvc.cartList(result=>{
		$.each(result,function(idx,item){
			
			let cartItem = cartItemFormat.clone();
			cartItem.removeAttr('hidden');
			cartList.append(cartItem);
			cartItem.attr('data-cartNo',item['cartNo']);
			
			//console.log(cartItem.find($('p[class="mb-7 fs-sm text-muted"]')));
			cartsvc.optionList(item['optionCode'],result=>{
													cartItem.find($('p[class="mb-7 fs-sm text-muted"]'))
													.text(result['optionName']);
													
													cartItem.find($('div[class="d-flex mb-2 fw-bold"]'))
													.find($('input[id="optPrice"]'))
													.attr('value',result['optionPrice']);
													});
													
			cartsvc.productList(item['productCode'],result=> {
													cartItem.find($('div[class="d-flex mb-2 fw-bold"] a'))
													.text(result['productName']);
													
													cartItem.find($('div[class="d-flex mb-2 fw-bold"]'))
													.find($('input[id="prodPrice"]'))
													.attr('value',result['price'])
													});
													
			// 옵션 fetch item['optionCode']
			cartItem.find($('span[class="ms-auto"]')).text((item['price']).numberFormat()+'원');
			cartItem.find($('span[class="ms-auto"]')).attr('data-price',item['price']);
			
			// 상품 이름 div
			//console.log(cartItem.find($('div[class="d-flex mb-2 fw-bold"]')).find($('input')));
			// 상품 개수 div
			cartItem.find($('div[class="d-flex align-items-center"]'))
			.find($('input[id="itemcount"]')).attr('value',item['count']);
			
			calcTotalPrice();
			
		});
	});
	
}
function calcTotalPrice(){
	let totalPrice = $(document).find($('span[id="totalPrice"]'));
	//console.log(totalPrice);
	let sum = 0;
	let cartList = $('ul[id="cartlist"]');
	
	//console.log(cartList.find('li'));
	cartList.find('li').each(function(idx,item){
		if($(item).is(':hidden')){}
		else{
			let itemprice = $(item).find($('span[class="ms-auto"]')).attr('data-price');
			sum = (1*sum)+(1*itemprice);
		}
	});
	//console.log(sum);
	//console.log(totalPrice);
	totalPrice.data('totalprice',sum);
	//console.log("총가격 : "+totalPrice.data('totalprice'));
	totalPrice.text((totalPrice.data('totalprice')).numberFormat()+'원');
}

function removeItem(e){
	let item = (e.currentTarget.parentElement.parentElement.parentElement.parentElement);
	//console.log("삭제할 아이템 : "+$(item));
	console.log($(item).data('cartno'));
}

function test(e){
	
	let itemLi = $(e.currentTarget.parentElement.parentElement.parentElement.parentElement);
	// 상품개수
	let count = $((e.currentTarget.parentElement)).find('input');
	//console.log();
	// 증가
	if($((e.currentTarget).children).attr('class').indexOf("right") != -1)
	{
		let change = (count.attr('value')*1)+1;
		count.attr('value', change);
	}
	// 감소
	else{
		let change = count.attr('value')-1;
		if(change<=0){change = 1;}
		count.attr('value', change);
	}
	
	let carItem = $(e.currentTarget.parentElement.parentElement);
	//  => 개수 * (상품가격+옵션가격)   =>  (1*count.attr('value')) * (prodPrice+optPrice)
	let prodPrice = carItem
			.find($('div[class="d-flex mb-2 fw-bold"]'))
			.find($('input[id="prodPrice"]'))
			.attr('value');
	let optPrice = carItem
			.find($('div[class="d-flex mb-2 fw-bold"]'))
			.find($('input[id="optPrice"]'))
			.attr('value');

	let itemPrice = ((1*prodPrice)+(1*optPrice))*count.attr('value');
	
	// 화면반영(장바구니 아이템 가격 ~~원)
	carItem.find($('span[class="ms-auto"]')).text((itemPrice).numberFormat()+'원');
	
	// 데이터 변경(다시 계산)	
	carItem.find($('span[class="ms-auto"]')).removeAttr('data-price');
	carItem.find($('span[class="ms-auto"]')).attr('data-price',itemPrice);
	
	// update 쿼리 요청
	// editCart.do
	let no = itemLi.data('cartno');
	let cnt = count.attr('value');
	let prc = itemPrice;
	let cvo = {no,cnt,prc};
	console.log("no = "+cvo.no+", cnt = "+cvo.cnt+", prc = "+cvo.prc);
	cartsvc.cartUpdate(cvo, result=>{
		console.log(result);
	},err => console.log(err));
	drawCart();	
}

// 숫자 3자리 콤마찍기
Number.prototype.numberFormat = function() {
	if (this == 0)
		return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) {
		nstr = nstr.replace(regex, '$1' + ',' + '$2');
	}
	return nstr;
};

