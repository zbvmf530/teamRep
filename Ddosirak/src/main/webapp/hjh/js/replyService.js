/**
 * replyService.js
 */
const svc = {
	// 댓글목록 => 페이지, 성공콜백, 실패콜백
	replyList(param = {}, successCall, errorCall) {
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(resolve => resolve.json()) // json -> 객체.
			.then(successCall)
			.catch(errorCall);
	},
	// 댓글등록 => 댓글정보, 성공콜백, 실패콜백
	addReply(param = {}, successCall, errorCall) {
		//fetch('addReply.do?bno=' + param.bno + '&replyer=' + param.writer + '&reply=' + param.reply)
		fetch('addReply.do', {
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'bno=' + param.bno + '&memberId=' + param.memberId + '&replyContent=' + param.replyContent
		})
			.then(resolve => resolve.json())
			.then(successCall)
			.catch(errorCall);
	},
	// 댓글삭제 => 삭제할번호, 성공콜백, 실패콜백
	removeReply(replyNo = 1, successCall, errorCall) {
		fetch('removeReply.do?rno=' + replyNo)
			.then(resolve => resolve.json())
			.then(successCall)
			.catch(errorCall);
	},
	// 댓글 전체건수
	getTotalCount(bno = 1, successCall, errorCall) {
		fetch('getTotalCnt.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successCall)
			.catch(errorCall);
	},	
	
	updateReply(param = {}, successCall, errorCall) {
		//fetch('updateReply.do?bno=' + param.bno + '&replyer=' + param.writer + '&reply=' + param.reply)
		fetch('updateReply.do?rno='+param.rno+'&replyContent='+param.replyContent)
//			method: 'post',
//			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
//			body: 'rno=' + param.rno + '&reply=' + param.reply
//		})
			.then(resolve => resolve.json())
			.then(successCall)
			.catch(errorCall);
	}
	
	
} // end of svc.