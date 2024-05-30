package com.dosirak.jsb.mapper;

import java.util.List;
import java.util.Map;

import com.dosirak.common.vo.CategoryVO;
import com.dosirak.common.vo.ProductVO;



public interface ProductMapper {
	List<ProductVO> productList();
	
	List<Map<String,String>> getMainCategory();
	List<String> getSubCategory(String mainCategory);
	List<Map<String,Integer>> getBestSeller();
	
	List<CategoryVO> getNavMenu();
	ProductVO getProduct(int productCode);
}
