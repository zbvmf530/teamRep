/**
 * 
 */

 
 const svc = {
	// 댓글목록 => 페이지, 성공콜백, 실패콜백
	getnavMenu(successCall, errorCall) {
		fetch('menuList.do')
			.then(resolve => resolve.json()) // json -> 객체.
			.then(successCall)
			.catch(errorCall);
	}
}