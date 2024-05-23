package com.team.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jsb.service.ProductService;
import com.jsb.service.ProductServiceImpl;
import com.team.vo.ProductVO;



public class SqlTest {
	public static void main(String[] args) {

		ProductService svc = new ProductServiceImpl();
		List<Map<String,String>> maincat = svc.getMainCat();

		// 주문수 많은 순으로 상품코드 가져오는 코드
		List<Map<String,Integer>> bestsellers = svc.getBestSeller();  
		List<Integer> bestItems = new ArrayList<>();
		for(Map<String,Integer> bs : bestsellers) {bestItems.add(Integer.parseInt(String.valueOf(bs.get("PRODUCT_CODE"))));}
		
		
		// 주문수 많은 상품코드로 상품정보 불러오는 코드
		List<ProductVO> bestProducts = new ArrayList<>(); 
		for(Integer prodCode: bestItems) 
		{bestProducts.add(svc.getProduct(prodCode));}
		bestProducts.forEach(item->System.out.println(item));
		
		// 상단 네비메뉴 구성용 코드
		List<String>catList = new ArrayList<>();
		for (Map<String, String> cat : maincat) {
			catList.add(cat.get("MAIN_CATEGORY"));
		}
		
		Map<String,List<String>> TotalList = new HashMap<>();
		
		for(String main: catList) {
			List<String> subcategory = svc.getSubCat(main);
			TotalList.put(main, subcategory);
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(TotalList);
		System.out.println(json);
	
		
	}
}