<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<h3>리뷰작성페이지</h3>
<div class="review-intake-form__rating" style="">
	<div class="review-table" style="">
		<div class="review-table__cell review-intake-head title" style="">
			<img src="/testimages/${prodImg }" width="100" height="100"
				title="${prodName }">
		</div>
		<div class="review-table__cell description" style="">
			<div class="review-intake-form__product-title" style="">${prodName }
			</div>
		</div>
		<div class="review-intake-form__rating" style="">
			<div class="star-rating">
				<span class="star" data-rating="1">&#9733;</span> 
				<span class="star" data-rating="2">&#9733;</span>
				<span class="star" data-rating="3">&#9733;</span>
				<span class="star" data-rating="4">&#9733;</span>
				<span class="star" data-rating="5">&#9733;</span>
				<input type="hidden" name="rating" class="rating-value" value="1">
			</div>
		</div>
	</div>
</div>
<div class="review-intake-form__detail-review" style="">


	<div class="my-review__modify__review" style="">
		<div class="my-review__modify__field__title" style="">상세리뷰</div>

		<div class="my-review__modify__review__content" style="">

			<div class="my-review__modify__review__content__text-wrap" style="">
				<textarea
					class="my-review__modify__review__content__text-area js_reviewModifyTextArea"
					placeholder="솔직한 리뷰 작성해주세요.." rows="5"
					style="width: 506.5px; height: 206.5px;"></textarea>
			</div>
		</div>
	</div>

	<div class="review-intake-register" style="">
		<button class="btn btn-secondary" type="button" style="">취소하기</button>
		<button class="btn btn-success" type="button" id="regiBtn" style="">등록하기</button>
		<div class="modal" id="regiModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">알림</h4>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<div class="modal-body">리뷰작성 완료!</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal" id="confirmButton">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>


</div>
