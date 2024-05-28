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
