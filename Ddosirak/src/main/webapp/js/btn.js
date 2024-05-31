/**
 * Btn.js
 */

$(document).ready(function() {
    console.log("btn.js 호출");
    
    // 이벤트 위임을 사용하여 동적으로 생성된 버튼 클릭 이벤트 처리
    $(document).on('click', '#wishMiniBtn', function() {
        alert("위시리스트 추가완료!");
    });

    $(document).on('click', '#jangMiniBtn', function() {
        alert("장바구니 추가완료!");
    });

    // 다른 기존 버튼 이벤트 처리 코드
    $('#wishBtn').click(function() {
        $('#wishModal').modal('show');
    });

    $('#jangBtn').click(function() {
        $('#jangModal').modal('show');
    });

    $('#regiBtn').click(function() {
        $('#regiModal').modal('show');
    });

    document.getElementById("confirmButton").addEventListener("click", function() {
        window.location.href = "http://localhost:8080/Ddosirak";
    });

    document.getElementById("wishButton").addEventListener("click", function() {
        var productCode = document.getElementById('prodCode').value;
        window.location.href = "wishList.do?code=" + productCode;
    });

    document.getElementById("jangButton").addEventListener("click", function() {
        window.location.href = "http://localhost:8080/Ddosirak";
    });
});