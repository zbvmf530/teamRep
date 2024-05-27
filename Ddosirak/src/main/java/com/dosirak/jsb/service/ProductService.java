package com.dosirak.jsb.service;

import java.util.List;
import java.util.Map;

import com.dosirak.common.vo.ProductVO;

// 비즈니스 로직
public interface ProductService {
	List<ProductVO> productList();
	ProductVO getProduct(int product_code);
	List<Map<String,String>> getMainCat();
	List<String> getSubCat(String mainCat);
	List<Map<String,Integer>> getBestSeller();
}
