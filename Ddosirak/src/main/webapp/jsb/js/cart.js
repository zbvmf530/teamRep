

$(document).ready(initCart);


function initCart(){	
	let cartList = $('ul[id="cartlist"]');
	let cartItemFormat = $('ul[id="cartlist"]').find('li');
	
	$(document).find($('span[class="ms-auto fs-sm"]')).text('0');
	$(document).find($('span[class="ms-auto fs-sm"]')).attr('data-totalprice',0);
	
	cartsvc.cartList(result=>{
		//console.log(result);
		$.each(result,function(idx,item){
			
			let cartItem = cartItemFormat.clone();
			cartItem.removeAttr('hidden');
			//console.log(item['price']);
			//console.log(item['productCode']);
			
			cartList.append(cartItem);
			
			//console.log(cartItem.find($('p[class="mb-7 fs-sm text-muted"]')));
			cartsvc.optionList(item['optionCode'],result=>{
													cartItem.find($('p[class="mb-7 fs-sm text-muted"]'))
													.text(result['optionName']);
													
													cartItem.find($('div[class="d-flex mb-2 fw-bold"]'))
													.find($('input[id="optPrice"]'))
													.attr('value',result['optionPrice']);
													});
													
			cartsvc.productList(item['productCode'],result=> 
													cartItem.find($('div[class="d-flex mb-2 fw-bold"] a'))
													.text(result['productName']));
													
													cartItem.find($('div[class="d-flex mb-2 fw-bold"]'))
													.find($('input[id="prodPrice"]'))
													.attr('value',result['price']);
													
			// 옵션 fetch item['optionCode']
			cartItem.find($('span[class="ms-auto"]')).text((item['price']).numberFormat()+'원');
			cartItem.find($('span[class="ms-auto"]')).attr('data-price',item['price']);
			
			// 상품 이름 div
			//console.log(cartItem.find($('div[class="d-flex mb-2 fw-bold"]')).find($('input')));
			// 상품 개수 div
			cartItem.find($('div[class="d-flex align-items-center"]'))
			.find($('[id="optPrice"]')).attr('value',item['count']);
			
			calcTotalPrice();
			
		});
	});
	
	
	//console.log($('ul[id="cartlist"]').find('li'));
}
function calcTotalPrice(){
	let totalPrice = $(document).find($('span[class="ms-auto fs-sm"]'));
	//let pricevalue = totalPrice.data('totalprice');
	//console.log(pricevalue);
	let cartList = $('ul[id="cartlist"]');
	let sum = 0;
	//console.log(cartList.find('li'));
	cartList.find('li').each(function(idx,item){
		if($(item).is(':hidden')){}
		else{
			let itemprice = $(item).find($('span[class="ms-auto"]')).data('price');
			sum += itemprice;
		}
	});
	totalPrice.data('totalprice',sum);
	totalPrice.text(totalPrice.data('totalprice').numberFormat()+'원');
	//console.log('sum = ' + sum);
}

function test(e){
	//console.log($((e.currentTarget).children).attr('class').indexOf("right") != -1);
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
		if(change<=0){change = 0;}
		count.attr('value', change);
	}
	
	let carItem = $(e.currentTarget.parentElement.parentElement);
	// (1*count.attr('value'))
	
	// 화면반영(장바구니 아이템 가격 ~~원)
	carItem
			.find($('span[class="ms-auto"]')).text().numberFormat()+'원';

	// 데이터 변경(다시 계산)	
	//  => 개수 * (상품가격+옵션가격)   =>  (1*count.attr('value')) * (prodPrice)
	let prodPrice = carItem
			.find($('div[class="d-flex mb-2 fw-bold"]'))
			.find($('input[id="prodPrice"]'))
			.attr('value');
	/*carItem
			.find($('span[class="ms-auto"]'))
			.attr('data-price');
*/	
	
	console.log("상품가격 : "+prodPrice);
	console.log("옵션가격 : "+carItem
				.find($('div[class="d-flex mb-2 fw-bold"]'))
				.find($('input[id="optPrice"]'))
				.attr('value'));
	
	//(1*count.attr('value'))
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

let basket = {
	cartCount: 0, // 전체수량.
	cartTotal: 0, // 전체금액.

	list: function() {
		// 목록.
		
		 cartsvc.cartList(
			result=>{
				//console.log(result);
				result.forEach(cart=>{
					const rowDiv = document.querySelector('div[data-id = "0"]').cloneNode(true);
					rowDiv.style.display = 'block';
					rowDiv.setAttribute('data-id',cart.no);
					rowDiv.querySelector('div.img>img').setAttribute('src','images/'+cart.productNm+'.jpg');
					rowDiv.querySelector('div.pname>span').innerText = cart.productNm;
					
					rowDiv.querySelector('div.basketprice').childNodes[2].textContent = cart.price.numberFormat()+'원';
					rowDiv.querySelector('div.basketprice input').value = cart.price;
					
					rowDiv.querySelector('div.basketprice input').setAttribute('id','p_price'+cart.no);
					
					rowDiv.querySelector('div.updown input').value = cart.qty;
					rowDiv.querySelector('div.updown input').setAttribute('id','p_num'+cart.no);
					// event
					rowDiv.querySelector('div.updown input').onkeyup = () => basket.changePNum(cart.no);
					rowDiv.querySelector('div.updown span').onclick = () => basket.changePNum(cart.no);
					rowDiv.querySelector('div.updown span:nth-of-type(2)').onclick = () => basket.changePNum(cart.no);
					
					//개별합계
					rowDiv.querySelector('div.sum').textContent = (cart.qty*cart.price).numberFormat()+'원';
					rowDiv.querySelector('div.sum').setAttribute('id','p_sum'+cart.no);
					//console.log(document.querySelector('div.updown input'));
					document.querySelector('#basket').append(rowDiv);
					
					// 총 합계 계산
					basket.cartCount += cart.qty;
					basket.cartTotal += cart.qty*cart.price;
					
				});
				basket.reCalc();
			},
			err=>{}
		 )
	},

	delItem: function() {
		let delRow = event.target.parentElement.parentElement.parentElement;
		let delPrice = delRow.querySelector('div.basketprice input').value;
		let delCount = delRow.querySelector('div.updown input').value;
		cartsvc.cartRemove(delRow.dataset.id,
			result => {
				if (result.retCode == 'OK') 
				{
					basket.cartCount-= delCount;
					basket.cartTotal -= delPrice*delCount;
					basket.reCalc();
					delRow.remove();
				}
				else if (result.retCode == 'NG') { alert('삭제실패'); }
				else { alert('알수 없는 반환값'); }
			},
			err => console.log(err)
		);
	},

	reCalc: function() {
		//수량, 금액 합계 계산
		//합계 자리에 출력
		document.querySelector('#sum_p_num span').textContent = basket.cartCount;
		document.querySelector('#sum_p_price span').textContent = basket.cartTotal.numberFormat();
	},

	changePNum: function(no) { 
		console.log(event);
		let qty = -1;
		if (event.target.nodeName == "I") {
			if (event.target.className.indexOf("up") != -1) {
				qty=1;
			}
		}
		else if(event.target.nodeName == "INPUT"){
			if(event.key == "ArrowUp"){
				qty=1;
			}
		}
		let price = document.querySelector('#p_price'+no).value;
		let qtyElm = document.querySelector('#p_num'+no);
		let sumElem = document.querySelector('#p_sum'+no);
		
		let cvo = {no,qty};
		cartsvc.cartUpdate(cvo,
			result => {
				console.log(result);
				qtyElm.value=parseInt(qtyElm.value)+qty; //수량변경
				sumElem.innerText = (price*qtyElm.value).numberFormat()+'원';
				basket.cartCount+=qty;
				basket.cartTotal+=(price*qty);
				basket.reCalc();
				 },
			err => console.log(err)
		);
		
	},

	delCheckedItem: function() {
		 let inputs = document.querySelectorAll("#basket div.row.data:not([style='display: none;']) input:checked");
		 console.log(inputs);
		 for(let cart of inputs){
			let delRow = cart.parentElement.parentElement.parentElement;
			let delPrice = delRow.querySelector('div.basketprice input').value;
			let delCount = delRow.querySelector('div.updown input').value;
			
			cartsvc.cartRemove(cart.parentElement.parentElement.parentElement.dataset.id,
				result=>{
					
					if(result.retCode == 'OK'){
						// 가격계산
						basket.cartCount-=delCount;
						basket.cartTotal-=(delPrice*delCount);
						// 지우고
						delRow.remove();
						// 가격반영(총 개수, 총 가격)
						basket.reCalc();
					}
				},
				err=>console.log(err)
			);
		 }
	},

	delAllItem: function() {
		 
	},
};

basket.list();
