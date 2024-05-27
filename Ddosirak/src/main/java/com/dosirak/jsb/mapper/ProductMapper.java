package com.dosirak.jsb.mapper;

import java.util.List;
import java.util.Map;

import com.team.vo.ProductVO;



public interface ProductMapper {
	List<ProductVO> productList(String mainCategory);
	
	List<Map<String,String>> getMainCategory();
	List<String> getSubCategory(String mainCategory);
	List<Map<String,Integer>> getBestSeller();

	ProductVO getProduct(int productCode);
}
