package com.dosirak.kst.mapper;

import java.util.List;
import java.util.Map;

import com.dosirak.common.vo.ProductVO;



public interface ProductMapper {
	List<ProductVO> productList(String mainCategory);
	
	List<Map<String,String>> getMainCategory();
	List<String> getSubCategory(String mainCategory);
	List<Map<String,Integer>> getBestSeller();

	ProductVO getProduct(int productCode);

	List<Map<String, Integer>> getOptions(int code);

	String getName(int code);
	
	List<Map<String, Integer>> getPrice(int code);
	
	
	List<Map<Integer, String>> getReview(int code);
	int getReviewCnt(int code);
	double getGradeAvg(int code);

}
