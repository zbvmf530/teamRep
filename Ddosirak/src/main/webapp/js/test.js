/**
 *  테스트용 빈 파일입니다. 각자 필요한 스크립트나 css를 각자의 폴더안에서 관리해주세요.
 */
function updatePrice() {
	var selectedOption = $('#productOption').val();
	var productId = '${code}';

	$.ajax({
		url: 'getOptionPrice',
		type: 'GET',
		data: {
			option: selectedOption,
			productId: productId
		},
		dataType: 'json',
		success: function(price) {
			$('#productPrice').text(price + '원');
		},
		error: function() {
			$('#productPrice').text('가격 정보를 불러오는 중 오류가 발생했습니다.');
		}
	});
}