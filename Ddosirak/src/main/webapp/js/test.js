/**
 *  테스트용 빈 파일입니다. 각자 필요한 스크립트나 css를 각자의 폴더안에서 관리해주세요.
 */

$(document).ready(function() {
	$('#wishBtn').click(function() {
		$('#wishModal').modal('show');
	});
	$('#jangBtn').click(function() {
		$('#jangModal').modal('show');
	});
	$('#regiBtn').click(function() {
		$('#regiModal').modal('show');
	});

});

function updatePrice() {
	var selectedOption = $('#productOption').val();
	var code = '${code}';

	fetch(`productDetail.do?option=${selectedOption}&code=${code}`, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.json();
		})
		.then(data => {
			$('#productPrice').text(data + '원');
		})
		.catch(error => {
			$('#productPrice').text('가격 정보를 불러오는 중 오류가 발생했습니다.');
			console.error('There was a problem with the fetch operation:', error);
		});
}