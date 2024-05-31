/**
 * Btn.js
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

document.getElementById("confirmButton").addEventListener("click", function() {
	window.location.href = "http://localhost:8080/Ddosirak";
});

document.getElementById("wishButton").addEventListener("click", function() {
    var productCode = document.getElementById('prodCode').value;
	window.location.href = "wishList.do?code=${code}";
});

document.getElementById("jangButton").addEventListener("click", function() {
	window.location.href = "http://localhost:8080/Ddosirak";
});