package com.dosirak.kst.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dosirak.common.vo.ProductVO;


@Mapper
public interface ProductMapper {
	List<ProductVO> productList(@Param("main") String main, @Param("sub") String sub);
	
	List<Map<String,String>> getMainCategory();
	List<String> getSubCategory(String mainCategory);
	List<Map<String,Integer>> getBestSeller();

	ProductVO getProduct(int productCode);

	List<Map<String, Integer>> getOptions(int code);

	String getName(int code);
	
	int getPrice(int code, String option);
	
	
	List<Map<Integer, String>> getReview(int code);
	int getReviewCnt(int code);
	double getGradeAvg(int code);

	String getImage(int code);

	int getOptionPrice(int code);

}
