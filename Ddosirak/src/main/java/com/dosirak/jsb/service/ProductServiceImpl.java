package com.dosirak.jsb.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.ProductVO;
import com.dosirak.jsb.mapper.ProductMapper;



public class ProductServiceImpl implements ProductService{
	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	

	@Override
	public List<ProductVO> productList() {
		return mapper.productList();
	}


	@Override
	public List<Map<String, String>> getMainCat() {
		// TODO Auto-generated method stub
		List<Map<String,String>> catList = mapper.getMainCategory();
		return catList;
	}


	@Override
	public List<String> getSubCat(String mainCat) {
		// TODO Auto-generated method stub
		return mapper.getSubCategory(mainCat);
	}


	@Override
	public List<Map<String,Integer>> getBestSeller() {
		// TODO Auto-generated method stub
		return mapper.getBestSeller();
	}


	@Override
	public ProductVO getProduct(int product_code) {
		// TODO Auto-generated method stub
		return mapper.getProduct(product_code);
	}


}
