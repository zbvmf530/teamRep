/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
	const stars = document.querySelectorAll(".star");
	const ratingInput = document.querySelector(".rating-value");

	stars.forEach(star => {
		star.addEventListener("click", function() {
			const rating = this.getAttribute("data-rating");
			ratingInput.value = rating;
			stars.forEach(s => {
				if (s.getAttribute("data-rating") <= rating) {
					s.classList.add("selected");
				} else {
					s.classList.remove("selected");
				}
			});
		});
	});
});