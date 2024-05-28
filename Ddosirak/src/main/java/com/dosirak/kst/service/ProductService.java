package com.dosirak.kst.service;

import java.util.List;
import java.util.Map;

import com.dosirak.common.vo.ProductVO;

// 비즈니스 로직
public interface ProductService {
	List<ProductVO> productList(String main_category);
	ProductVO getProduct(int product_code);
	List<Map<String,String>> getMainCat();
	List<String> getSubCat(String mainCat);
	List<Map<String,Integer>> getBestSeller();
	List<String> getOptionsForProduct(int code);
	String getName(int code);
	List<Map<String, Integer>> getOptionPricesForProduct(int code);
	List<Map<Integer, String>> getReview(int code);
	int getReviewCnt(int code);
	double getGradeAvg(int code);
}
