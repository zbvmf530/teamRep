package com.dosirak.kst.service;

import java.util.List;
import java.util.Map;

import com.dosirak.common.vo.ProductVO;

// 비즈니스 로직
public interface ProductService {
	List<ProductVO> productList(String main, String sub);
	ProductVO productOption(int code);
	ProductVO getProduct(int product_code);
	List<Map<String,String>> getMainCat();
	List<String> getSubCat(String mainCat);
	List<Map<String,Integer>> getBestSeller();
	List<Map<String, Integer>> getOptionsForProduct(int code);
	String getName(int code);
	List<Map<Integer, String>> getReview(int code);
	int getReviewCnt(int code);
	double getGradeAvg(int code);
	int getOptionPricesForProduct(int code, String option);
	String getImage(int code);
	int calculatePrice(int code);
}
