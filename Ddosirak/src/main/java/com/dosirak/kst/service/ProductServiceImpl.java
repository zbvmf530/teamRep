package com.dosirak.kst.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.dosirak.common.DataSource;
import com.dosirak.common.vo.ProductVO;
import com.dosirak.kst.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService {

	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);

	@Override
	public List<Map<String, String>> getMainCat() {
		// TODO Auto-generated method stub
		List<Map<String, String>> catList = mapper.getMainCategory();
		return catList;
	}

	@Override
	public List<String> getSubCat(String mainCat) {
		// TODO Auto-generated method stub
		return mapper.getSubCategory(mainCat);
	}

	@Override
	public List<Map<String, Integer>> getBestSeller() {
		// TODO Auto-generated method stub
		return mapper.getBestSeller();
	}

	@Override
	public ProductVO getProduct(int product_code) {
		// TODO Auto-generated method stub
		return mapper.getProduct(product_code);
	}

	@Override
	public List<ProductVO> productList(String main, String sub) {
		return mapper.productList(main, sub);
	}

	@Override
	public String getName(int code) {
		// TODO Auto-generated method stub
		return mapper.getName(code);
	}

	@Override
	public List<Map<Integer, String>> getReview(int code) {
		// TODO Auto-generated method stub
		return mapper.getReview(code);
	}

	@Override
	public int getReviewCnt(int code) {
		// TODO Auto-generated method stub
		return mapper.getReviewCnt(code);
	}

	@Override
	public double getGradeAvg(int code) {
		// TODO Auto-generated method stub
		/*
		 * return mapper.getGradeAvg(code);
		 */		
		Double gradeAvg = mapper.getGradeAvg(code);
		return (gradeAvg != null) ? gradeAvg : 0.0;
	}

	@Override
	public int getOptionPricesForProduct(int code, String option) {
		// TODO Auto-generated method stub
		return mapper.getPrice(code, option);
	}

	@Override
	public List<Map<String, Integer>> getOptionsForProduct(int code) {
		// TODO Auto-generated method stub
		return mapper.getOptions(code);
	}

	@Override
	public ProductVO productOption(int code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage(int code) {
		// TODO Auto-generated method stub
		return mapper.getImage(code);
	}

	@Override
	public int calculatePrice(int code) {
		// TODO Auto-generated method stub
		return mapper.getOptionPrice(code);
	}

}
