/**
 * board.js
 */
//수정버튼
document.querySelector('#modBtn').addEventListener('click', function() {	
	document.forms.myFrm.action = "modBoardForm.do"; //수정화면 호출
	document.forms.myFrm.submit();
})


//삭제버튼
document.querySelector('#delBtn').addEventListener('click', function() {
	if(confirm("삭제하시겠습니까?")== true){
		document.forms.myFrm.action = "deleteBoard.do";
		alert('삭제되었습니다'); //삭제화면 호출
	}
	
})

//댓글목록 출력

let page = 1;
showList();
function showList() {
	//댓글목록 초기화
	document.querySelectorAll('div.content ul li').forEach((li, idx) => {
		if (idx >= 1) {
			li.remove();
		}
	})
	svc.replyList({ bno: bno, page: page },
		result => {
			console.log(result);
			result.forEach(reply => {
				const row = makeRow(reply);
				document.querySelector('div.reply ul').appendChild(row);
			})
		
		},
		err => {
			console.log(err);
		}//세번째 param
	)//end of replyList
} //end of showList

//삭제버튼 이벤트
function deleteRow(e) {
	const rno = e.target.parentElement.parentElement.dataset.rno; //숫자 가져오기
	console.log("삭제는" + rno);
	svc.removeReply(rno,
		result => {
			if (result.retCode == 'OK') {
				if (confirm("삭제하시겠습니까?") == true) {
					alert('삭제되었습니다'); //삭제화면 호출
					showList();
				}
			} else if (result.retCode == 'NG') {
				alert('수정실패')
			} else {
				alert('알수없는 반환값')
			}
		})
		, err => cosnsole.log(err);
}
//수정
function updateRow(e) {
	const rno = e.target.parentElement.parentElement.dataset.rno; //숫자 가져오기
	const reply = e.target.parentElement.parentElement.dataset.reply; //숫자 가져오기
	console.log("댓글번호는" + rno);
	console.log("내용은" + reply);
	svc.updateReply({ rno,writer,reply },
		result => {
			if (result.retCode == 'OK') {
				
					alert('수정되었습니다'); //삭제화면 호출
					showList();
				
			} else if (result.retCode == 'NG') {
				alert('삭제실패')
			} else {
				alert('알수없는 반환값')
			}
		})
		, err => cosnsole.log(err);
}
//등록
$('#addReply').on('click',function(){
	let reply = $('#reply').val();
	if(!reply){
		alert('댓글을 입력하세요');
		return;
	}
//	if(!writer){
//		alert('로그인하세요');
//		return;
//	}
	svc.addReply({ bno,writer,reply },
		result => {
			if (result.retCode == 'OK') {
				alert('등록되었습니다');
				page = 1;
				showList();
				$('#reply').val('');
			
			}
		}
		, err => console.log(err));
})


//row생성을 함수에 담은것
function makeRow(reply = {}) {
	let tmpl = document.querySelector('div.reply li:nth-of-type(1)').cloneNode(true);
	console.log("tmpl"+tmpl);
	tmpl.style.display = 'block';
	tmpl.setAttribute('data-rno', reply.replyNo);
	tmpl.querySelector('span:nth-of-type(1)').innerText = reply.memberId;
	tmpl.querySelector('span:nth-of-type(2)').innerText = reply.replyDate;
	tmpl.querySelector('span:nth-of-type(3)').innerText = reply.replyContent;
	return tmpl;
}
let pagination = document.querySelector('div.pagination');
function  makePageInfo(){
	svc.getTotalCount(bno //param1
	,createPageList//param2
	,err=>console.log(err))
}
function createPageList(result) {
	console.log(result);
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;

	
	realEnd = Math.ceil(totalCnt / 5);

	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;
	next = endPage < realEnd;

	console.log(startPage, endPage, realEnd, prev, next);

	//a태그 생성
	pagination.innerHTML = '';
	//이전페이지 여부
	if (prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', startPage - 1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&laquo;";  //<표시
		pagination.appendChild(aTag);
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); //a태그는 페이지이동

			page = e.target.dataset.page; //
			showList();
		})
		pagination.appendChild(aTag);
	}
	for (let pg = startPage; pg <= endPage; pg++) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', pg);
		aTag.setAttribute('href', '#');
		if (pg == page) {
			aTag.className = 'active';
		}
		aTag.innerHTML = pg;
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); //a태그는 페이지이동

			page = e.target.dataset.page; //
			showList();
		})
		pagination.appendChild(aTag);
	}
	//이후페이지 여부
	if (next) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', endPage + 1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&raquo;";  //>표시
		pagination.appendChild(aTag);
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); //a태그는 페이지이동

			page = e.target.dataset.page; //
			showList();
		})
		pagination.appendChild(aTag);
	}
}



