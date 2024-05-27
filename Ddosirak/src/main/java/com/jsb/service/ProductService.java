package com.jsb.service;

import java.util.List;
import java.util.Map;

import com.team.vo.ProductVO;

// 비즈니스 로직
public interface ProductService {
	List<ProductVO> productList(String main_category);
	ProductVO getProduct(int product_code);
	List<Map<String,String>> getMainCat();
	List<String> getSubCat(String mainCat);
	List<Map<String,Integer>> getBestSeller();
}
